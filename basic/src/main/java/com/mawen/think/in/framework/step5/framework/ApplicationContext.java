package com.mawen.think.in.framework.step5.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.mawen.think.in.framework.step5.framework.annotation.Autowired;
import com.mawen.think.in.framework.step5.framework.annotation.Component;
import com.mawen.think.in.framework.step5.framework.exception.FrameworkException;
import org.reflections.Reflections;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/4
 */
public class ApplicationContext {

	private final Set<Class<?>> componentBeans;

	public ApplicationContext(Class<?> appClass) {
		final Reflections reflections = new Reflections(appClass.getPackage().getName());
		this.componentBeans = reflections.getTypesAnnotatedWith(Component.class)
				.stream()
				.filter(clazz -> !clazz.isInterface())
				.collect(Collectors.toSet());
	}

	public <T> T getBean(Class<T> clazz) {
		if (!clazz.isInterface()) {
			throw new FrameworkException("Class " + clazz.getName() + " should be interface");
		}

		Class<T> implementation = findImplementationByInterface(clazz);
		return createBean(clazz, implementation);
	}

	@SuppressWarnings("unchecked")
	private <T> Class<T> findImplementationByInterface(Class<T> interfaceItem) {
		final Set<Class<?>> classesWithInterfaces = componentBeans.stream()
				.filter(componentBean -> List.of(componentBean.getInterfaces()).contains(interfaceItem))
				.collect(Collectors.toSet());

		if (classesWithInterfaces.size() > 1) {
			throw new FrameworkException("Found more than one implementation: " + interfaceItem.getName());
		}

		return (Class<T>) classesWithInterfaces.stream()
				.findFirst()
				.orElseThrow(() -> new FrameworkException("This is no class with interface: " + interfaceItem.getName()));
	}

	private <T> T createBean(Class<T> clazz, Class<T> implementation) {
		try {
			final Constructor<T> constructor = findConstructor(implementation);
			final Object[] parameters = findConstructorParameters(constructor);
			final T bean = constructor.newInstance(parameters);

			final Object proxy = Proxy.newProxyInstance(ApplicationContext.class.getClassLoader(),
					new Class[] {clazz},
					new ProxyHandler(bean));
			return clazz.cast(proxy);
		}
		catch (FrameworkException e) {
			throw e;
		}
		catch (Exception e) {
			throw new FrameworkException(e);
		}
	}

	private <T> Constructor<T> findConstructor(Class<T> clazz) {
		final Constructor<T>[] constructors = (Constructor<T>[]) clazz.getConstructors();
		if (constructors.length == 1) {
			return constructors[0];
		}

		final Set<Constructor<T>> constructorsWithAnnotation = Arrays.stream(constructors)
				.filter(constructor -> constructor.isAnnotationPresent(Autowired.class))
				.collect(Collectors.toSet());

		if (constructorsWithAnnotation.size() > 1) {
			throw new FrameworkException("Found more than one constructor with Autowired annotation: " + clazz.getName());
		}

		return constructorsWithAnnotation.stream()
				.findFirst()
				.orElseThrow(() -> new FrameworkException("This is no constructor with Autowired annotation: " + clazz.getName()));
	}

	private <T> Object[] findConstructorParameters(Constructor<T> constructor) {
		final Class<?>[] parameterTypes = constructor.getParameterTypes();
		return Arrays.stream(parameterTypes)
				.map(this::getBean)
				.toArray(Object[]::new);
	}
}
