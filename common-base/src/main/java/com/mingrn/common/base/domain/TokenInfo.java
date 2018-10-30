package com.mingrn.common.base.domain;

import java.io.Serializable;

/**
 * Token
 *
 * @author MinGRn
 */
public class TokenInfo implements Serializable {
	/**
	 * 加密以后的密钥
	 */
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}

