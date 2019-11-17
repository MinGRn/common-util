package com.mingrn.wechat.official.domain.reply;

import com.mingrn.wechat.official.domain.BaseMessage;

/**
 * 发送视频消息
 *
 * @author MinGRn <br > 21/09/2018 16:53
 * @email MinGRn97@gmail.com
 */
public class ReplyVideoMessage extends BaseMessage {

    /** 视频媒体 */
    private MediaVideo Video;

    public MediaVideo getVideo() {
        return Video;
    }

    public void setVideo(MediaVideo video) {
        Video = video;
    }

    public static class MediaVideo {
        /** 视频消息媒体id,可以调用多媒体文件下载接口拉取数据. */
        private String MediaId;

        /** 视频消息的标题 */
        private String Title;

        /** 视频消息的描述 */
        private String Description;

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

        public String getMediaId() {
            return MediaId;
        }

        public void setMediaId(String mediaId) {
            MediaId = mediaId;
        }
    }
}
