package com.mingrn.pdf;

import com.alibaba.fastjson.JSONObject;
import com.mingrn.pdf.util.PdfAnalysisUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	private static final String REGEX = "客户号：\\d*|付款人账号：\\d*|收款人账号：\\d*|付款人名称：[^\\s]*|收款人名称：[^\\s]*|付款人开户行：[^\\s]*|收款人开户行：[\\u4e00-\\u9fa5]*\\s[\\u4e00-\\u9fa5]*|金额：[^\\s]*|人民币[\\u4e00-\\u9fa5]*";

	private static final Pattern PATTERN = Pattern.compile(REGEX, Pattern.MULTILINE);

	public static void main(String[] args) {

		String filePath = "D:\\Tencent\\WeChat\\WeChat Files\\WeChat Files\\zhang941426515\\Files\\回单.pdf";

		JSONObject jsonObject = PdfAnalysisUtil.analysisPDFToImageWithText(filePath, 1);

		try {
			ImageIO.write((BufferedImage) jsonObject.get("image"), "png", new FileOutputStream("C:\\Users\\MinGR\\Desktop\\New folder\\" + UUID.randomUUID() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		String content = jsonObject.getString("text");

		String target = "国内支付业务付款回单";
		if (content.contains(target)) {
			int index = content.indexOf(target);
			content = content.substring(index);
		}
		System.out.println(content);


		Matcher matcher = PATTERN.matcher(content);
		System.out.println("\n开始输出文本：\n");
		while (matcher.find()) {
			System.out.println(matcher.group(0));
		}
	}
}
