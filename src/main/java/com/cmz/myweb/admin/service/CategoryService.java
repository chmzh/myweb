package com.cmz.myweb.admin.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmz.myweb.admin.dao.CategoryDao;
import com.cmz.myweb.admin.dao.SysMenuDao;
import com.cmz.myweb.admin.domain.Category;
import com.cmz.myweb.admin.domain.Resource;
import com.cmz.myweb.admin.domain.SysMenu;


@Service
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;
	
	public List<Category> getCategoryByPid(int pid,int from,int num){
		return categoryDao.getCategoryByPid(pid,from,num);
	}
	
	public int addCategory(Category category){
		return categoryDao.add(category);
	}

	public Category getCategoryById(int id) {
		return categoryDao.getCategoryById(id);
	}
	
	
	public List<Category> getAllSubCategory(){
		return categoryDao.getAllSubCategory();
	}

	public int getCount() {
		return categoryDao.getCount();
	}
}
