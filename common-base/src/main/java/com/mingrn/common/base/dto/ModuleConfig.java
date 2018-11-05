package com.mingrn.common.base.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 模块配置对象
 */
public class ModuleConfig implements Serializable {
	private static final long serialVersionUID = -4580756623751040104L;

	private String id;
	private String moduleName;
	private String version;

	private Integer type;


	private List<ModuleFunction> menus;
	private List<ModuleFunction> components;
	private List<ModuleFunction> pages;
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<ModuleFunction> getMenus() {
		return menus;
	}

	public void setMenus(List<ModuleFunction> menus) {
		this.menus = menus;
	}

	public List<ModuleFunction> getComponents() {
		return components;
	}

	public void setComponents(List<ModuleFunction> components) {
		this.components = components;
	}

	public List<ModuleFunction> getPages() {
		return pages;
	}

	public void setPages(List<ModuleFunction> pages) {
		this.pages = pages;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
