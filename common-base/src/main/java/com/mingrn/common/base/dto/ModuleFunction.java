package com.mingrn.common.base.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 模块提供的功能对象, 包含 菜单、组件、Page类型对象
 */
public class ModuleFunction implements Serializable {

	private static final long serialVersionUID = 4194818058748165553L;

	private String seqId;

	private String parentId;
	private Boolean isLeaf;
	private Boolean isRoot;
	private Integer menuType;
	private String name;
	private String icon;
	private String url;
	private List<String> requireJS;
	private String description;


	public Integer getMenuType() {
		return menuType;
	}

	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}


	public String getParentId() {
		return parentId;
	}


	public void setParentId(String parentId) {
		this.parentId = parentId;
	}


	public String getSeqId() {
		return seqId;
	}


	public void setSeqId(String seqId) {
		this.seqId = seqId;
	}


	public Boolean getIsLeaf() {
		return isLeaf;
	}


	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}


	public Boolean getIsRoot() {
		return isRoot;
	}


	public void setIsRoot(Boolean isRoot) {
		this.isRoot = isRoot;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getIcon() {
		return icon;
	}


	public void setIcon(String icon) {
		this.icon = icon;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public List<String> getRequireJS() {
		return requireJS;
	}

	public void setRequireJS(List<String> requireJS) {
		this.requireJS = requireJS;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
