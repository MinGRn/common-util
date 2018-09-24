package com.mingrn.wechat.official.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 验证 WeChat Official 签名认证工具类
 *
 * @author MinGRn
 * @email MinGRn97@gmail.com
 * @see #checkSignature 微信服务器签名验证
 */
public class CheckSignatureUtil {

	private CheckSignatureUtil() {
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(CheckSignatureUtil.class);

	/**
	 * 微信服务器签名验证
	 *
	 * @param token 开发者服务器设置明文 TOKEN,并非 Assess_Token
	 * @param signature 微信加密签名
	 * @param timestamp 时间戳
	 * @param nonce 随机数
	 * @return java.lang.Boolean
	 * @throws NoSuchAlgorithmException
	 * @email MinGRn97@gmail.com
	 * @author MinGRn
	 */
	public static Boolean checkSignature(String token, String signature, String timestamp, String nonce) {

		String[] array = {token, timestamp, nonce};
		Arrays.sort(array);

		StringBuilder sb = new StringBuilder();
		for (String s : array) {
			sb.append(s);
		}
		try {
			String temp = Sha1Util.getSha1OfText(sb.toString());
			return temp.equals(signature);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("CheckUtil.checkSignature >>", e);
		}
		return false;
	}
}
