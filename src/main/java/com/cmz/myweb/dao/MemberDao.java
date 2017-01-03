package com.cmz.myweb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cmz.myweb.domain.Member;

public interface MemberDao {

	public final static String Table = "member";
	public final static String fields = "`id`,`uname`,`pwd`";

	@Select("SELECT " + fields + " FROM " + Table + " WHERE `id`=#{id} LIMIT 1")
	public Member getById(@Param("id") int id);

	@Select("SELECT " + fields + " FROM " + Table + " WHERE `uname`=#{uname} AND `pwd`=#{pwd} LIMIT 1")
	public Member getMember(@Param("uname") String uname, @Param("pwd") String pwd);

	@Select("SELECT " + fields + " FROM " + Table + " WHERE `uname` like '${uname}' LIMIT 1")
	public Member getMemberByName(@Param("uname") String uname);

	@Select("SELECT " + fields + " FROM " + Table + " LIMIT #{from},#{num}")
	public List<Member> getMembers(@Param("from") int from, @Param("num") int num);

	@Select("SELECT COUNT(*) FROM " + Table)
	public int getCount();

	@Update("UPDATE " + Table + " set pwd=#{pwd} WHERE `id`=#{id}")
	public int update(@Param("pwd") String pwd, @Param("enabled") boolean enabled, @Param("id") int id);



	@Insert("INSERT INTO " + Table + "(" + fields
			+ ") VALUES(0,#{member.uname},#{member.pwd})")
	public int addMember(@Param("member") Member member);
	
}
