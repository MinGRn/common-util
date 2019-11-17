package com.mingrn.wechat.official.domain.reply;

import com.mingrn.wechat.official.domain.BaseMessage;

/**
 * 发送图片消息
 *
 * @author MinGRn <br > 21/09/2018 16:08
 * @email MinGRn97@gmail.com
 */
public class ReplyImageMessage extends BaseMessage {

    private MediaImage Image;

    public MediaImage getImage() {
        return Image;
    }

    public void setImage(MediaImage image) {
        Image = image;
    }

    public static class MediaImage {

        /** 图片消息媒体id,可以调用多媒体文件下载接口拉取数据. */
        private String MediaId;

        public String getMediaId() {
            return MediaId;
        }

        public void setMediaId(String mediaId) {
            MediaId = mediaId;
        }
    }
}
