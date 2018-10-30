package com.mingrn.common.base.utils;

import java.util.Random;
import java.util.UUID;

/**
 * 随机数字生成
 */
public final class RandomUtil {
	private RandomUtil() {
	}

	public static String authCode(int count) {
		char[] numArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		StringBuilder sb = new StringBuilder(count);
		Random random = new Random();
		for (int i = 0; i < count; i++) {
			sb.append(numArr[random.nextInt(9)]);
		}
		return sb.toString();
	}
}