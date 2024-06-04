package com.mawen.think.in.framework.step5.framework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/4
 */
public class ProxyHandler implements InvocationHandler {

	private static final Logger logger = LoggerFactory.getLogger(ProxyHandler.class);

	private final Object objectToHandle;

	public ProxyHandler(Object objectToHandle) {
		this.objectToHandle = objectToHandle;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			beginTransaction();
			final Object result = method.invoke(objectToHandle, args);
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
