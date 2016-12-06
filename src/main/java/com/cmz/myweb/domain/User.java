package com.cmz.myweb.domain;

public class User {
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
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}

	public int getGroupid() {
		return groupid;
	}
	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}

	public boolean isFormchecked() {
		return formchecked;
	}
	public void setFormchecked(boolean formchecked) {
		this.formchecked = formchecked;
	}

	private int id;
	private String uname = "";
	private String pwd = "";
	private boolean enabled;
	private String qq = "";
	private int groupid;
	private boolean formchecked;
}
