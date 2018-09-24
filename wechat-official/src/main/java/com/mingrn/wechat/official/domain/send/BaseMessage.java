package com.mingrn.wechat.official.domain.send;

import java.io.Serializable;

/**
 * 发送微信消息基类
 * 消息字段与微信公众号官网开发文档一致,
 * 如官网 开发者微信号字段为 ToUserName 不能写成 toUserName
 *
 * @author MinGRn <br > 21/09/2018 11:27
 * @email MinGRn97@gmail.com
 */
class BaseMessage implements Serializable {

	private static final Long serialVersionUID = -1L;

	/**
	 * 开发者微信号
	 */
	private String ToUserName;

	/**
	 * 发送方账号(OpenId)
	 */
	private String FromUserName;

	/**
	 * 消息创建时间(整型)
	 */
	private Long CreateTime;

	/**
	 * 消息类型
	 * 文本消息: text
	 * 链接消息: link
	 * 图片消息: image
	 * 语音消息: voice
	 * 视频消息: video
	 * 音乐消息: music
	 * 图文消息: news
	 * 小视频消息: shortvideo
	 * 地理位置消息: location
	 * 事件推送: event
	 */
	private String MsgType;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
}
