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

import com.cmz.myweb.admin.domain.Category;
import com.cmz.myweb.admin.domain.Country;
import com.cmz.myweb.admin.service.AreaService;
import com.cmz.myweb.admin.service.CategoryService;
import com.cmz.myweb.constant.URLConfig;
import com.cmz.myweb.util.CommUtil;
import com.cmz.myweb.util.PageUtil;
import com.cmz.myweb.util.ViewUtil;

@Controller
@RequestMapping(URLConfig.COUNTRY)
public class CountryController {
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(URLConfig.LIST)
	public String list(Model model,@RequestParam(name="page",required=false,defaultValue="1")int page){
		int count = areaService.allCountry();
		int num = 20;
		int from = (page-1)*num;
		
		List<Country> datas = areaService.listCountry(from, num);
		model.addAttribute("pages", PageUtil.getPages(page, count, num, URLConfig.COUNTRY+URLConfig.LIST,null));
		model.addAttribute("datas",datas);
		return ViewUtil.getAdminView("countryList");
	}
	
	@RequestMapping(value=URLConfig.ADD)
	public String add(){		
		return ViewUtil.getAdminView("countryAdd");
	}
	
	@RequestMapping(value=URLConfig.ADD_AC,method=RequestMethod.POST)
	public String add_ac(HttpServletRequest request,HttpServletResponse response,Country country){
		int r = areaService.addCountry(country);
		if(r>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.COUNTRY+URLConfig.LIST+"?pageIndex=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.COUNTRY+URLConfig.ADD);
			return null;

			
		}
	}
	
	@RequestMapping(value=URLConfig.EDIT)
	public String edit(){		
		return ViewUtil.getAdminView("countryEdit");
	}
	
	@RequestMapping(value=URLConfig.EDIT_AC,method=RequestMethod.POST)
	public String edit_ac(HttpServletRequest request,HttpServletResponse response,Country country){
		int r = areaService.updateCountry(country);
		if(r>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.COUNTRY+URLConfig.LIST+"?pageIndex=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.COUNTRY+URLConfig.ADD);
			return null;

			
		}
	}
}
