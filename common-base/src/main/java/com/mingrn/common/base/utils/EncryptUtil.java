package com.mingrn.common.base.utils;

import com.mingrn.common.base.constants.Constant;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * 加密类,默认使用SHA-256加盐加密
 *
 * @author MinGRn
 */
public class EncryptUtil {
	private EncryptUtil() {
	}

	/**
	 * 对加密字符增加符号
	 */
	private final static String SALT = "!@#";


	/**
	 * 使用MD5加密且加盐
	 */
	public static String encryptWithMD5(String strSrc) {
		return encrypt(strSrc + SALT, EncryptTypeEnum.MD5);

	}

	/**
	 * 使用SHA-256加密且加盐
	 */
	public static String encryptWithSHA256(String strSrc) {
		return encrypt(strSrc + SALT, EncryptTypeEnum.SHA256);

	}

	/**
	 * 使用SHA-1加密,用户密码加密时使用
	 * 规则:encryptWithSHA1(username().trim().toUpperCase().concat(password))
	 */
	public static String encryptWithSHA1(String strSrc) {
		return encrypt(strSrc, EncryptTypeEnum.SHA1);
	}


	/**
	 * base64解码
	 *
	 * @param str 解码字符串
	 */
	public static String decodeBase64(String str) {
		return new String(Base64.getDecoder().decode(str), Charset.forName(Constant.DEFAULT_CHARSET));
	}


	/**
	 * 对字符串加密,加密算法使用MD5,SHA-1,SHA-256,默认使用SHA-256
	 *
	 * @param strSrc 要加密的字符串
	 * @param encryptTypeEnum 加密类型  MD5,SHA-1,SHA-256
	 */
	private static String encrypt(String strSrc, EncryptTypeEnum encryptTypeEnum) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance(encryptTypeEnum.type);
			byte[] array = md.digest(strSrc.getBytes());
			StringBuilder sb = new StringBuilder();
			for (byte anArray : array) {
				sb.append(Integer.toHexString((anArray & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
			// TODO: 19/10/2018 异常处理
		}
		return null;
	}


	private enum EncryptTypeEnum {
		/**
		 * MD5 加密
		 */
		MD5("MD5"),
		/**
		 * SHA-1 加密
		 */
		SHA1("SHA-1"),

		/**
		 * SHA-256 加密
		 */
		SHA256("SHA-256");

		private String type;

		EncryptTypeEnum(String type) {
			this.type = type;
		}
	}
}
