/*
 * MinGRn97@gmaio.com
 * Copyright (c) 2019 - 2019 by MinGRn. All Rights Reserved.
 */

package com.mingrn.wechat.official.domain.receive;

import com.mingrn.wechat.official.domain.BaseMessage;

/**
 * 发送地理位置消息
 *
 * @author MinGRn <br > 21/09/2018 17:09
 */
public class ReceiveLocationMessage extends BaseMessage {

	/** 地理位置维度 */
	private float Location_X;

	/** 地理位置经度 */
	private float Location_Y;

	/** 地图缩放大小 */
	private int Scale;

	/** 地理位置信息 */
	private String Label;

	/** 消息id,64位整型 */
	private Long MsgId;

	public float getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(float location_X) {
		Location_X = location_X;
	}

	public float getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(float location_Y) {
		Location_Y = location_Y;
	}

	public int getScale() {
		return Scale;
	}

	public void setScale(int scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public Long getMsgId() {
		return MsgId;
	}

	public void setMsgId(Long msgId) {
		MsgId = msgId;
	}
}
