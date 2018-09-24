package com.mingrn.wechat.official.domain.send;

/**
 * 发送语音消息
 *
 * @author MinGRn <br > 21/09/2018 16:30
 * @email MinGRn97@gmail.com
 */
public class VoiceMessage extends BaseMessage {

	/**
	 * 语音消息媒体id,可以调用多媒体文件下载接口拉取数据.
	 */
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
