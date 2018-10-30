package com.mingrn.common.base.enums;

/**
 * 状态
 */
public enum StatusEnum {
	//正常
	NORMAL(1),
	//无效
	DISABLE(2),
	//已删除
	DELETE(3);

	private Integer status;

	StatusEnum(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

	public static StatusEnum getEnumStatus(Integer status) {
		if (null == status || status < 1) {
			return null;
		}
		for (StatusEnum statusEnum : StatusEnum.values()) {
			if (statusEnum.getStatus().equals(status)) {
				return statusEnum;
			}
		}
		return null;
	}

}
