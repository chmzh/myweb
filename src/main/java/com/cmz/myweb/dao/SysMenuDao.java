package com.cmz.myweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cmz.myweb.domain.Resource;
import com.cmz.myweb.domain.SysMenu;

public interface SysMenuDao {
	public final static String Table = "sys_menu";
	public final static String fields = "`id`,`parentid`,`model`,`action`,`name`,`visible`,`ctype`";
	
	@Insert("INSERT INTO "+Table+"("+fields+")VALUES(0,#{m.parentid},#{m.model},#{m.action},#{m.name},#{m.visible},#{m.ctype})")
	public int add(@Param("m")SysMenu sysMenu);
	
	@Select("SELECT "+fields+" FROM "+Table+" WHERE parentid=#{pid} LIMIT #{from},#{num}")
	public List<SysMenu> getSysMenuByPid(@Param("pid")int parentid,@Param("from")int from,@Param("num")int num);

	@Select("SELECT "+fields+" FROM "+Table+" WHERE id=#{id}")
	public SysMenu getSysMenuById(@Param("id")int id);

	@Select("SELECT "+fields+" FROM "+Table+" WHERE id<>0")
	public List<SysMenu> getAllSubSysMenu();
	
	@Select("select s.id,s1.model,s.action,s.name as acname,s1.name as name,s.`visible` from sys_menu as s inner join sys_menu as s1 on s.`parentid`=s1.`id` where s.id in(${ids})")
	public List<Resource> getUserResources(@Param("ids")String ids);

	@Select("SELECT count(1) FROM "+Table+" WHERE id=0")
	public int getCount();
}
