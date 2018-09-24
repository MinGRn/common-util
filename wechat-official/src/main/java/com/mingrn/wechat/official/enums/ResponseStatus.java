package com.mingrn.wechat.official.enums;

/**
 * 微信认证状态码
 *
 * @author MinGRn <br > 21/09/2018 18:21
 * @email MinGRn97@gmail.com
 */
public enum ResponseStatus {

	SUCCESS(0, "请求成功"),
	SYS_BUSY(-1, "系统繁忙"),
	INVALID_CODE(-2, "无效的状态码"),
	IP_IS_BLACK(40164, "IP请求黑名单"),
	INVALID_ID(40013, "AppId 错误或无效"),
	SECRET_INVALID(40125, "Secret 错误或无效"),
	ID_OR_SECRET_ERR(40001, "Secret 错误或无效"),
	CLIENT_CREDENTIAL_ERR(40002, "grantType 错误"),
	INVALID_ACTION_INFO(42001, "action info 已过期"),
	INVALID_ACTION_NAME(40052, "action name 已过期"),
	INVALID_ASSESS_TOKEN(40001, "access token 无效"),
	ASSESS_TOKEN_PAST_DUE(42001, "access token 已过期");

	private int code;
	private String msg;

	ResponseStatus(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * 返回成功状态码
	 */
	public static int getSuccessCode() {
		return 0;
	}

	/**
	 * 通过状态码获取状态信息
	 */
	public static String getMsg(int code) {
		for (ResponseStatus status : ResponseStatus.values()) {
			if (code == status.code) {
				return status.msg;
			}
		}
		return getMsg(-2);
	}
}
