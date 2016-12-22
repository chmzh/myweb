package com.cmz.myweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cmz.myweb.domain.City;
import com.cmz.myweb.domain.Country;
import com.cmz.myweb.domain.Orgtype;
import com.cmz.myweb.domain.Province;

public interface OrgtypeDao {
	public final static String Table = "`orgtype`";

	
	public final static String fields = "`id`,`name`";
	
	
	@Insert("INSERT INTO "+Table+"("+fields+")VALUES(0,#{o.name})")
	public int add(@Param("o")Orgtype orgtype);
	
	@Update("UPDATE "+Table+" SET `name`=#{o.name} WHERE `id`=#{o.id}")
	public int update(@Param("o")Orgtype orgtype);

	
	@Select("SELECT COUNT(1) FROM "+Table)
	public int count();
	
	@Select("SELECT "+fields+" FROM "+Table+" WHERE id=#{id}")
	public Orgtype getOrgtypeById(@Param("id")int id);
	
	@Select("SELECT "+fields+" FROM "+Table+" LIMIT #{from},#{num}")
	public List<Orgtype> list(@Param("from")int from,@Param("num")int num);
	
	
}
