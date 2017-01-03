package com.cmz.myweb.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmz.myweb.admin.dao.UserSchemaDao;
import com.cmz.myweb.admin.domain.UserSchema;

@Service
public class UserSchemaService {
	@Autowired
	private UserSchemaDao dao;
	
	public void batchAdd(List<Integer> userids,int schemaid){
		for(int uid:userids){
			UserSchema userSchema = new UserSchema();
			userSchema.setUserid(uid);
			userSchema.setSchemaid(schemaid);
			add(userSchema);
		}
	}
	
	public void batchDel(List<Integer> userids,int schemaid){
		for(int uid:userids){
			UserSchema userSchema = new UserSchema();
			userSchema.setUserid(uid);
			userSchema.setSchemaid(schemaid);
			del(userSchema);
		}
	}
	
	public int add(UserSchema userSchema){
		return dao.add(userSchema);
	}
	
	public int del(UserSchema userSchema){
		return dao.del(userSchema);
	}

	public List<UserSchema> getUserSchemas(int schemaid) {
		return dao.getUserSchemas(schemaid);
	}
	
	public String getUserProducePower(int userid,int gameid){
		return dao.getUserProducePower(userid,gameid);
	}
}
