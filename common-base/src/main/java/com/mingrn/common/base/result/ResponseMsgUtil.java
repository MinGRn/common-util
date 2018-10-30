package com.mingrn.common.base.result;

import com.mingrn.common.base.enums.ResponseStatusCodeEnum;

/**
 * 消息相应工具类
 *
 * @author MinGRn
 */
public class ResponseMsgUtil {

	/**
	 * 统一返回结果
	 */
	public static <T> Result<T> builderResponse(int code, String msg, T data) {
		Result<T> res = new Result<>();
		res.setResCode(code);
		res.setResMsg(msg);
		res.setData(data);
		return res;
	}

	/**
	 * 请求成功
	 */
	public static <T> Result<T> success(T data) {
		return builderResponse(ResponseStatusCodeEnum.RESULT_CODE_SUCCESS.getCode(), ResponseStatusCodeEnum.RESULT_CODE_SUCCESS.getMsg(), data);
	}

	/**
	 * 请求成功
	 */
	public static <T> Result<T> success(String msg, T data) {
		return builderResponse(ResponseStatusCodeEnum.RESULT_CODE_SUCCESS.getCode(), msg, data);
	}

	/**
	 * 请求失败
	 */
	public static <T> Result<T> failure() {
		return builderResponse(ResponseStatusCodeEnum.RESULT_CODE_FAILURE.getCode(), ResponseStatusCodeEnum.RESULT_CODE_FAILURE.getMsg(), null);
	}

	/**
	 * 请求失败
	 */
	public static <T> Result<T> failure(String msg) {
		return builderResponse(ResponseStatusCodeEnum.RESULT_CODE_FAILURE.getCode(), msg, null);
	}

	/**
	 * 登录用户名或密码错误
	 */
	public static Result loginUserOrPasswordError() {
		return builderResponse(ResponseStatusCodeEnum.RESULT_CODE_USER_OR_PASSWORD_ERROR.getCode(), ResponseStatusCodeEnum.RESULT_CODE_USER_OR_PASSWORD_ERROR.getMsg(), null);
	}

	/**
	 * 未登录
	 */
	public static Result notLogin() {
		return builderResponse(ResponseStatusCodeEnum.RESULT_CODE_NOT_LOGIN.getCode(), ResponseStatusCodeEnum.RESULT_CODE_NOT_LOGIN.getMsg(), null);
	}

	/**
	 * 非法请求
	 */
	public static <T> Result<T> illegalRequest() {
		return builderResponse(ResponseStatusCodeEnum.RESULT_CODE_ILLEGAL_REQUEST.getCode(), ResponseStatusCodeEnum.RESULT_CODE_ILLEGAL_REQUEST.getMsg(), null);
	}

	/**
	 * 请求异常
	 */
	public static <T> Result<T> exception() {
		return builderResponse(ResponseStatusCodeEnum.RESULT_CODE_EXCEPTION.getCode(), ResponseStatusCodeEnum.RESULT_CODE_EXCEPTION.getMsg(), null);
	}

	/**
	 * 空参数异常
	 */
	public static <T> Result<T> paramsIsEmpty() {
		return builderResponse(ResponseStatusCodeEnum.RESULT_CODE_PARAMS_EMPTY.getCode(), ResponseStatusCodeEnum.RESULT_CODE_PARAMS_EMPTY.getMsg(), null);
	}

	/**
	 * 结果不存在或空集合
	 */
	public static <T> Result<T> resultIsEmptyOrNotExist() {
		return builderResponse(ResponseStatusCodeEnum.RESULT_CODE_NOT_EXISTS_OR_EMPTY.getCode(), ResponseStatusCodeEnum.RESULT_CODE_NOT_EXISTS_OR_EMPTY.getMsg(), null);
	}
}