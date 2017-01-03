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

import com.cmz.myweb.admin.domain.Category;
import com.cmz.myweb.admin.domain.City;
import com.cmz.myweb.admin.domain.Country;
import com.cmz.myweb.admin.domain.Province;
import com.cmz.myweb.admin.service.AreaService;
import com.cmz.myweb.admin.service.CategoryService;
import com.cmz.myweb.constant.URLConfig;
import com.cmz.myweb.util.CommUtil;
import com.cmz.myweb.util.PageUtil;
import com.cmz.myweb.util.ViewUtil;
import com.google.gson.Gson;

@Controller
@RequestMapping(URLConfig.CITY)
public class CityController {
	@Autowired
	private AreaService areaService;
	
	@RequestMapping(URLConfig.LIST)
	public String list(Model model,@RequestParam(name="page",required=false,defaultValue="1")int page){
		int count = areaService.allProvince();
		int num = 20;
		int from = (page-1)*num;
		
		List<City> datas = areaService.listCity(from, num);
		model.addAttribute("pages", PageUtil.getPages(page, count, num, URLConfig.CITY+URLConfig.LIST,null));
		model.addAttribute("datas",datas);
		return ViewUtil.getAdminView("cityList");
	}
	
	@RequestMapping(value=URLConfig.ADD)
	public String add(Model model){
		List<Country> countries = areaService.listCountry(0, 10000);
		List<Province> provinces = areaService.getProvinces(countries.get(0).getId());
		model.addAttribute("countrys", countries);
		model.addAttribute("provinces", provinces);
		return ViewUtil.getAdminView("cityAdd");
	}
	
	@RequestMapping(value=URLConfig.ADD_AC,method=RequestMethod.POST)
	public String add_ac(HttpServletRequest request,HttpServletResponse response,City city){
		int r = areaService.addCity(city);
		if(r>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.CITY+URLConfig.LIST+"?pageIndex=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.CITY+URLConfig.ADD);
			return null;

			
		}
	}
	
	@RequestMapping(value=URLConfig.EDIT)
	public String edit(Model model,int id){
		City city = areaService.getCityById(id);
		List<Country> countries = areaService.listCountry(0, 10000);
		List<Province> provinces = areaService.getProvinces(countries.get(0).getId());
		model.addAttribute("provinces", provinces);
		model.addAttribute("countrys", countries);
		model.addAttribute("data", city);
		return ViewUtil.getAdminView("cityEdit");
	}
	
	@RequestMapping(value=URLConfig.EDIT_AC,method=RequestMethod.POST)
	public String edit_ac(HttpServletRequest request,HttpServletResponse response,City city){
		int r = areaService.updateCity(city);
		if(r>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.CITY+URLConfig.LIST+"?pageIndex=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.CITY+URLConfig.ADD);
			return null;

		}
	}
	
	@RequestMapping(value=URLConfig.JSON,method=RequestMethod.POST)
	@ResponseBody
	public String json(HttpServletResponse response,int countryid,int provinceid){
		response.addHeader("Content-Type", "text/json");
		List<City> citys = areaService.getCitys(countryid,provinceid);
		Gson gson = new Gson();
		return gson.toJson(citys);
	}
}
