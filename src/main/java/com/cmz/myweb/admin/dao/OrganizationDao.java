package com.cmz.myweb.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cmz.myweb.admin.domain.Organization;

public interface OrganizationDao {
	public final static String Table = "organization";
	public final static String fields = "`id`,`countryid`,`provinceid`,`cityid`,`orgtypeid`,`minage`,`maxage`,`name`,`startDate`,`origin`,`shops`,`content`,`pdate`";

	@Select("SELECT COUNT(1) FROM "+Table)
	public int count();
	
	@Select("SELECT "+fields+" FROM "+Table+" LIMIT #{from},#{num}")
	public List<Organization> list(@Param("from")int from,@Param("num")int num);
	
	@Insert("INSERT INTO "+Table+"("+fields+")VALUES(0,#{o.countryid},#{o.provinceid},#{o.cityid},#{o.orgtypeid},#{o.minage},#{o.maxage},#{o.name},#{o.startDate},#{o.origin},#{o.shops},#{o.content},#{o.pdate})")
	public int add(@Param("o")Organization organization);
	
	@Update("UPDATE "+Table+" SET `countryid`=#{o.countryid},`provinceid`=#{o.provinceid},`cityid`=#{o.cityid},`orgtypeid`=#{o.orgtypeid},`minage`=#{o.minage},`maxage`=#{o.maxage},`name`=#{o.name},`startDate`=#{o.startDate},`origin`=#{o.origin},`shops`=#{o.shops},`content`=#{o.content},`pdate`=#{o.pdate} WHERE id=#{o.id}")
	public int update(@Param("o")Organization organization);

	@Select("SELECT "+fields+" FROM "+Table+" WHERE id=#{id}")
	public Organization getOrganizationById(@Param("id")int id);
}
