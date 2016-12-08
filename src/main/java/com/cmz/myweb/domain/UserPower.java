package com.cmz.myweb.domain;

public class UserPower {
	private int id;
	private int userid;
	private int produceid;
	private String powers="";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPowers() {
		return powers;
	}
	public void setPowers(String powers) {
		this.powers = powers;
	}
	public int getProduceid() {
		return produceid;
	}
	public void setProduceid(int produceid) {
		this.produceid = produceid;
	}
}
