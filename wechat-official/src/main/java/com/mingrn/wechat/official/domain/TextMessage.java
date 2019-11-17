package com.mingrn.wechat.official.domain;

/**
 * 发送文本消息
 *
 * @author MinGRn <br > 21/09/2018 11:55
 */
public class TextMessage extends BaseMessage {

    /**
     * 文本消息内容
     */
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
