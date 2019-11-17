/*
 * MinGRn97@gmaio.com
 * Copyright (c) 2019 - 2019 by MinGRn. All Rights Reserved.
 */

package com.mingrn.wechat.official.domain.receive;

import com.mingrn.wechat.official.domain.BaseMessage;

/**
 * 接收图片消息
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 2019/11/17 14:04
 */
public class ReceiveImageMessage extends BaseMessage {

    /** 图片链接(由系统生成) */
    private String PicUrl;

    /** 图片消息媒体id,可以调用获取临时素材接口拉取数据 */
    private String MediaId;

    /** 消息id,64位整型 */
    private Long MsgId;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public Long getMsgId() {
        return MsgId;
    }

    public void setMsgId(Long msgId) {
        MsgId = msgId;
    }
}
