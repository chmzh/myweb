package com.cmz.myweb.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmz.myweb.constant.URLConfig;
import com.cmz.myweb.domain.News;
import com.cmz.myweb.service.NewsService;
import com.cmz.myweb.util.ViewUtil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequestMapping(URLConfig.ARTICLE)
public class ArticleFrontController {
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping(URLConfig.INDEX)
	public String index(Model model){
		List<News> news = newsService.list(0, 10);
		model.addAttribute("news", news);
		return ViewUtil.getFrontView("index");
	}
	
	@RequestMapping(URLConfig.DETAIL+"/{id}")
	public String index(Model model,@PathVariable("id")int id){
		News news = newsService.getNewsById(id);
		model.addAttribute("data", news);
		return ViewUtil.getFrontView("detail");
	}
}
