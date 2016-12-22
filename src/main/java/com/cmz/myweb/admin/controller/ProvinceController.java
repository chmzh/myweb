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
import com.cmz.myweb.domain.Country;
import com.cmz.myweb.domain.Province;
import com.cmz.myweb.service.AreaService;
import com.cmz.myweb.service.CategoryService;
import com.cmz.myweb.util.CommUtil;
import com.cmz.myweb.util.PageUtil;
import com.cmz.myweb.util.ViewUtil;
import com.google.gson.Gson;

@Controller
@RequestMapping(URLConfig.PROVINCE)
public class ProvinceController {
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(URLConfig.LIST)
	public String list(Model model,@RequestParam(name="page",required=false,defaultValue="1")int page){
		int count = areaService.allProvince();
		int num = 20;
		int from = (page-1)*num;
		
		List<Province> datas = areaService.listProvince(from, num);
		model.addAttribute("pages", PageUtil.getPages(page, count, num, URLConfig.PROVINCE+URLConfig.LIST,null));
		model.addAttribute("datas",datas);
		return ViewUtil.getAdminView("provinceList");
	}
	
	@RequestMapping(value=URLConfig.ADD)
	public String add(Model model){
		List<Country> countries = areaService.listCountry(0, 10000);
		model.addAttribute("countrys", countries);
		return ViewUtil.getAdminView("provinceAdd");
	}
	
	@RequestMapping(value=URLConfig.ADD_AC,method=RequestMethod.POST)
	public String add_ac(HttpServletRequest request,HttpServletResponse response,Province province){
		int r = areaService.addProvince(province);
		if(r>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.PROVINCE+URLConfig.LIST+"?pageIndex=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.PROVINCE+URLConfig.ADD);
			return null;

			
		}
	}
	
	@RequestMapping(value=URLConfig.EDIT)
	public String edit(Model model,int id){		
		
		Province data = areaService.getProvinceById(id);
		
		List<Country> countries = areaService.listCountry(0, 10000);
		model.addAttribute("countrys", countries);
		model.addAttribute("data", data);
		return ViewUtil.getAdminView("provinceEdit");
	}
	
	@RequestMapping(value=URLConfig.EDIT_AC,method=RequestMethod.POST)
	public String edit_ac(HttpServletRequest request,HttpServletResponse response,Province province){
		int r = areaService.updateProvince(province);
		if(r>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.PROVINCE+URLConfig.LIST+"?pageIndex=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.PROVINCE+URLConfig.ADD);
			return null;

		}
	}
	
	@RequestMapping(value=URLConfig.JSON,method=RequestMethod.POST)
	@ResponseBody
	public String json(HttpServletResponse response,int countryid){
		response.addHeader("Content-Type", "text/json");
		List<Province> provinces = areaService.getProvinces(countryid);
		Gson gson = new Gson();
		return gson.toJson(provinces);
	}
}
