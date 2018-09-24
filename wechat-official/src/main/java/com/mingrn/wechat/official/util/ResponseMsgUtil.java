package com.mingrn.wechat.official.util;

import com.mingrn.wechat.official.consts.GeneralConstants;
import com.mingrn.wechat.official.enums.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiepuyao
 * @date Created on 2018/1/30
 */
@SuppressWarnings("unchecked")
class ResponseMsgUtil {

	private ResponseMsgUtil() {
	}

	/**
	 * 提取二维码地址
	 */
	private static final String EXTRACT_QR_CODE_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode";

	public static Map builderResponse(Map params, String genType) {
		Map res = new HashMap(3);
		if (params.get(GeneralConstants.ERR_CODE) == null) {
			if (GeneralConstants.GENERATE_QR.equals(genType)) {
				res.put("code", ResponseStatus.getSuccessCode());
				res.put("expireSeconds", params.get("expire_seconds"));
				res.put("msg", EXTRACT_QR_CODE_URL + "?ticket=" + params.get("ticket"));
			} else if (GeneralConstants.GENERATE_ASSESS_TOKEN.equals(genType)) {
				res.put("code", ResponseStatus.getSuccessCode());
				res.put("expireSeconds", params.get("expires_in"));
				res.put("msg", params.get("access_token"));
			}
		} else {
			int errCode = (int) params.get(GeneralConstants.ERR_CODE);
			res.put("code", errCode);
			res.put("msg", ResponseStatus.getMsg(errCode));
			buildErrMsg(res, errCode);
		}
		return res;
	}

	private static Map buildErrMsg(Map map, int errCode) {
		map.put("code", errCode);
		map.put("msg", ResponseStatus.getMsg(errCode));
		return map;
	}
}