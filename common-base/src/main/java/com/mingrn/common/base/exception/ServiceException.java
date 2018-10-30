package com.mingrn.common.base.exception;


/**
 * 服务(业务)异常如 "账号或密码错误"
 *
 * @author MinGRn
 */
public class ServiceException extends RuntimeException {

	public ServiceException() {
		super();
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
