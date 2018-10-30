package com.mingrn.common.base.utils;

/**
 * 只适用于jwt格式的token工具类
 */
public class TokenUtil {

	private final static int INDEX = 3;

	/**
	 * 解析token，返回payload，即token包含的信息，形如:{"userId":"12345"}
	 * 注意：该方法只解析token的有效性，不校验token的有效性！
	 */
	public static String parseToken(String token) {
		if (token == null) {
			return null;
		}
		String[] str = token.split("\\.");
		if (str.length != INDEX) {
			return null;
		}
		return EncryptUtil.decodeBase64(str[1]);
	}
}
