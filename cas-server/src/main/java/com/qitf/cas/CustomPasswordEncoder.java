package com.qitf.cas;

import java.math.BigInteger;
import java.security.MessageDigest;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 自定义密码加密规则，暂时没用
 */
public class CustomPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence password) {
		try {
			//给数据进行md5加密
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.toString().getBytes());
			return new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 调用这个方法来判断密码是否匹配
	 */
	@Override
	public boolean matches(CharSequence rawPassword, String encodePassword) {
		// 判断密码是否存在
		if (rawPassword == null) {
			return false;
		}

		//通过md5加密后的密码
		String pass = this.encode(rawPassword.toString());
		//比较密码是否相等的问题
		return pass.equals(encodePassword);
	}
}
