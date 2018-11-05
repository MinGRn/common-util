package com.mingrn.common.base.dto;

import java.util.List;

/**
 * 分页对象
 *
 * @param <T>
 */
public class PageInfo<T> {

	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 页面显示条数
	 */
	private int pageSize;
	/**
	 * 当前页数
	 */
	private int currentPageNumber;
	/**
	 * 返回数据集
	 */
	private List<T> records;

	/**
	 * 总条数
	 */
	private Long totalNum;


	public Long getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum;
	}


	public List<T> getRecords() {
		return records;
	}


	public void setRecords(List<T> records) {
		this.records = records;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getCurrentPageNumber() {
		return currentPageNumber;
	}


	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}
}
