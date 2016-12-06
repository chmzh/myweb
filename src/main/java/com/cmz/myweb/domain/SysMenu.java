package com.cmz.myweb.domain;

public class SysMenu {
	private int id;
	private int parentid;
	private String model = "";
	private String action = "";
	private String name = "";
	private boolean visible;
	private int ctype;
	private boolean formchecked;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isFormchecked() {
		return formchecked;
	}
	public void setFormchecked(boolean formchecked) {
		this.formchecked = formchecked;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public int getCtype() {
		return ctype;
	}
	public void setCtype(int ctype) {
		this.ctype = ctype;
	}
}
