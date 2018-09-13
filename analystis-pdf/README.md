# analysis-pdf

analysis-pdf 是一个解析 PDF 文档的工具类。

主要用于解析 PDF 文本内容，将指定 PDF 页面生成图片。

- `BoxAnalysis`：PDF单页解析图片
 
- `ITextAnalysis`：PDF解析文本内容

这两个类不直接对外提供调用，声明为 **默认** 权限。统一由 `PdfAnalysisUtil` 类提供调用。

主要依赖包：

```xml
<!-- pdf box -->
<dependency>
	<groupId>org.apache.pdfbox</groupId>
	<artifactId>pdfbox</artifactId>
	<version>2.0.11</version>
</dependency>
<!-- pdf iText -->
<dependency>
	<groupId>com.itextpdf</groupId>
	<artifactId>itextpdf</artifactId>
	<version>5.5.13</version>
</dependency>
```

`pdfbox` 与 `itextpdf` 工具类都提供 PDF 解析文本与图片功能。

这里同时采用内这两个工具的原因是笔者测试发现 `pdfbox` 对文本的解析不够友好，甚至会出现字体叠加的情况。
相对而言 `itextpdf` 解析文本会更好。所有采用 `pdfbox` 主要用户解析图片，`itextpdf` 用于解析文本！

---

可以使用如下代码作为测试用例:

```java
import com.alibaba.fastjson.JSONObject;
import PdfAnalysisUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //定义正则表达式主要用于不同场景定制化需求，如提取特定文本行！
	private static final String REGEX = "客户号：\\d*|付款人账号：\\d*|收款人账号：\\d*|付款人名称：[^\\s]*|收款人名称：[^\\s]*|付款人开户行：[^\\s]*|收款人开户行：[\\u4e00-\\u9fa5]*\\s[\\u4e00-\\u9fa5]*|金额：[^\\s]*|人民币[\\u4e00-\\u9fa5]*";

	private static final Pattern PATTERN = Pattern.compile(REGEX, Pattern.MULTILINE);

	public static void main(String[] args) {

		String filePath = "../回单.pdf";

		JSONObject jsonObject = PdfAnalysisUtil.analysisPDFToImageWithText(filePath, 1);

		try {
			ImageIO.write((BufferedImage) jsonObject.get("image"), "png", new FileOutputStream("../" + UUID.randomUUID() + ".png"));
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
```
