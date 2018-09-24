package com.mingrn.wechat.official.util;

import com.mingrn.wechat.official.consts.GeneralConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信公众号 Access_Token 工具类
 *
 * @author MinGRn <br > 21/09/2018 17:15
 * @email MinGRn97@gmail.com
 */
public class GenerateAccessTokenUtil {

	private GenerateAccessTokenUtil() {
	}

	/**
	 * 获取 AccessToken 凭证
	 */
	private static final String ACCESS_TOKEN_CREDENTIAL = "client_credential";

	/**
	 * 生成 AccessToken 地址
	 */
	private static final String GENERATE_ASSESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";

	private static final Logger LOGGER = LoggerFactory.getLogger(GenerateAccessTokenUtil.class);

	/**
	 * 获取 Access_Token
	 *
	 * @param appId 微信公众号 key
	 * @param secret 微信公众号密匙
	 * @return com.alibaba.fastjson.JSONObject
	 * @email MinGRn97@gmail.com
	 * @author MinGRn <br > 20/09/2018 14:14
	 */
	@SuppressWarnings("unchecked")
	public static Map generateAccessToken(String appId, String secret) {

		Map params = new HashMap<>(3);
		params.put("appId", appId);
		params.put("secret", secret);
		params.put("grant_type", ACCESS_TOKEN_CREDENTIAL);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> responseEntity = restTemplate.getForEntity(GENERATE_ASSESS_TOKEN_URL + "?appId={appId}&secret={secret}&grant_type={grant_type}", Map.class, params);
		Map result = ResponseMsgUtil.builderResponse(responseEntity.getBody(), GeneralConstants.GENERATE_ASSESS_TOKEN);
		LOGGER.info("The Access Token Result Is: {}", result);
		return result;
	}
}
