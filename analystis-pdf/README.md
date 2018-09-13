# analysis-pdf

analysis-pdf 是一个解析 PDF 文档的工具类。

主要用于解析 PDF 文本内容，将指定 PDF 页面生成图片。

- `BoxAnalysis`：PDF单页解析图片
 
- `ITextAnalysis`：PDF解析文本内容

这两个类不直接对外提供调用，声明为 **默认** 权限。统一由 `PdfAnalysisUtil` 类提供调用。

`PdfAnalysisUtil` 类当前提供如下方法：

```java
	/**
	 * 解析 PDF 全部页面文本内容
	 *
	 * @param filePath PDF 文件地址
	 * @return List<String> PDF 解析文本内容
	 * @email MinGRn97@gmail.com
	 * @author MinGRn <br > 13/09/2018 11:10
	 */
	public static List<String> analysisPDFToText(String filePath) {

		return ITextAnalysis.iTextAnalysisPDFToText(filePath, 1, true);
	}

	/**
	 * 解析 PDF 指定页码文本内容
	 *
	 * @param filePath PDF 文件地址
	 * @param pageNumber PDF 页码
	 * @return List<String> PDF 解析文本内容
	 * @email MinGRn97@gmail.com
	 * @author MinGRn <br > 13/09/2018 11:38
	 */
	public static List<String> analysisPDFToText(String filePath, Integer pageNumber) {

		return ITextAnalysis.iTextAnalysisPDFToText(filePath, pageNumber, false);
	}

	/**
	 * 解析 PDF 全部页面图片
	 *
	 * @param filePath PDF 文件地址
	 * @return String PDF 解析文本内容
	 * @email MinGRn97@gmail.com
	 * @author MinGRn <br > 13/09/2018 11:10
	 */
	public static List<BufferedImage> analysisPDFToImage(String filePath) {
		return BoxAnalysis.boxAnalysisPDFToImage(filePath, 0, true);
	}

	/**
	 * 解析 PDF 指定页面图片
	 *
	 * @param filePath PDF 文件地址
	 * @param pageNumber PDF 页码
	 * @return String PDF 解析文本内容
	 * @email MinGRn97@gmail.com
	 * @author MinGRn <br > 13/09/2018 11:38
	 */
	public static List<BufferedImage> analysisPDFToImage(String filePath, int pageNumber) {
		return BoxAnalysis.boxAnalysisPDFToImage(filePath, pageNumber, false);
	}


	/**
	 * 解析 PDF 全部页面文本与图片
	 *
	 * @param filePath PDF 文件地址
	 * @return JSONObject
	 * @email MinGRn97@gmail.com
	 * @author MinGRn <br > 13/09/2018 16:05
	 */
	public static JSONArray analysisPDFToImageWithText(String filePath) {

		JSONArray jsonArray = new JSONArray();
		List<String> listStr = ITextAnalysis.iTextAnalysisPDFToText(filePath, 1, true);
		List<BufferedImage> bufferedImageList = BoxAnalysis.boxAnalysisPDFToImage(filePath, 1, true);
		int totalPage = listStr.size();
		for (int pageIndex = 0; pageIndex < totalPage; pageIndex++) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("text", listStr.get(pageIndex));
			jsonObject.put("image", bufferedImageList.get(pageIndex));
			jsonArray.add(jsonObject);
		}
		return jsonArray;

	}


	/**
	 * 解析指定页面 PDF 文本与图片
	 *
	 * @param filePath PDF 文件地址
	 * @param pageNumber PDF 页码
	 * @return JSONObject
	 * @email MinGRn97@gmail.com
	 * @author MinGRn <br > 13/09/2018 16:05
	 */
	public static JSONObject analysisPDFToImageWithText(String filePath, Integer pageNumber) {

		JSONObject jsonObject = new JSONObject();
		String content = ITextAnalysis.iTextAnalysisPDFToText(filePath, pageNumber, false).get(0);
		BufferedImage bufferedImage = BoxAnalysis.boxAnalysisPDFToImage(filePath, pageNumber, false).get(0);

		jsonObject.put("text", content);
		jsonObject.put("image", bufferedImage);

		return jsonObject;

	}
```

`Main`  类是一个测试用例