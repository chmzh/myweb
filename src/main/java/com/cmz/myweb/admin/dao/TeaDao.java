package com.cmz.myweb.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cmz.myweb.admin.domain.Tea;

public interface TeaDao {
	
	public final static String Table = "tea";
	public final static String fields = "`id`,`name`,`classifyid`,`imgsrc`,`price`,`desc`";
	
	@Select("SELECT "+fields+" FROM "+Table +" WHERE `id`=#{id} LIMIT 1")
	public Tea getById(@Param("id")int id);
	
	
	@Select("SELECT "+fields+" FROM "+Table+" LIMIT #{from},#{num}")
	public List<Tea> getPageList(@Param("from")int from,@Param("num")int num);
	
	@Select("SELECT count(*) FROM "+Table)
	public int count();
			
	
	@Select("SELECT "+fields+" FROM "+Table)
	public List<Tea> getTeas();
	

	
	@Update("UPDATE "+Table+" set name=#{p.name},classifyid=#{p.classifyid},imgsrc=#{p.imgsrc},price=#{p.price},`desc`=#{p.desc} WHERE `id`=#{p.id}")
	public int update(@Param("p")Tea tea);
	
	@Insert("INSERT INTO "+Table+"("+fields+") VALUES(0,#{p.name},#{p.classifyid},#{p.imgsrc},#{p.price},#{p.desc})")
	public int add(@Param("p")Tea tea);
	
	@Delete("delete from "+Table+" WHERE `id`=#{id}")
	public int del(@Param("id")int id);
	
}
