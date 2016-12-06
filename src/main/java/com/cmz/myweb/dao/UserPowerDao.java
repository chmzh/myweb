package com.cmz.myweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cmz.myweb.domain.Produce;
import com.cmz.myweb.domain.UserPower;
import com.cmz.myweb.entries.UserPowerEntry;


public interface UserPowerDao {
	public final static String Table = "user_power";
	public final static String fields = "`id`,`userid`,`produceid`,`partnerid`,`powers`";
	
	@Select("SELECT "+fields+" FROM "+Table+" WHERE userid=#{userid} AND produceid=#{produceid}")
	public UserPower getUserPower(@Param("userid")int userid,@Param("produceid")int produceid);

	@Insert("INSERT INTO "+Table+"("+fields+")VALUES(0,#{p.userid},#{p.produceid},#{p.partnerid},#{p.powers})")
	public int add(@Param("p")UserPower userPower);
	@Update("UPDATE "+Table+" SET powers=#{p.powers},partnerid=#{p.partnerid} WHERE userid=#{p.userid} AND produceid=#{p.produceid}")
	public int update(@Param("p")UserPower userPower);

	@Select("SELECT p.gameid,u.gamename,p.partnerid,p.powers FROM "+Table +" as p INNER JOIN "+ProduceDao.Table+" as p1 on p.produceid=p1.produceid WHERE p.userid=#{userid}")
	public List<UserPowerEntry> getUserPowerEntrys(int userid);
}
