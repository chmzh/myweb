package com.cmz.myweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cmz.myweb.domain.Produce;

public interface ProduceDao {
	
	public final static String Table = "produce";
	public final static String fields = "`id`,`name`";
	
	@Select("SELECT "+fields+" FROM "+Table +" WHERE `id`=#{id} LIMIT 1")
	public Produce getById(@Param("id")int id);
	
	
	@Select("SELECT "+fields+" FROM "+Table+" LIMIT #{from},#{num}")
	public List<Produce> getPageList(@Param("from")int from,@Param("num")int num);
	
	@Select("SELECT count(*) FROM "+Table)
	public int count();
			
	
	@Select("SELECT "+fields+" FROM "+Table)
	public List<Produce> getProduces();
	

	
	@Update("UPDATE "+Table+" set name=#{p.name} WHERE `id`=#{p.id}")
	public int update(@Param("p")Produce produce);
	
	@Insert("INSERT INTO "+Table+"("+fields+") VALUES(0,"
			+ "#{p.name})")
	public int add(@Param("p")Produce produce);
	
	@Delete("delete from "+Table+" WHERE `id`=#{id}")
	public int del(@Param("id")int id);
	
}
