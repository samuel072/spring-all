package com.kaiji.exhandler;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -6361139360638332033L;

	public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
