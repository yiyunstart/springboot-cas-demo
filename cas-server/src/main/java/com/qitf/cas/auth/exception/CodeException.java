package com.qitf.cas.auth.exception;

import javax.security.auth.login.AccountExpiredException;

public class CodeException extends AccountExpiredException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CodeException() {
		super();
	}

	public CodeException(String msg) {
		super(msg);
	}
}
