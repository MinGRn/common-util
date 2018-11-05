package com.mingrn.common.arithmetic.hexadecimal;

/**
 * 进制转换
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 30/10/2018 17:27
 */
public class HexadecimalConvert {

	private HexadecimalConvert() {
	}

	/**
	 * 将字符串转成unicode
	 *
	 * @param str 待转字符串
	 * @return unicode字符串
	 */
	private static String string2Unicode(String str) {
		String temp;
		StringBuilder hexStr = new StringBuilder();
		for (int index = 0; index < str.length(); index++) {
			hexStr.append("\\u");
			char charAt = str.charAt(index);
			// 获取高8位
			int high = charAt >> 8;
			temp = Integer.toHexString(high);
			if (temp.length() == 1) {
				hexStr.append("0");
			}
			hexStr.append(temp);
			// 获取底8位
			int low = charAt & 0xFF;
			temp = Integer.toHexString(low);
			if (temp.length() == 1) {
				hexStr.append("0");
			}
			hexStr.append(temp);
		}
		System.out.println(hexStr.toString());
		return hexStr.toString();
	}

	/**
	 * unicode 转字符串
	 *
	 * @param unicode 16进制字符
	 * 		e.g: h==>\u0068
	 * @return String
	 */
	private static String unicode2String(String unicode) {

		StringBuilder temp = new StringBuilder();
		String[] hex = unicode.split("\\\\u");
		for (int i = 1; i < hex.length; i++) {
			int data = Integer.parseInt(hex[i], 16);
			temp.append((char) data);
		}
		return temp.toString();
	}
}