package com.cmz.myweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cmz.myweb.domain.News;

public interface NewsDao {
	
	public final static String Table="news";
	public final static String fields = "`id`,`title`,`content`";
	
	@Select("SELECT count(1) FROM "+Table)
	public int count();
	
	@Select("SELECT "+fields+" FROM "+Table+" LIMIT #{from},#{num}")
	public List<News> list(@Param("from")int from,@Param("num")int num);
	
	@Insert("INSERT INTO "+Table+"("+fields+")VALUES(0,#{n.title},#{n.content})")
	public int add(@Param("n")News news);
	
	@Update("UPDATE "+Table+" SET `title`=#{n.title},`content`=#{n.content} WHERE `id`=#{n.id}")
	public int update(@Param("n") News news);
	
	@Select("SELECT "+fields+" FROM "+Table+" WHERE id=#{id}")
	public News getNewsById(@Param("id")int id);
}
