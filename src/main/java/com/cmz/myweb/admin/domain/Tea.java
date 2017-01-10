package com.cmz.myweb.admin.domain;

public class Tea {
	private int id;
	private String name;
	private int classifyid;
	private String imgsrc;
	private double price;
	private String desc;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getClassifyid() {
		return classifyid;
	}
	public void setClassifyid(int classifyid) {
		this.classifyid = classifyid;
	}
}
