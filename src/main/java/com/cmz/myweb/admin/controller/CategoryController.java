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
import com.cmz.myweb.domain.SysMenu;
import com.cmz.myweb.service.CategoryService;
import com.cmz.myweb.service.SysMenuService;
import com.cmz.myweb.util.CommUtil;
import com.cmz.myweb.util.PageUtil;
import com.cmz.myweb.util.ViewUtil;
import com.google.gson.Gson;

@Controller
@RequestMapping(URLConfig.CATEGORY)
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(URLConfig.LIST)
	public String list(Model model,@RequestParam(name="page",required=false,defaultValue="1")int page){
		int count = categoryService.getCount();
		int num = 20;
		int from = (page-1)*num;
		
		List<Category> categorys = categoryService.getCategoryByPid(0,from,num);
		model.addAttribute("pages", PageUtil.getPages(page, count, num, URLConfig.CATEGORY+URLConfig.LIST,null));
		model.addAttribute("categorys",categorys);
		return ViewUtil.getAdminView("categoryList");
	}
	
	@RequestMapping(value=URLConfig.ADD)
	public String add(Model model,@RequestParam(name="id",required=false,defaultValue="0")int id){
		Category category = categoryService.getCategoryById(id);
		if(null!=category){
			model.addAttribute("parentid", category.getId());
			model.addAttribute("name", category.getName());
		}else{
			model.addAttribute("parentid", 0);
			model.addAttribute("name", "");
		}
		
		return ViewUtil.getAdminView("categoryAdd");
	}
	
	@RequestMapping(value=URLConfig.ADD_AC,method=RequestMethod.POST)
	public String add_ac(HttpServletRequest request,HttpServletResponse response,Category category){
		int r = categoryService.addCategory(category);
		if(r>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.CATEGORY+URLConfig.LIST+"?pageIndex=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.CATEGORY+URLConfig.ADD);
			return null;

			
		}
	}
	@RequestMapping(value=URLConfig.JSON,method=RequestMethod.POST)
	@ResponseBody
	public String json(HttpServletResponse response,int bigid){
		response.addHeader("Content-Type", "text/json");
		List<Category> smalls = categoryService.getCategoryByPid(bigid, 0, 10000);
		Gson gson = new Gson();
		return gson.toJson(smalls);
	}
}
