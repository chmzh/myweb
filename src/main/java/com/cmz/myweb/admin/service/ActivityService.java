package com.cmz.myweb.admin.service;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmz.myweb.admin.dao.ActivityDao;
import com.cmz.myweb.admin.domain.Activity;

@Service
public class ActivityService {
	@Autowired
	private ActivityDao activityDao;
	
	public int count(){
		return activityDao.count();
	}
	
	public List<Activity> list(int from,int num){
		return activityDao.list(from, num);
	}
	

	public Activity getActivityById(int id){
		return activityDao.getActivityById(id);
	}
	
	
	public int add(Activity activity){
		return activityDao.add(activity);
	}
	
	public int update(Activity activity){
		return activityDao.update(activity);
	}
}
