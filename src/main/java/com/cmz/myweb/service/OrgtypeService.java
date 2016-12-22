package com.cmz.myweb.service;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmz.myweb.dao.OrgtypeDao;
import com.cmz.myweb.domain.Orgtype;

@Service
public class OrgtypeService {
	@Autowired
	private OrgtypeDao orgtypeDao;
	

	public int add(Orgtype orgtype){
		return orgtypeDao.add(orgtype);
	}
	

	public int update(Orgtype orgtype){
		return orgtypeDao.update(orgtype);
	}

	
	public int count(){
		return orgtypeDao.count();
	}
	

	public Orgtype getOrgtypeById(int id){
		return orgtypeDao.getOrgtypeById(id);
	}
	

	public List<Orgtype> list(int from,int num){
		return orgtypeDao.list(from, num);
	}
}
