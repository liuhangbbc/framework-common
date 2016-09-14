package com.raindrop.common.exception;

public class AppException extends RuntimeException {
	
	/**
	 * 异常序列号
	 */
	private static final long serialVersionUID = 5650449630275601494L;
	
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public AppException() {
		super();
	}

	public AppException(String message) {
		super(message);
	}

	public AppException(String code, String message) {
		super(message);
		this.code = code;
	}

	public AppException(Throwable cause) {
		super(cause);
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

}
