package com.cmz.myweb.domain;

/**
 * 注册用户
 * @author chenmingzhou
 *
 */
public class Member {
	private int id;
	private String uname = "";
	private String pwd = "";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
