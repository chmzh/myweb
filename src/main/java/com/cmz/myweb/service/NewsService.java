package com.cmz.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmz.myweb.dao.NewsDao;
import com.cmz.myweb.domain.News;
import com.cmz.myweb.util.DateTimeUtil;

@Service
public class NewsService {
	@Autowired
	private NewsDao newsDao;
	
	public int add(News news){
		String curDate = DateTimeUtil.curDateTime();
		news.setPdate(curDate);
		return newsDao.add(news);
	}
	
	public int update(News news){
		return newsDao.update(news);
	}
	
	public int count(){
		return newsDao.count();
	}
	public List<News> list(int from ,int num){
		return newsDao.list(from, num);
	}
	
	public News getNewsById(int id){
		return newsDao.getNewsById(id);
	}
}
