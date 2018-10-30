package com.mingrn.common.base.enums;

public enum ResponseStatusCodeEnum {

	/**
	 * 失败状态码
	 */
	RESULT_CODE_FAILURE(-1, "Failure"),

	/**
	 * 成功状态码
	 */
	RESULT_CODE_SUCCESS(0, "Success"),

	/**
	 * 异常状态码
	 */
	RESULT_CODE_EXCEPTION(10000, "request exception"),

	/**
	 * 未登录状态码
	 */
	RESULT_CODE_NOT_LOGIN(10001, "the user is not login"),

	/**
	 * 查询结果为空状态码
	 */
	RESULT_CODE_NOT_EXISTS_OR_EMPTY(10002, "result is empty"),

	/**
	 * 无操作权限状态码
	 */
	RESULT_CODE_NOT_AUTHORIZED(10003, "No operation permission"),

	/**
	 * 登录用户名或密码错误状态码
	 */
	RESULT_CODE_USER_OR_PASSWORD_ERROR(20000, "username or password Invalid"),

	/**
	 * 密码最大失败次数上限状态码
	 */
	RESULT_CODE_MAX_PASSWORD_ERROR_COUNT(20001, "upper limit for password error"),

	/**
	 * 非法请求状态码
	 */
	RESULT_CODE_ILLEGAL_REQUEST(30000, "Illegal request"),

	/**
	 * 参数不能为空状态码
	 */
	RESULT_CODE_PARAMS_EMPTY(40000, "the input parameter is null");


	/**
	 * 状态码
	 */
	private Integer code;

	/**
	 * 状态信息
	 */
	private String msg;

	ResponseStatusCodeEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
