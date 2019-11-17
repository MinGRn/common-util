package com.mingrn.wechat.official.util;

import com.mingrn.wechat.official.domain.reply.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 消息转换工具类
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 2019/11/17 13:41
 */
public class MessageConvertUtil {

    private MessageConvertUtil() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConvertUtil.class);

    /**
     * 解析 HttpServletRequest 请求 XML 流数据,封装成Map
     * 从 HttpServletRequest 中读取 InputStream(该输入流是一个XML对象)
     * 通过使用 org.dom4j.SAXReader.read() api 读取输入流,封装成 org.dom4j.Document
     * 文档对象.通过获取文档对象的根节点,获取该根节点的全部子节点。进行遍历,封装进入Map集合.
     * 注:需要引入 org.dom4j.dom4j API
     *
     * @param request javax.servlet.http.HttpServletRequest
     * @return java.util.Map
     * @author MinGRn <br > MinGRn97@gmail.com
     * @date 2019/11/16 23:05
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> parseXml2Map(HttpServletRequest request) {

        Map<String, String> params = new LinkedHashMap<>(8);
        try (InputStream inputStream = request.getInputStream()) {
            Document document = new SAXReader().read(inputStream);
            Element rootElement = document.getRootElement();
            List<Element> elementList = rootElement.elements();
            for (Element element : elementList) {
                params.put(element.getName(), element.getText());
            }
        } catch (IOException e) {
            LOGGER.error("MessageUtil.parseXml IOException >>", e);
        } catch (DocumentException e) {
            LOGGER.error("MessageUtil.parseXml DocumentException >>", e);
        }

        return params;
    }

    /**
     * T 对象转 XML,并返回 String
     *
     * @param t     请求实体
     * @param alias 别名转换, 如类 {@link ReplyNewsMessage.Article article} 属于
     *              {@link ReplyNewsMessage} 内部类, 在转换 xml 时可将该类设置别名
     * @return java.lang.String
     * @author MinGRn <br > MinGRn97@gmail.com
     * @date 2019/11/16 23:05
     * @see com.mingrn.wechat.official.domain.BaseMessage
     */
    public static <T> String message2Xml(T t, Clazz2Alias... alias) {
        xStream.alias("xml", t.getClass());
        if (alias != null && alias.length > 0) {
            for (Clazz2Alias clazz2Alias : alias) {
                xStream.alias(clazz2Alias.alias, clazz2Alias.getClazz());
            }
        }
        return xStream.toXML(t);
    }


    /**
     * 扩展 XStream,对 XML 文本内容增加 <![CDATA[]]> 语法快
     * </p>
     * 对象转XML, 需引入 xstream API
     *
     * @author MinGRn <br > MinGRn97@gmail.com
     * @date 2019/11/17 13:44
     */
    private static XStream xStream = new XStream(new XppDriver() {
        @Override
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                /*
                 * 对所有xml节点的转换都增加CDATA标记
                 * 这里默认都增加标记
                 */
                boolean cDataMark = true;

                @Override
                protected void writeText(QuickWriter writer, String text) {
                    if (cDataMark) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

    /**
     * Clazz 类别名, 如类 {@link com.mingrn.wechat.official.domain.BaseMessage} 设置别名 base
     *
     * @author MinGRn <br > MinGRn97@gmail.com
     * @date 2019/11/17 13:57
     */
    public static class Clazz2Alias {

        /** 别名 */
        private String alias;

        /** 类 */
        private Class<?> clazz;

        Clazz2Alias(String alias, Class clazz) {
            this.alias = alias;
            this.clazz = clazz;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public Class<?> getClazz() {
            return clazz;
        }

        public void setClazz(Class<?> clazz) {
            this.clazz = clazz;
        }
    }

}
