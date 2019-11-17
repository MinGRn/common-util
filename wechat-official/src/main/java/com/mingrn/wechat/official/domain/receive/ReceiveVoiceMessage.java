/*
 * MinGRn97@gmaio.com
 * Copyright (c) 2019 - 2019 by MinGRn. All Rights Reserved.
 */

package com.mingrn.wechat.official.domain.receive;

import com.mingrn.wechat.official.domain.BaseMessage;

/**
 * 接收语音消息
 *
 * @author MinGRn <br > 21/09/2018 16:30
 * @date 2019/11/17 14:11
 */
public class ReceiveVoiceMessage extends BaseMessage {

    /** 语音格式,如amr，speex等 */
    private String Format;

    /** 语音消息媒体id,可以调用多媒体文件下载接口拉取数据 */
    private String MediaId;

    /** 语音识别结果,UTF8编码 */
    private String Recognition;

    /** 消息id,64位整型 */
    private Long MsgId;

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getRecognition() {
        return Recognition;
    }

    public void setRecognition(String recognition) {
        Recognition = recognition;
    }

    public Long getMsgId() {
        return MsgId;
    }

    public void setMsgId(Long msgId) {
        MsgId = msgId;
    }
}
