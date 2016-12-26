package com.cmz.myweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmz.myweb.domain.News;
import com.cmz.myweb.service.NewsService;
import com.cmz.myweb.util.ViewUtil;

@Controller
public class IndexFrontController {
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping("index11")
	public String index(Model model){
		
		List<News> news = newsService.list(0, 10);
		model.addAttribute("news", news);
		return ViewUtil.getFrontView("index");
	}
}
