package com.cmz.myweb.admin.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmz.myweb.admin.domain.Category;
import com.cmz.myweb.admin.domain.Tea;
import com.cmz.myweb.admin.service.CategoryService;
import com.cmz.myweb.admin.service.TeaService;
import com.cmz.myweb.constant.GlobalConstant;
import com.cmz.myweb.constant.URLConfig;
import com.cmz.myweb.util.CommUtil;
import com.cmz.myweb.util.PageUtil;
import com.cmz.myweb.util.ViewUtil;

@Controller()
@RequestMapping(URLConfig.TEA)
public class TeaController {
	
	private static final Logger logger = LoggerFactory.getLogger(TeaController.class);
	@Autowired
	private TeaService teaService;
	@Autowired
	private CategoryService categoryService;
	
	
	@RequestMapping(value=URLConfig.LIST, method = RequestMethod.GET)
    public String gameList(
    		@RequestParam(name="page",required=false,defaultValue="1") int page, Model model) {
		
		int count = teaService.count();
		int num = 20;
		int from = (page-1)*num;
		List<Tea> datas = teaService.getPageList(from, num);
		model.addAttribute("pages", PageUtil.getPages(page, count, num, URLConfig.TEA+URLConfig.LIST, null));
		model.addAttribute("datas",datas);
        
        return ViewUtil.getAdminView("teaList");
    }
	
	@RequestMapping(URLConfig.ADD)
    public String gameAdd(Model model) {
		
		List<Category> categories = categoryService.getCategoryByPid(0, 0, 100);
		model.addAttribute("classifys", categories);
		return ViewUtil.getAdminView("teaAdd");
	}
	
	@RequestMapping(URLConfig.ADD_AC)
    public String gameaddAction(HttpServletRequest request,HttpServletResponse response,
    		Model model,Tea tea) {
		String orign = null;
        if(StringUtils.isEmpty(tea.getName())){
			CommUtil.showMsg(request,response, "请填写游戏名称!", URLConfig.TEA+URLConfig.ADD);
			return null;
		}
        int id = teaService.add(tea);
		if(id>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.TEA+URLConfig.LIST+"?page=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.TEA+URLConfig.ADD);
			return null;
			
		}

    }
	
	@RequestMapping(URLConfig.EDIT)
    public String gameUpdate(HttpServletRequest request,HttpServletResponse response,Model model,
    		@RequestParam(name="id",required=false,defaultValue="1") int id) {
		
		Tea tea = teaService.getById(id);
		List<Category> categories = categoryService.getCategoryByPid(0, 0, 100);
		model.addAttribute("classifys", categories);
		model.addAttribute("tea",tea);
		return ViewUtil.getAdminView("teaEdit");
    }
	
	@RequestMapping(URLConfig.EDIT_AC)
    public String gameUpdateAction(
    		HttpServletRequest request,HttpServletResponse response,Model model,Tea tea) {
		int id = tea.getId();
		if(StringUtils.isEmpty(tea.getName())){
			CommUtil.showMsg(request,response, "请填写游戏名称!", URLConfig.TEA+URLConfig.EDIT+"?id="+id);
			return null;
		}
        
        
        
        int result = teaService.update(tea);
		if(result>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.TEA+URLConfig.LIST+"?page=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.TEA+URLConfig.EDIT+"?id="+id);
			return null;
			
		}
    }
}
