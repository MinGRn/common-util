package com.mingrn.wechat.official.domain.receive;

import com.mingrn.wechat.official.domain.BaseMessage;

/**
 * 接收链接消息
 *
 * @author MinGRn <br > 21/09/2018 17:12
 * @date 2019/11/17 14:20
 */
public class ReceiveLinkMessage extends BaseMessage {

    /** 消息标题 */
    private String Title;

    /** 消息描述 */
    private String Description;

    /** 消息链接 */
    private String Url;

    /** 消息id,64位整型 */
    private Long MsgId;

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

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public Long getMsgId() {
        return MsgId;
    }

    public void setMsgId(Long msgId) {
        MsgId = msgId;
    }
}
