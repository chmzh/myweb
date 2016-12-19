package com.cmz.myweb.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.cmz.myweb.domain.News;

public interface NewsDao {
	
	public final static String Table="news";
	public final static String fields = "`id`,`title`,`content`";
	
	@Insert("INSERT INTO "+Table+"("+fields+")VALUES(0,#{n.title},#{n.content})")
	public int add(@Param("n")News news);
	
	@Update("UPDATE "+Table+" SET `title`=#{n.title},`content`=#{n.content} WHERE `id`=#{n.id}")
	public int update(@Param("n") News news);
}
