package com.mawen.think.in.framework.step5.framework.exception;

/**
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 2024/6/4
 */
public class FrameworkException extends RuntimeException {

	public FrameworkException(String message) {
		super(message);
	}

	public FrameworkException(Throwable cause) {
		super("Unknown Exception", cause);
	}
}
