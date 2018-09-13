package com.mingrn.common.web.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class CookieUtils {
	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			int len = cookies.length;
			for (int index = 0; index < len; ++index) {
				Cookie cookie = cookies[index];
				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}

		return null;
	}

	public static void addCookie(HttpServletResponse response, String domain, String path, String name, String value) {
		addCookie(response, domain, path, name, value, -1);
	}

	public static void addCookie(HttpServletResponse response, String domain, String path, String name, String value, int maxAge) {
		String colon = ":";
		Cookie cookie = new Cookie(name, value);
		if (domain.contains(colon)) {
			domain = domain.split(colon)[0];
		}

		cookie.setDomain(domain);
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}

	public static void removeCookie(HttpServletResponse response, String domain, String path, String name) {
		addCookie(response, domain, path, name, null, 0);
	}

	private CookieUtils() {
	}
}
