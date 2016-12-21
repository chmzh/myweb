package com.cmz.myweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmz.myweb.domain.News;
import com.cmz.myweb.service.NewsService;
import com.cmz.myweb.util.ViewUtil;

@Controller
@RequestMapping("/detail/")
public class DetailFrontController {
	@Autowired
	private NewsService newsService;
	
	@RequestMapping("index/{id}")
	public String index(Model model,@PathVariable("id")int id){
		News news = newsService.getNewsById(id);
		model.addAttribute("data", news);
		return ViewUtil.getFrontView("detail");
	}
}
