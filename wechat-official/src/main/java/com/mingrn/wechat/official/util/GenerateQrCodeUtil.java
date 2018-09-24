package com.mingrn.wechat.official.util;

import com.mingrn.wechat.official.consts.GeneralConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 生成微信公众号二维码工具类
 * 详细见官网:
 * https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1443433542
 *
 * @author zhang.shilin
 * @Email MinGRn97@gmail.com
 * @see #generateTempQR 生成临时带参二维码
 * @see #generateLimitQR 生成永久带参二维码
 */
public class GenerateQrCodeUtil {

	private GenerateQrCodeUtil() {
	}

	/**
	 * 临时二维码(整数参数值)
	 */
	private static final String QR_SCENE = "QR_SCENE";

	/**
	 * 临时二维码(字符参数值)
	 */
	private static final String QR_STR_SCENE = "QR_STR_SCENE";

	/**
	 * 永久二维码(整数参数值)
	 */
	private static final String QR_LIMIT_SCENE = "QR_LIMIT_SCENE";

	/**
	 * 永久二维码(字符参数值)
	 */
	private static final String QR_LIMIT_STR_SCENE = "QR_LIMIT_STR_SCENE";

	/**
	 * 生成二维码地址
	 */
	private static final String GENERATE_QR_CODE_URL = "https://api.weixin.qq.com/cgi-bin/qrcode/create";


	private static final Logger LOGGER = LoggerFactory.getLogger(GenerateQrCodeUtil.class);

	/**
	 * 生成临时微信公众号二维码
	 *
	 * @param accessToken 令牌
	 * @param sceneId 场景值ID，临时二维码时为32位非0整型(目前参数只支持1--100000)
	 * @param sceneStr 场景值ID(字符串形式的ID),字符串类型,长度限制为1到64
	 * @param expireSeconds 二维码有效时间,以秒为单位.最大不超过2592000(即30天),此字段如果不填,则默认有效期为30秒.
	 * @return java.util.Map
	 */
	public static Map generateTempQR(String accessToken, int expireSeconds, int sceneId, String sceneStr) {

		return generateWeChatOfficialQrCode(accessToken, QR_STR_SCENE, expireSeconds, sceneId, sceneStr);
	}


	/**
	 * 生成永久微信公众号二维码
	 *
	 * @param accessToken 令牌
	 * @param sceneId 场景值ID，永久二维码时最大值为100000(目前参数只支持1--100000)
	 * @param sceneStr 场景值ID(字符串形式的ID),字符串类型,长度限制为1到64
	 * @return java.util.Map
	 */
	public static Map generateLimitQR(String accessToken, int sceneId, String sceneStr) {
		return generateWeChatOfficialQrCode(accessToken, QR_LIMIT_STR_SCENE, 0, sceneId, sceneStr);
	}


	/**
	 * 生成临时微信公众号二维码
	 * 请求类型: POST
	 * 参数类型: JSON
	 * 参数示例: {"expire_seconds": 604800, "action_name": "QR_SCENE", "action_info": {"scene": {"scene_id": 123}}}
	 *
	 * @param accessToken 公众号的全局唯一接口调用凭据,公众号调用各接口时都需使用access_token.
	 * 		调用该GET接口生成
	 * 		Token:https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=#{APPID}&secret=#{APPSECRET}
	 * @param actionName 二维码类型(见常量)
	 * 		QR_SCENE 临时二维码的整型参数值
	 * 		QR_STR_SCENE 临时二维码的字符串参数值
	 * 		QR_LIMIT_SCENE 永久二维码的整型参数值
	 * 		QR_LIMIT_STR_SCENE 永久二维码的字符串参数值
	 * @param expireSeconds 二维码有效时间,以秒为单位.最大不超过2592000(即30天).
	 * 		此字段如果不填,则服务器默认有效期为30秒,这里默认3600秒(即1h).当生成的二维码为永久类型时该值无效
	 * @param sceneId 场景值ID，临时二维码时为32位非0整型,永久二维码时最大值为100000(目前参数只支持1--100000)
	 * @param sceneStr 场景值ID(字符串形式的ID),字符串类型,长度限制为1到64
	 * @return java.util.Map
	 */
	private static Map generateWeChatOfficialQrCode(String accessToken, String actionName, int expireSeconds, int sceneId, String sceneStr) {

		Map result = null;
		Map<String, Object> paramsMap = new HashMap<>(3),
				sceneMap = new HashMap<>(1), actionInfoMap = new HashMap<>(1);

		paramsMap.put("action_name", actionName);
		paramsMap.put("expire_seconds", expireSeconds);

		/*
		 * QR_SCENE.equals(actionName) || QR_LIMIT_SCENE.equals(actionName): 整数参数二维码,设置 scene_id
		 * QR_STR_SCENE.equals(actionName) || QR_LIMIT_STR_SCENE.equals(actionName): 字符参数二维码, 设置 scene_str
		 */
		if (QR_SCENE.equals(actionName) || QR_LIMIT_SCENE.equals(actionName)) {
			sceneMap.put("scene_id", sceneId);
		} else {
			sceneMap.put("scene_str", sceneStr);
		}
		actionInfoMap.put("scene", sceneMap);
		paramsMap.put("action_info", actionInfoMap);
		try {
			RestTemplate restTemplate = new RestTemplate();
			String url = GENERATE_QR_CODE_URL + "?access_token=" + accessToken;
			ResponseEntity<Map> entity = restTemplate.postForEntity(url, paramsMap, Map.class);
			result = ResponseMsgUtil.builderResponse(entity.getBody(), GeneralConstants.GENERATE_QR);
		} catch (Exception e) {
			LOGGER.error("Generate WeChat QR Code Interface Exception >>", e);
		}
		LOGGER.info("The Result Of Generate WeChat QR Code Interface: {}", result);
		return result;
	}
}