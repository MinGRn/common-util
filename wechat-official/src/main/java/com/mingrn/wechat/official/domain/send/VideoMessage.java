package com.mingrn.wechat.official.domain.send;

/**
 * 发送视频消息
 *
 * @author MinGRn <br > 21/09/2018 16:53
 * @email MinGRn97@gmail.com
 */
public class VideoMessage extends BaseMessage {

	/**
	 * 视频消息媒体id,可以调用多媒体文件下载接口拉取数据.
	 */
	private String MediaId;

	/**
	 * 视频消息的标题
	 */
	private String Title;

	/**
	 * 视频消息的描述
	 */
	private String Description;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
}
