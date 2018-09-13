package com.mingrn.common.pdf.util;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Itext工具 解析 PDF 文本类
 *
 * @author MinGRn <br > 13/09/2018 11:09
 * @email MinGRn97@gmail.com
 */
class ITextAnalysis {

	private ITextAnalysis() {
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(ITextAnalysis.class);


	/**
	 * 解析文本
	 *
	 * @param filePath PDF 文件地址
	 * @param pageNumber PDF 页码
	 * @param isAllPages 是否解析全部文本
	 * @return List<String> PDF 解析文本内容
	 * @email MinGRn97@gmail.com
	 * @author MinGRn <br > 13/09/2018 11:10
	 */
	public static List<String> iTextAnalysisPDFToText(String filePath, Integer pageNumber, Boolean isAllPages) {

		PdfReader pdfReader = null;
		List<String> listStr = new LinkedList<String>();

		LOGGER.debug(" >> 正在解析 PDF 文本内容 << ");
		try {
			pdfReader = new PdfReader(filePath);

			if (isAllPages) {
				int totalPages = pdfReader.getNumberOfPages();
				LOGGER.debug(" PDF 文件共 {} 页 ", totalPages);
				for (pageNumber = 1; pageNumber <= totalPages; pageNumber++) {
					LOGGER.debug(" 正在解析第 {} 页 PDF 文本内容 ...", pageNumber);
					listStr.add(PdfTextExtractor.getTextFromPage(pdfReader, pageNumber));
					LOGGER.debug(" 第 {} 页 PDF 文本内容解析完成", pageNumber);
				}
			} else {
				LOGGER.debug(" 正在解析 PDF 文本 ...");
				listStr.add(PdfTextExtractor.getTextFromPage(pdfReader, pageNumber));
			}

			LOGGER.debug(" >> PDF 文本内容解析完成 << ");
		} catch (IOException e) {
			LOGGER.error(" >> IText Analysis PDF To Text Exception << ", e);
		} finally {
			if (pdfReader != null) {
				pdfReader.close();
			}
		}

		return listStr;
	}


}
