package com.mingrn.common.web.util;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;

public final class RequestUtils {

	private RequestUtils() {
	}

	private static final String[] PROXY_IP_HEADER_NAMES = new String[]{"X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP"};

	public static String getRequestURIWithoutContextPath(HttpServletRequest request) {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		if (requestUri.startsWith(contextPath)) {
			requestUri = requestUri.substring(contextPath.length());
		}

		return requestUri;
	}

	public static String getRequestURIWithQueryString(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder(getRequestURIWithoutContextPath(request));
		String queryString = request.getQueryString();
		if (StringUtils.isNotEmpty(queryString)) {
			sb.append("?").append(queryString);
		}

		return sb.toString();
	}

	public static String getClientIp(HttpServletRequest request) {
		String ip = null, unknown = "unknown";
		int len = PROXY_IP_HEADER_NAMES.length;
		for (int index = 0; index < len; ++index) {
			String name = PROXY_IP_HEADER_NAMES[index];
			ip = request.getHeader(name);
			if (StringUtils.isNotEmpty(ip) && StringUtils.indexOf(ip, ',') != -1) {
				String[] ss = StringUtils.split(ip, ',');
				ip = ss[0];
				if (unknown.equalsIgnoreCase(ip)) {
					ip = ss[1];
				}
			}

			if (StringUtils.isNotEmpty(ip) && !unknown.equalsIgnoreCase(ip)) {
				break;
			}
		}

		if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		return StringUtils.trim(ip);
	}

	public static String getRequestInfo(HttpServletRequest request) {
		return getRequestInfo(request, null);
	}

	public static String getRequestInfo(HttpServletRequest request, String[] hiddenParams) {
		StringBuilder sb = new StringBuilder();
		sb.append(request.getMethod()).append(" ");
		sb.append(request.getRequestURI());
		if (StringUtils.isNotEmpty(request.getQueryString())) {
			sb.append("?").append(request.getQueryString());
		}

		sb.append("\n");
		String forwardUri = (String) request.getAttribute("javax.servlet.forward.request_uri");
		String includeUri;
		String referer;
		if (StringUtils.isNotEmpty(forwardUri)) {
			sb.append("Forward From: ").append(forwardUri);
			includeUri = (String) request.getAttribute("javax.servlet.forward.query_string");
			if (StringUtils.isNotEmpty(includeUri)) {
				sb.append("?").append(includeUri);
			}

			referer = (String) request.getAttribute("javax.servlet.forward.path_info");
			if (StringUtils.isNotEmpty(referer)) {
				sb.append(", Path Info: ").append(referer);
			}

			sb.append("\n");
		}

		includeUri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (StringUtils.isNotEmpty(includeUri)) {
			sb.append("Include From: ").append(includeUri);
			referer = (String) request.getAttribute("javax.servlet.include.query_string");
			if (StringUtils.isNotEmpty(referer)) {
				sb.append("?").append(referer);
			}

			String includePathInfo = (String) request.getAttribute("javax.servlet.include.path_info");
			if (StringUtils.isNotEmpty(includePathInfo)) {
				sb.append(", Path Info: ").append(includePathInfo);
			}

			sb.append("\n");
		}

		sb.append("Remote IP Address: ").append(getClientIp(request)).append("\n");
		sb.append("User-Agent: ").append(request.getHeader("User-Agent")).append("\n");
		referer = request.getHeader("Referer");
		if (StringUtils.isNotEmpty(referer)) {
			sb.append("Referer: ").append(referer).append("\n");
		}

		sb.append("Parameters: ");
		boolean first = true;
		Iterator iterator = request.getParameterMap().keySet().iterator();
		while (iterator.hasNext()) {
			Object object = iterator.next();
			String key = object.toString();
			if (!first) {
				sb.append("&");
			} else {
				first = false;
			}

			sb.append(key).append("=");
			boolean hidden = false;
			if (hiddenParams != null) {
				for (String hiddenParam : hiddenParams) {
					if (key.equals(hiddenParam)) {
						hidden = true;
						break;
					}
				}
			}

			if (!hidden) {
				sb.append(StringUtils.join(request.getParameterValues(key), ","));
			} else {
				sb.append("******");
			}
		}

		return sb.toString();
	}

	public static String replaceParamValue(String url, String paramName, String paramValue) {
		StringBuilder sb = new StringBuilder();
		String str = paramName + "=", questionMark = "?";
		if (url.contains(questionMark)) {
			int idx = url.indexOf(str);
			if (idx != -1) {
				int ampIdx = url.indexOf("&", idx);
				if (ampIdx != -1) {
					sb.append(url.substring(0, idx));
					if (paramValue != null) {
						sb.append(str).append(paramValue).append(url.substring(ampIdx));
					} else {
						sb.append(url.substring(ampIdx + 1));
					}
				} else if (paramValue != null) {
					sb.append(url.substring(0, idx)).append(str).append(paramValue);
				} else {
					sb.append(url.substring(0, idx - 1));
				}
			} else {
				sb.append(url);
				if (paramValue != null) {
					sb.append("&").append(str).append(paramValue);
				}
			}
		} else {
			sb.append(url);
			if (paramValue != null) {
				sb.append("?").append(str).append(paramValue);
			}
		}
		return sb.toString();
	}
}
