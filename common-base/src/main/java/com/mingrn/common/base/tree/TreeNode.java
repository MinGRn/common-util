package com.mingrn.common.base.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 树节点,需要拓展属性时,请采用继承的方式
 *
 * @author MinGRn
 */
public class TreeNode implements Serializable {
	/**
	 * 节点id
	 */
	private String id;
	/**
	 * 节点名称
	 */
	private String name;
	/**
	 * 父级节点id
	 */
	private String pId;
	/**
	 * 是否为父节点
	 */
	private Boolean isParent;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPId() {
		return pId;
	}

	public void setPId(String pId) {
		this.pId = pId;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		isParent = isParent;
	}
}
