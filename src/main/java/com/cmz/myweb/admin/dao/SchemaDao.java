package com.cmz.myweb.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cmz.myweb.admin.domain.Schema;

public interface SchemaDao {
	public final static String Table = "`schema`";
	public final static String fields = "`id`,`name`,`produceid`,`power`,`des`";
	
	@Select("SELECT count(1) FROM "+Table)
	public int count();
	
	@Select("SELECT "+fields+" FROM "+ Table+" LIMIT #{from},#{num}")
	public List<Schema> list(@Param("from")int from,@Param("num")int num);
	
	@Insert("INSERT INTO "+Table+"("+fields+")VALUES(0,#{s.name},#{s.produceid},#{s.power},#{s.des})")
	public int add(@Param("s")Schema schema);
	
	@Update("UPDATE "+Table+" SET name=#{s.name},power=#{s.power},des=#{s.des} WHERE id=#{s.id}")
	public int update(@Param("s")Schema schema);

	@Select("SELECT "+fields+" FROM "+Table+" WHERE id=#{id}")
	public Schema getSchemaById(int id);

}
