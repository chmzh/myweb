package com.cmz.myweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cmz.myweb.domain.Category;
import com.cmz.myweb.domain.Resource;
import com.cmz.myweb.domain.SysMenu;

public interface CategoryDao {
	public final static String Table = "`category`";
	public final static String fields = "`id`,`parentid`,`name`";
	
	@Insert("INSERT INTO "+Table+"("+fields+")VALUES(0,#{c.parentid},#{c.name})")
	public int add(@Param("c")Category c);
	
	@Select("SELECT "+fields+" FROM "+Table+" WHERE parentid=#{pid} LIMIT #{from},#{num}")
	public List<Category> getCategoryByPid(@Param("pid")int parentid,@Param("from")int from,@Param("num")int num);

	@Select("SELECT "+fields+" FROM "+Table+" WHERE id=#{id}")
	public Category getCategoryById(@Param("id")int id);

	@Select("SELECT "+fields+" FROM "+Table+" WHERE id<>0")
	public List<Category> getAllSubCategory();

	@Select("SELECT count(1) FROM "+Table+" WHERE id=0")
	public int getCount();

}
