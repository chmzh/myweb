package com.cmz.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmz.myweb.dao.UserPowerDao;
import com.cmz.myweb.domain.UserPower;
import com.cmz.myweb.entries.UserPowerEntry;


@Service
public class UserPowerService {
	@Autowired
	private UserPowerDao userPowerDao;
	public UserPower getUserPower(int userid,int produceid){
		return userPowerDao.getUserPower(userid, produceid);
	}
	public int add(UserPower userPower) {

		return userPowerDao.add(userPower);
	}
	public int update(UserPower userPower) {
		
		return userPowerDao.update(userPower);
	}
	
	public List<UserPowerEntry> getUserPowerEntrys(int userid){
		return userPowerDao.getUserPowerEntrys(userid);
	}
	
}
