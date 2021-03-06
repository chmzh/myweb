package com.cmz.myweb.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cmz.myweb.admin.domain.News;

public interface NewsDao {
	
	public final static String Table="news";
	public final static String fields = "`id`,`title`,`imgsrc`,`bigid`,`smallid`,`desc`,`content`,`hit`,`pdate`,`recommend`";
	
	@Select("SELECT count(1) FROM "+Table)
	public int count();
	
	@Select("SELECT "+fields+" FROM "+Table+" LIMIT #{from},#{num}")
	public List<News> list(@Param("from")int from,@Param("num")int num);
	
	@Insert("INSERT INTO "+Table+"("+fields+")VALUES(0,#{n.title},#{n.imgsrc},#{n.bigid},#{n.smallid},#{n.desc},#{n.content},0,#{n.pdate},#{n.recommend})")
	public int add(@Param("n")News news);
	
	@Update("UPDATE "+Table+" SET `title`=#{n.title},`imgsrc`=#{n.imgsrc},`bigid`=#{n.bigid},`smallid`=#{n.smallid},`desc`=#{n.desc},`content`=#{n.content},`recommend`=#{n.recommend} WHERE `id`=#{n.id}")
	public int update(@Param("n") News news);
	
	@Select("SELECT "+fields+" FROM "+Table+" WHERE id=#{id}")
	public News getNewsById(@Param("id")int id);
}
