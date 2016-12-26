package com.cmz.myweb.domain;

public class Organization {
	private int id;
	private int countryid;
	private int provinceid;
	private int cityid;
	private String orgtypeid = "";
	private int minage;
	private int maxage;
	private String name = "";
	private String startDate = "";
	private String origin = "";
	private int shops;
	private String content = "";
	private String pdate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCountryid() {
		return countryid;
	}

	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}

	public int getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(int provinceid) {
		this.provinceid = provinceid;
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public String getOrgtypeid() {
		return orgtypeid;
	}

	public void setOrgtypeid(String orgtypeid) {
		this.orgtypeid = orgtypeid;
	}

	public int getMinage() {
		return minage;
	}

	public void setMinage(int minage) {
		this.minage = minage;
	}

	public int getMaxage() {
		return maxage;
	}

	public void setMaxage(int maxage) {
		this.maxage = maxage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getShops() {
		return shops;
	}

	public void setShops(int shops) {
		this.shops = shops;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPdate() {
		return pdate;
	}

	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
}
