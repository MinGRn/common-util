package com.mingrn.wechat.official.util;

import com.mingrn.wechat.official.domain.send.*;
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
 * @author MinGRn <br > 21/09/2018 10:48
 * @email MinGRn97@gmail.com
 * @see #parseXml2Map 解析 HttpServletRequest 请求 XML 流数据,封装成Map
 * @see #textMessage2Xml TextMessage 对象转 XML,并返回 String
 * @see #imageMessage2Xml  ImageMessage 对象转 XML,并返回 String
 * @see #voiceMessage2Xml VoiceMessage 对象转 XML,并返回 String
 * @see #videoMessage2Xml VideoMessage 对象转 XML,并返回 String
 * @see #locationMessage2Xml LocationMessage 对象转 XML,并返回 String
 * @see #linkMessage2Xml LinkMessage 对象转 XML,并返回 String
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
	 * </p>
	 * try-with-resource:
	 * 该语法提供自动关闭外部资源的语法特性,
	 * 当一个外部资源的句柄对象(比如FileInputStream对象)实现了AutoCloseable接口即可使用
	 * (try-with-resource) 进行自动关闭外部资源而不需要写 finally 进行手动关闭外部资源.
	 *
	 * @param request javax.servlet.http.HttpServletRequest
	 * @return java.util.Map
	 * @email MinGRn97@gmail.com
	 * @author MinGRn <br > 21/09/2018 10:47
	 * @since 1.7
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
	 * TextMessage 对象转 XML,并返回 String
	 *
	 * @param textMessage com.mingrn.wechat.official.domain.TextMessage
	 * @return java.lang.String
	 * @email MinGRn97@gmail.com
	 * @author MinGRn <br > 21/09/2018 15:46
	 * @see TextMessage
	 */
	public static String textMessage2Xml(TextMessage textMessage) {
		xStream.alias("xml", textMessage.getClass());
		return xStream.toXML(textMessage);
	}


	/**
	 * ImageMessage 对象转 XML,并返回 String
	 *
	 * @param imageMessage com.mingrn.wechat.official.domain.ImageMessage
	 * @return java.lang.String
	 * @email MinGRn97@gmail.com
	 * @author MinGRn <br > 21/09/2018 16:28
	 * @see ImageMessage
	 */
	public static String imageMessage2Xml(ImageMessage imageMessage) {
		xStream.alias("xml", imageMessage.getClass());
		return xStream.toXML(imageMessage);
	}


	/**
	 * VoiceMessage 对象转 XML,并返回 String
	 *
	 * @param voiceMessage com.mingrn.wechat.official.domain.VoiceMessage
	 * @return java.lang.String
	 * @email MinGRn97@gmail.com
	 * @author MinGRn <br > 21/09/2018 16:28
	 * @see VoiceMessage
	 */
	public static String voiceMessage2Xml(VoiceMessage voiceMessage) {
		xStream.alias("xml", voiceMessage.getClass());
		return xStream.toXML(voiceMessage);
	}


	/**
	 * VideoMessage 对象转 XML,并返回 String
	 *
	 * @param videoMessage com.mingrn.wechat.official.domain.VideoMessage
	 * @return java.lang.String
	 * @email MinGRn97@gmail.com
	 * @author MinGRn <br > 21/09/2018 16:28
	 * @see VoiceMessage
	 */
	public static String videoMessage2Xml(VideoMessage videoMessage) {
		xStream.alias("xml", videoMessage.getClass());
		return xStream.toXML(videoMessage);
	}


	/**
	 * LocationMessage 对象转 XML,并返回 String
	 *
	 * @param locationMessage com.mingrn.wechat.official.domain.LocationMessage
	 * @return java.lang.String
	 * @email MinGRn97@gmail.com
	 * @author MinGRn <br > 21/09/2018 16:28
	 * @see LocationMessage
	 */
	public static String locationMessage2Xml(LocationMessage locationMessage) {
		xStream.alias("xml", locationMessage.getClass());
		return xStream.toXML(locationMessage);
	}


	/**
	 * LinkMessage 对象转 XML,并返回 String
	 *
	 * @param linkMessage com.mingrn.wechat.official.domain.LinkMessage
	 * @return java.lang.String
	 * @email MinGRn97@gmail.com
	 * @author MinGRn <br > 21/09/2018 16:28
	 * @see LinkMessage
	 */
	public static String linkMessage2Xml(LinkMessage linkMessage) {
		xStream.alias("xml", linkMessage.getClass());
		return xStream.toXML(linkMessage);
	}


	/**
	 * 扩展 XStream,对 XML 文本内容增加 <![CDATA[]]> 语法快
	 * </p>
	 * 对象转XML, 需引入 xstream API
	 *
	 * @email MinGRn97@gmail.com
	 * @author MinGRn <br > 21/09/2018 11:13
	 */
	private static XStream xStream = new XStream(new XppDriver() {
		@Override
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				/*
				 *对所有xml节点的转换都增加CDATA标记
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

}
