package com.cmz.myweb.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmz.myweb.dao.SysMenuDao;
import com.cmz.myweb.domain.Resource;
import com.cmz.myweb.domain.SysMenu;


@Service
public class SysMenuService {
	@Autowired
	private SysMenuDao sysMenuDao;
	
	public List<SysMenu> getSysMenuByPid(int pid,int from,int num){
		return sysMenuDao.getSysMenuByPid(pid,from,num);
	}
	
	public int addSysMenu(SysMenu sysMenu){
		return sysMenuDao.add(sysMenu);
	}

	public SysMenu getSysMenuById(int id) {
		return sysMenuDao.getSysMenuById(id);
	}
	
	
	public List<SysMenu> getAllSubSysMenu(){
		return sysMenuDao.getAllSubSysMenu();
	}
	
	public List<Resource> getUserResources(String ids){
		return sysMenuDao.getUserResources(ids);
	}

	public int getCount() {
		return sysMenuDao.getCount();
	}
}
