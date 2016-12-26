package com.cmz.myweb.service;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmz.myweb.dao.OrganizationDao;
import com.cmz.myweb.domain.Organization;

@Service
public class OrganizationService {
	@Autowired
	private OrganizationDao dao;
	

	public int count(){
		return dao.count();
	}
	

	public List<Organization> list(int from,int num){
		return dao.list(from, num);
	}
	
	
	public int add(Organization organization){
		return dao.add(organization);
	}
	
	
	public int update(Organization organization){
		return dao.update(organization);
	}


	public Organization getOrganizationById(int id) {
		return dao.getOrganizationById(id);
	}
}
