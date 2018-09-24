package com.mingrn.wechat.official.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Sha1 工具类,设置为默认权限.不直接对外提供调用
 * Read the website in detail:
 * <url>http://www.sha1-online.com/sha1-java/<url/>
 *
 * @author MinGRn <br > 18/09/2018 15:50
 * @email MinGRn97@gmail.com
 * @see #getSha1OfText 文本生成 Sha1
 * @see #getSha1OfFile 文件生成 Sha1
 */
class Sha1Util {

	private Sha1Util() {
	}

	/**
	 * 字符生成 Sha1
	 *
	 * @param sha1Str java.lang.String
	 * @return java.lang.String
	 * @throws NoSuchAlgorithmException
	 */
	public static String getSha1OfText(String sha1Str) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
		byte[] result = mDigest.digest(sha1Str.getBytes());
		StringBuilder sb = new StringBuilder();
		for (byte b : result) {
			sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}


	/**
	 * 文件生成 Sha1
	 *
	 * @param filePath and name of a file that is to be verified
	 * @return java.lang.String
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static String getSha1OfFile(String filePath) throws NoSuchAlgorithmException, IOException {

		MessageDigest sha1 = MessageDigest.getInstance("SHA1");
		FileInputStream fis = new FileInputStream(filePath);

		byte[] data = new byte[1024];
		int read = 0;
		while ((read = fis.read(data)) != -1) {
			sha1.update(data, 0, read);
		}

		StringBuilder sb = new StringBuilder();
		byte[] hashBytes = sha1.digest();
		for (byte hashByte : hashBytes) {
			sb.append(Integer.toString((hashByte & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}
}
