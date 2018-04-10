package com.qitfstring;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;


/**
 * 创建日期:2017年12月18日 
 * 创建时间:下午10:44:58 
 * 创建者 :yellowcong 
 * 机能概要:用于传递给CAS服务器验证数据
 */
public class CasUser {
	
	@JsonProperty("id")
	private String username;
	
	@JsonProperty("@class")
	// 需要返回实现org.apereo.cas.authentication.principal.Principal的类名接口
	private String clazz = "org.apereo.cas.authentication.principal.SimplePrincipal";
	
	@JsonProperty("attributes")
	private Map<String, Object> attributes = new HashMap<String,Object>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
}
