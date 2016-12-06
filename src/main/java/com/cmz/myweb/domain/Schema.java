package com.cmz.myweb.domain;

public class Schema {
	private int id;
	private String produceid;
	private String name;
	private String power;
	private String des;
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
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getProduceid() {
		return produceid;
	}
	public void setProduceid(String produceid) {
		this.produceid = produceid;
	}
}
