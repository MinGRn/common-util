package com.mingrn.common.base.result;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 返回结果类
 *
 * @author MinGRn
 */
class Result<T> {
	private Integer resCode;
	private String resMsg;
	private T data;

	Result() {
	}

	public Integer getResCode() {
		return this.resCode;
	}

	public void setResCode(Integer resCode) {
		this.resCode = resCode;
	}

	public String getResMsg() {
		return this.resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public T getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String toJson() {
		return this.data == null ? JSON.toJSONString(this) : this.toJson(SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteMapNullValue);
	}

	public String toJson(SerializerFeature... features) {
		return null == features ? this.toJson() : JSON.toJSONString(this, features);
	}

	@Override
	public String toString() {
		return "Result{resCode=" + this.resCode + ", resMsg=\'" + this.resMsg + '\'' + ", data=" + this.data + '}';
	}
}
