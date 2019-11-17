package com.mingrn.wechat.official.domain.receive;

import com.mingrn.wechat.official.domain.BaseMessage;

/**
 * 接收视频消息
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 2019/11/17 14:15
 */
public class ReceiveVideoMessage extends BaseMessage {

    /** 视频消息媒体id,可以调用多媒体文件下载接口拉取数据 */
    private String MediaId;

    /** 视频消息缩略图的媒体id,可以调用多媒体文件下载接口拉取数据 */
    private String ThumbMediaId;

    /** 消息id,64位整型 */
    private Long MsgId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    public Long getMsgId() {
        return MsgId;
    }

    public void setMsgId(Long msgId) {
        MsgId = msgId;
    }
}
