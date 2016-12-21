package com.cmz.myweb.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmz.myweb.constant.URLConfig;
import com.cmz.myweb.domain.Category;
import com.cmz.myweb.domain.News;
import com.cmz.myweb.domain.SysMenu;
import com.cmz.myweb.service.CategoryService;
import com.cmz.myweb.service.NewsService;
import com.cmz.myweb.util.CommUtil;
import com.cmz.myweb.util.PageUtil;
import com.cmz.myweb.util.ViewUtil;

@Controller
@RequestMapping(URLConfig.NEWS)
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(URLConfig.LIST)
	public String list(Model model,@RequestParam(name="page",required=false,defaultValue="1")int page){
		int count = newsService.count();
		int num = 20;
		int from = (page-1)*num;
		
		List<News> news = newsService.list(from,num);
		model.addAttribute("pages", PageUtil.getPages(page, count, num, URLConfig.NEWS+URLConfig.LIST,null));
		model.addAttribute("datas",news);
		return ViewUtil.getAdminView("newsList");
	}
	
	@RequestMapping(URLConfig.ADD)
	public String add(Model model){
		
		List<Category> bigs = categoryService.getCategoryByPid(0,0,10000);
		List<Category> smalls = categoryService.getCategoryByPid(bigs.get(0).getId(), 0, 10000);
		model.addAttribute("bigs", bigs);
		model.addAttribute("smalls", smalls);
		return ViewUtil.getAdminView("newsAdd");
	}
	
	@RequestMapping(URLConfig.EDIT)
	public String edit(Model model,int id){
		News news = newsService.getNewsById(id);
		
		List<Category> bigs = categoryService.getCategoryByPid(0,0,10000);
		List<Category> smalls = categoryService.getCategoryByPid(news.getBigid(), 0, 10000);
		
		model.addAttribute("bigs", bigs);
		model.addAttribute("smalls", smalls);
		model.addAttribute("news", news);
		return ViewUtil.getAdminView("newsEdit");
	}
	
	@RequestMapping(value=URLConfig.ADD_AC,method=RequestMethod.POST)
	public String addac(HttpServletRequest request,HttpServletResponse response,News news){
		int r = newsService.add(news);
		if(r>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.NEWS+URLConfig.LIST+"?pageIndex=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.NEWS+URLConfig.ADD);
			return null;

			
		}
	}
	
	@RequestMapping(value=URLConfig.EDIT_AC,method=RequestMethod.POST)
	public String editac(HttpServletRequest request,HttpServletResponse response,News news){
		int r = newsService.update(news);
		if(r>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.NEWS+URLConfig.LIST+"?pageIndex=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.NEWS+URLConfig.ADD);
			return null;

			
		}
	}
}
