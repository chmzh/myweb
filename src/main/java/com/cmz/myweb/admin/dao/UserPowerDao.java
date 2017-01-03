package com.cmz.myweb.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cmz.myweb.admin.domain.Produce;
import com.cmz.myweb.admin.domain.UserPower;
import com.cmz.myweb.entries.UserPowerEntry;


public interface UserPowerDao {
	public final static String Table = "user_power";
	public final static String fields = "`id`,`userid`,`produceid`,`powers`";
	
	@Select("SELECT "+fields+" FROM "+Table+" WHERE userid=#{userid} AND produceid=#{produceid}")
	public UserPower getUserPower(@Param("userid")int userid,@Param("produceid")int produceid);

	@Insert("INSERT INTO "+Table+"("+fields+")VALUES(0,#{p.userid},#{p.produceid},#{p.powers})")
	public int add(@Param("p")UserPower userPower);
	@Update("UPDATE "+Table+" SET powers=#{p.powers} WHERE userid=#{p.userid} AND produceid=#{p.produceid}")
	public int update(@Param("p")UserPower userPower);

	@Select("SELECT p.produceid,p1.name,p.powers FROM "+Table +" as p INNER JOIN "+ProduceDao.Table+" as p1 on p.produceid=p1.id WHERE p.userid=#{userid}")
	public List<UserPowerEntry> getUserPowerEntrys(int userid);
}
