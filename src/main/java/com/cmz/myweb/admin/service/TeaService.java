package com.cmz.myweb.admin.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmz.myweb.admin.dao.TeaDao;
import com.cmz.myweb.admin.domain.Tea;


@Service
public class TeaService {
	
	@Autowired
	private TeaDao produceDao;
	
	/**
	 * 添加
	 * @param logconfig
	 * @return
	 */
	public int add(Tea tea){
		int id = produceDao.add(tea);
		return id;
	}
	
	/**
	 * 列表
	 * @param from
	 * @param num
	 * @return
	 */
	public List<Tea> getPageList(int from,int num){
		List<Tea> tea = produceDao.getPageList(from, num);
		return tea;
	}
	
	
	/**
	 * 获取所有游戏
	 * @param from
	 * @param num
	 * @return
	 */
	public List<Tea> getProduces(){
		List<Tea> produces = produceDao.getTeas();
		return produces;
	}
	
	/**
	 * 根据id查找
	 * @param int id
	 * @return
	 */
	public Tea getById(int id){
		Tea tea = produceDao.getById(id);
		return tea;
	}
	

	
	public int update(Tea tea){
		int result = produceDao.update(tea);
		return result;
	}
	
	/**
	 * delete
	 * @param inti id
	 * @return int
	 */
	public int del(int id){
		int result = produceDao.del(id);
		return result;
	}
	
	/**
	 * count
	 * @return int
	 */
	public int count(){
		int result = produceDao.count();
		return result;
	}

}
