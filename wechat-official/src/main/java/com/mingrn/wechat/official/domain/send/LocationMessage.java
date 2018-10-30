package com.mingrn.wechat.official.domain.send;

/**
 * 发送地理位置消息
 *
 * @author MinGRn <br > 21/09/2018 17:09
 * @email MinGRn97@gmail.com
 */
public class LocationMessage extends BaseMessage {

	/**
	 * 地理位置维度
	 */
	private float Location_X;

	/**
	 * 地理位置经度
	 */
	private float Location_Y;

	/**
	 * 地图缩放大小
	 */
	private int Scale;

	/**
	 * Label
	 */
	private String Label;

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
}