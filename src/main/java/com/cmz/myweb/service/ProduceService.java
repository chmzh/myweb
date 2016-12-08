package com.cmz.myweb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmz.myweb.dao.ProduceDao;
import com.cmz.myweb.domain.Produce;


@Service
public class ProduceService {
	
	@Autowired
	private ProduceDao produceDao;
	
	/**
	 * 添加
	 * @param logconfig
	 * @return
	 */
	public int add(Produce produce){
		int id = produceDao.add(produce);
		return id;
	}
	
	/**
	 * 列表
	 * @param from
	 * @param num
	 * @return
	 */
	public List<Produce> getPageList(int from,int num){
		List<Produce> produce = produceDao.getPageList(from, num);
		return produce;
	}
	
	
	/**
	 * 获取所有游戏
	 * @param from
	 * @param num
	 * @return
	 */
	public List<Produce> getProduces(){
		List<Produce> produces = produceDao.getProduces();
		return produces;
	}
	
	/**
	 * 根据id查找
	 * @param int id
	 * @return
	 */
	public Produce getById(int id){
		Produce produce = produceDao.getById(id);
		return produce;
	}
	

	
	public int update(Produce produce){
		int result = produceDao.update(produce);
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
