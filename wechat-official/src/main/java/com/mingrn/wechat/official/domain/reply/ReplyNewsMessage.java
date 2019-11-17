package com.mingrn.wechat.official.domain.reply;

import com.mingrn.wechat.official.domain.BaseMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 发送图文消息
 *
 * @author MinGRn <br > 21/09/2018 17:40
 * @email MinGRn97@gmail.com
 */
public class ReplyNewsMessage extends BaseMessage {

    /**
     * 图文消息个数,限制为8条以内
     */
    private int ArticleCount = 0;

    /**
     * 多条图文消息信息,默认第一个item为大图.注意,如果图文数超过8,则将会无响应
     */
    private List<Article> Articles = new ArrayList<>();

    public List<Article> addArticle(Article article) {
        Articles.add(article);
        ArticleCount++;
        return Articles;
    }

    public List<Article> addArticles(List<Article> articles) {
        Articles.addAll(articles);
        ArticleCount = articles.size();
        return Articles;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
        ArticleCount = articles.size();
    }

    public int getArticleCount() {
        return ArticleCount;
    }

    public static class Article {
        /**
         * 图文消息标题
         */
        private String Title;

        /**
         * 图文消息描述
         */
        private String Description;

        /**
         * 图片链接,支持JPG、PNG格式，较好的效果为大图360*200,小图200*200
         */
        private String PicUrl;

        /**
         * 点击图文消息跳转链接
         */
        private String Url;


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

        public String getPicUrl() {
            return PicUrl;
        }

        public void setPicUrl(String picUrl) {
            PicUrl = picUrl;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String url) {
            Url = url;
        }
    }
}