package com.mingrn.pdf.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * PDF-Box 工具解析 PDF 图片类
 *
 * @author MinGRn <br > 13/09/2018 12:01
 * @email MinGRn97@gmail.com
 */
class BoxAnalysis {

	private BoxAnalysis() {
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(BoxAnalysis.class);

	/**
	 * 解析图片
	 *
	 * @param filePath PDF 文件地址
	 * @param pageNumber PDF文件页码
	 * @param isAllPages 是否解析全部页面
	 * @return List<BufferedImage>
	 * @email MinGRn97@gmail.com
	 * @author MinGRn <br > 13/09/2018 14:29
	 */
	public static List<BufferedImage> boxAnalysisPDFToImage(String filePath, int pageNumber, Boolean isAllPages) {


		PDDocument pdDocument = null;
		List<BufferedImage> bufferedImageList = new LinkedList<BufferedImage>();

		LOGGER.debug(" >> 正在解析 PDF 图片 << ");

		try {

			//加载PDF文件
			pdDocument = PDDocument.load(new File(filePath));
			//PDF 渲染
			PDFRenderer pdfRenderer = new PDFRenderer(pdDocument);
			if (isAllPages) {
				//获取PDF总页码
				int totalPages = pdDocument.getNumberOfPages();
				LOGGER.debug(" PDF 文件共 {} 页 ", totalPages);
				for (int pageIndex = 0; pageIndex < totalPages; pageIndex++) {
					LOGGER.debug(" 正在解析第 {} 页 PDF 图片 ...", pageIndex + 1);
					bufferedImage(pdfRenderer, pageIndex, bufferedImageList);
					LOGGER.debug(" 第 {} 页 PDF 图片解析完成", pageIndex + 1);
				}
			} else {
				LOGGER.debug(" 正在解析 PDF 图片 ...");
				bufferedImage(pdfRenderer, --pageNumber, bufferedImageList);
			}

			LOGGER.debug(" >> PDF 图片解析完成 << ");

		} catch (IOException e) {
			LOGGER.error("IText Analysis PDF To Image Exception", e);
		} finally {
			if (pdDocument != null) {
				try {
					pdDocument.close();
				} catch (IOException e) {
					LOGGER.error(" >> PDDocument IO Close Exception << ", e);
				}
			}
		}

		return bufferedImageList;
	}


	/**
	 * 获取 BufferedImage 对象
	 *
	 * @param pdfRenderer pdf 渲染对象
	 * @param pageIndex 渲染页码
	 * @param bufferedImageList 集合
	 * @return List<BufferedImage>
	 * @email MinGRn97@gmail.com
	 * @author MinGRn <br > 13/09/2018 14:11
	 */
	private static List<BufferedImage> bufferedImage(PDFRenderer pdfRenderer, int pageIndex,
													 List<BufferedImage> bufferedImageList) {

		BufferedImage bufferedImage = null;
		try {
			bufferedImage = pdfRenderer.renderImageWithDPI(pageIndex, 300);
		} catch (IOException e) {
			LOGGER.error(">> PDF Renderer Exception << ", e);
		}
		bufferedImageList.add(bufferedImage);
		return bufferedImageList;
	}

}
