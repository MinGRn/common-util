package com.mingrn.common.base.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 文件工具类
 *
 * @author MinGRn
 */
public class FileUtil {

	private FileUtil() {
	}

	/**
	 * 读取文件
	 */
	public static String readFile(String path, String encoding) throws IOException {
		StringBuilder sb = new StringBuilder();
		try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path), encoding);
			 BufferedReader reader = new BufferedReader(inputStreamReader)) {
			String tempString;
			while ((tempString = reader.readLine()) != null) {
				sb.append(tempString);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
}
