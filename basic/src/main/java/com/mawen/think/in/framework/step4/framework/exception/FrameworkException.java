package com.mawen.think.in.framework.step4.framework.exception;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/3
 */
public class FrameworkException extends RuntimeException {

	public FrameworkException(String message) {
		super(message);
	}

	public FrameworkException(Throwable cause) {
		super("Unknown exception", cause);
	}
}
