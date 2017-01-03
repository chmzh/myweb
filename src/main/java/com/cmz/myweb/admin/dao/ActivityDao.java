package com.cmz.myweb.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cmz.myweb.admin.domain.Activity;

public interface ActivityDao {
	public final static String Table = "`activity`";
	public final static String fields = "`id`,`sdate`,`edate`,`address`,`participants`,`title`,`content`,`imgsrc`";
	
	@Select("SELECT COUNT(1) FROM "+Table)
	public int count();
	
	@Select("SELECT "+fields+" FROM "+Table+" LIMIT #{from},#{num}")
	public List<Activity> list(@Param("from")int from,@Param("num")int num);
	
	@Select("SELECT "+fields+" FROM "+Table+"WHERE id=#{id}")
	public Activity getActivityById(@Param("id")int id);
	
	@Insert("INSERT INTO "+Table+"("+fields+")VALUES(0,#{a.sdate},#{a.edate},#{a.address},#{a.participants},#{a.title},#{a.content}),#{a.imgsrc})")
	public int add(@Param("a")Activity activity);
	
	@Update("UPDATE "+Table+" SET `sdate`=#{a.sdate},`edate`=#{a.edate},`address`=#{a.address},`participants`=#{a.participants},`title`=#{a.title},`content`=#{a.content},`imgsrc`=#{a.imgsrc} WHERE id=#{a.id}")
	public int update(@Param("a")Activity activity);
}
