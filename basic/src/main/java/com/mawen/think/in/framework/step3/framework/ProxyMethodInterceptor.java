package com.mawen.think.in.framework.step3.framework;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/3
 */
public class ProxyMethodInterceptor implements MethodInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(ProxyMethodInterceptor.class);

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		try {
			beginTransaction();
			final Object result = methodProxy.invokeSuper(o, objects);
			commitTransaction();
			return result;
		}
		catch (Exception e) {
			rollbackTransaction();
			throw e;
		}
	}

	private void beginTransaction() {
		logger.debug("begin transaction");
	}

	private void commitTransaction() {
		logger.debug("commit transaction");
	}

	private void rollbackTransaction() {
		logger.debug("rollback transaction");
	}
}
