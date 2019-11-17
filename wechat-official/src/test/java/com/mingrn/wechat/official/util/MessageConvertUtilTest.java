/*
 * MinGRn97@gmaio.com
 * Copyright (c) 2019 - 2019 by MinGRn. All Rights Reserved.
 */

package com.mingrn.wechat.official.util;

import com.mingrn.wechat.official.consts.MessageTypeConstants;
import com.mingrn.wechat.official.domain.TextMessage;
import com.mingrn.wechat.official.domain.receive.ReceiveLinkMessage;
import com.mingrn.wechat.official.domain.reply.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageConvertUtilTest {

    @Test
    public void testReplyTextMessage2Xml() {
        TextMessage message = new TextMessage();
        message.setFromUserName("afaefasfasf");
        message.setToUserName("asfeabjfbasjkefasjf");
        message.setCreateTime(System.currentTimeMillis());
        message.setMsgType(MessageTypeConstants.MESSAGE_TYPE_TEXT);
        message.setContent("文本消息");

        String result = MessageConvertUtil.message2Xml(message);
        System.out.println(result);
    }

    @Test
    public void testReplyImageMessage2Xml() {
        ReplyImageMessage message = new ReplyImageMessage();
        message.setFromUserName("afaefasfasf");
        message.setToUserName("asfeabjfbasjkefasjf");
        message.setCreateTime(System.currentTimeMillis());
        message.setMsgType(MessageTypeConstants.MESSAGE_TYPE_IMAGE);

        ReplyImageMessage.MediaImage image = new ReplyImageMessage.MediaImage();
        image.setMediaId(UUID.randomUUID().toString());

        message.setImage(image);

        String result = MessageConvertUtil.message2Xml(message);
        System.out.println(result);
    }

    @Test
    public void testReplyVoiceMessage2Xml() {
        ReplyVoiceMessage message = new ReplyVoiceMessage();
        message.setFromUserName("afaefasfasf");
        message.setToUserName("asfeabjfbasjkefasjf");
        message.setCreateTime(System.currentTimeMillis());
        message.setMsgType(MessageTypeConstants.MESSAGE_TYPE_VOICE);

        ReplyVoiceMessage.MediaVoice voice = new ReplyVoiceMessage.MediaVoice();
        voice.setMediaId(UUID.randomUUID().toString());

        message.setVoice(voice);

        String result = MessageConvertUtil.message2Xml(message);
        System.out.println(result);
    }

    @Test
    public void testReplyVideoMessage2Xml() {
        ReplyVideoMessage message = new ReplyVideoMessage();
        message.setFromUserName("afaefasfasf");
        message.setToUserName("asfeabjfbasjkefasjf");
        message.setCreateTime(System.currentTimeMillis());
        message.setMsgType(MessageTypeConstants.MESSAGE_TYPE_VIDEO);

        ReplyVideoMessage.MediaVideo video = new ReplyVideoMessage.MediaVideo();
        video.setMediaId(UUID.randomUUID().toString());
        video.setTitle("测试视频消息");
        video.setDescription("测试文本消息");

        message.setVideo(video);

        String result = MessageConvertUtil.message2Xml(message);
        System.out.println(result);
    }

    @Test
    public void testReplyMusicMessage2Xml() {
        ReplyMusicMessage message = new ReplyMusicMessage();
        message.setFromUserName("afaefasfasf");
        message.setToUserName("asfeabjfbasjkefasjf");
        message.setCreateTime(System.currentTimeMillis());
        message.setMsgType(MessageTypeConstants.MESSAGE_TYPE_VIDEO);

        ReplyMusicMessage.MediaMusic music = new ReplyMusicMessage.MediaMusic();
        music.setTitle("测试视频消息");
        music.setDescription("测试文本消息");
        music.setMusicURL("www.kg.com/牵丝戏.mp4");
        music.setHQMusicUrl("www.kg.com/牵丝戏.mp4");
        music.setThumbMediaId(UUID.randomUUID().toString());

        message.setMusic(music);

        String result = MessageConvertUtil.message2Xml(message);
        System.out.println(result);
    }

    @Test
    public void testReplyNewsMessage2Xml() {
        ReplyNewsMessage message = new ReplyNewsMessage();
        message.setFromUserName("afaefasfasf");
        message.setToUserName("asfeabjfbasjkefasjf");
        message.setCreateTime(System.currentTimeMillis());
        message.setMsgType(MessageTypeConstants.MESSAGE_TYPE_VIDEO);

        ReplyNewsMessage.Article article = new ReplyNewsMessage.Article();
        article.setTitle("图文消息");
        article.setDescription("测试文本消息");
        article.setPicUrl("www.baidu.com");
        article.setPicUrl("www.linux.com");

        message.addArticle(article);

        String result = MessageConvertUtil.message2Xml(message, new MessageConvertUtil.Clazz2Alias("item", ReplyNewsMessage.Article.class));
        System.out.println(result);
    }

    @Test
    public void testReceiveLinkMessage2Xml() {
        ReceiveLinkMessage message = new ReceiveLinkMessage();
        message.setFromUserName("afaefasfasf");
        message.setToUserName("asfeabjfbasjkefasjf");
        message.setCreateTime(System.currentTimeMillis());
        message.setMsgType(MessageTypeConstants.MESSAGE_TYPE_VIDEO);

        message.setTitle("连接消息");
        message.setDescription("消息描述");
        message.setUrl("www.baidu.com");
        message.setMsgId(System.currentTimeMillis());

        String result = MessageConvertUtil.message2Xml(message, new MessageConvertUtil.Clazz2Alias("item", ReplyNewsMessage.Article.class));
        System.out.println(result);
    }


}