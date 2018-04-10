package com.qitf.auth;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apereo.cas.authentication.RememberMeUsernamePasswordCredential;
import javax.validation.constraints.Size;

/**
 * 用户名，密码，验证码
 */
public class UsernamePasswordCodeCredential extends RememberMeUsernamePasswordCredential {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Size(min = 4, message = "验证码补鞥呢小雨")
	private String code;

	public String getCode() {
		return code;
	}

	public UsernamePasswordCodeCredential setCode(String code) {
		this.code = code;
		return this;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().appendSuper(super.hashCode()).append(this.code).toHashCode();
	}
}