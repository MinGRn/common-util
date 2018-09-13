package com.mingrn.common.web.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public final class ResponseUtils {

	private ResponseUtils() {
	}

	public static void writeJsonObject(HttpServletResponse response, Object object) {
		writeJsonObject(response, object, null);
	}

	public static void writeJsonObject(HttpServletResponse response, Object object, String jsonCallBack) {
		String jsonStr = "{}";
		if (object != null) {
			jsonStr = JSON.toJSONString(object, new SerializerFeature[]{SerializerFeature.WriteMapNullValue});
		}

		StringBuilder sb = new StringBuilder();
		if (jsonCallBack != null) {
			sb.append(jsonCallBack).append("(").append(jsonStr).append(")");
		} else {
			sb.append(jsonStr);
		}

		writeJson(response, sb.toString());
	}

	public static void writeJsonArray(HttpServletResponse response, Object object) {
		writeJsonArray(response, object, null);
	}

	public static void writeJsonArray(HttpServletResponse response, Object object, String jsonCallBack) {
		String jsonStr = "[]";
		if (object != null) {
			jsonStr = JSON.toJSONString(object, new SerializerFeature[]{SerializerFeature.WriteMapNullValue});
		}

		StringBuilder sb = new StringBuilder();
		if (jsonCallBack != null) {
			sb.append(jsonCallBack).append("(").append(jsonStr).append(")");
		} else {
			sb.append(jsonStr);
		}

		writeJson(response, sb.toString());
	}

	public static void writeJson(HttpServletResponse response, String jsonStr) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with, sid");
		write(response, "application/json; charset=UTF-8", jsonStr);
	}

	public static void writeText(HttpServletResponse response, String text) {
		write(response, "text/plain; charset=UTF-8", text);
	}

	private static void write(HttpServletResponse response, String contentType, String s) {

		response.setContentType(contentType);
		try (PrintWriter out = response.getWriter()) {
			out.write(s);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

	}
}