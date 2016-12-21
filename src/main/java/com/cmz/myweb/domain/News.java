package com.cmz.myweb.domain;

public class News {
	private int id;
	private String title = "";
	private String imgsrc = "";
	private int bigid;
	private int smallid;
	private String desc = "";
	private String content = "";
	private int hit;
	private String pdate;
	private boolean recommend;
	
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
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
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
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	public boolean isRecommend() {
		return recommend;
	}
	public void setRecommend(boolean recommend) {
		this.recommend = recommend;
	}
}
