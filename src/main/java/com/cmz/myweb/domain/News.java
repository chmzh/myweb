package com.cmz.myweb.domain;

public class News {
	private int id;
	private String title;
	private int bigid;
	private int smallid;
	private String desc;
	private String content;
	private String hit;
	private String pdate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public int getBigid() {
		return bigid;
	}
	public void setBigid(int bigid) {
		this.bigid = bigid;
	}
	public int getSmallid() {
		return smallid;
	}
	public void setSmallid(int smallid) {
		this.smallid = smallid;
	}
}
