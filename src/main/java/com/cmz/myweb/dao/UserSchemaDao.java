package com.cmz.myweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.cmz.myweb.domain.UserSchema;


public interface UserSchemaDao {
	public final static String Table="user_schema";
	public final static String fields="`id`,`userid`,`schemaid`";
	
	//select id,uname,enabled,schemaid,GROUP_CONCAT(name) as name from user as u left join (select userid,schemaid,name from user_schema us left join dc_schema as s on us.`schemaid`=s.id) as s on u.id=s.userid group by u.id order by u.id asc
	
	@Select("SELECT count(1) FROM "+Table)
	public int count();
	
	@Select("SELECT "+fields+" FROM "+Table+" LIMIT #{from},#{num}")
	public List<UserSchema> list(@Param("from")int from,@Param("num")int num);
	
	@Insert("INSERT INTO "+Table+"("+fields+")VALUES(0,#{us.userid},#{us.schemaid})")
	public int add(@Param("us") UserSchema us);

	@Delete("DELETE FROM "+Table+" WHERE userid=#{us.userid} AND schemaid=#{us.schemaid}")
	public int del(@Param("us") UserSchema us);

	@Select("SELECT "+fields+" FROM "+Table+" WHERE schemaid=#{schemaid}")
	public List<UserSchema> getUserSchemas(@Param("schemaid")int schemaid);

	@Select("select power from "+SchemaDao.Table+" as s inner join "+Table+" as us on s.id=us.schemaid where s.produceid=#{produceid} and us.userid=#{userid}")
	public String getUserProducePower(@Param("userid")int userid, @Param("produceid")int produceid);
}
