package com.mingrn.wechat.official.domain.reply;

import com.mingrn.wechat.official.domain.BaseMessage;

/**
 * 发送语音消息
 *
 * @author MinGRn <br > 21/09/2018 16:30
 * @email MinGRn97@gmail.com
 */
public class ReplyVoiceMessage extends BaseMessage {

    private MediaVoice Voice;

    public MediaVoice getVoice() {
        return Voice;
    }

    public void setVoice(MediaVoice voice) {
        Voice = voice;
    }

    public static class MediaVoice {

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
}
