package com.cmz.myweb.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmz.myweb.admin.domain.City;
import com.cmz.myweb.admin.domain.Country;
import com.cmz.myweb.admin.domain.Organization;
import com.cmz.myweb.admin.domain.Orgtype;
import com.cmz.myweb.admin.domain.Province;
import com.cmz.myweb.admin.service.AreaService;
import com.cmz.myweb.admin.service.OrganizationService;
import com.cmz.myweb.admin.service.OrgtypeService;
import com.cmz.myweb.constant.URLConfig;
import com.cmz.myweb.util.CommUtil;
import com.cmz.myweb.util.PageUtil;
import com.cmz.myweb.util.ViewUtil;

@Controller
@RequestMapping(URLConfig.ORGANIZITION)
public class OrganizationController {
	@Autowired
	private OrgtypeService orgtypeService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping(URLConfig.LIST)
	public String list(Model model,@RequestParam(name="page",required=false,defaultValue="1")int page){
		int count = organizationService.count();
		int num = 20;
		int from = (page-1)*num;
		
		List<Organization> datas = organizationService.list(from, num);
		model.addAttribute("pages", PageUtil.getPages(page, count, num, URLConfig.ORGANIZITION+URLConfig.LIST,null));
		model.addAttribute("datas",datas);
		return ViewUtil.getAdminView("organizationList");
	}
	
	@RequestMapping(value=URLConfig.ADD)
	public String add(Model model){	
		List<Country> countrys = areaService.listCountry(0, 1000);
		List<Province> provinces = areaService.getProvinces(countrys.get(0).getId());
		List<City> citys = areaService.getCitys(countrys.get(0).getId(), provinces.get(0).getId());
		List<Orgtype> orgtypes = orgtypeService.list(0, 100);
		model.addAttribute("orgtypes", orgtypes);
		model.addAttribute("countrys", countrys);
		model.addAttribute("provinces", provinces);
		model.addAttribute("citys", citys);
		return ViewUtil.getAdminView("organizationAdd");
	}
	@RequestMapping(value=URLConfig.ADD_AC,method=RequestMethod.POST)
	public String addac(HttpServletRequest request,HttpServletResponse response,Organization organization){
		int r = organizationService.add(organization);
		if(r>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.ORGANIZITION+URLConfig.LIST+"?pageIndex=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.ORGANIZITION+URLConfig.ADD);
			return null;

		}
	}
	
	@RequestMapping(value=URLConfig.EDIT)
	public String edit(Model model,int id){	
		
		Organization data = organizationService.getOrganizationById(id);
		List<Country> countrys = areaService.listCountry(0, 1000);
		List<Province> provinces = areaService.getProvinces(data.getCountryid());
		List<City> citys = areaService.getCitys(data.getCountryid(), data.getProvinceid());
		List<Orgtype> orgtypes = orgtypeService.list(0, 100);
		
		if(!data.getOrgtypeid().equals("")){
			String[] ids = data.getOrgtypeid().split(",");
			for(String id1 : ids){
				for(Orgtype orgtype : orgtypes){
					if(orgtype.getId() == Integer.valueOf(id1)){
						orgtype.setChecked("checked='checked'");
						break;
					}
				}
			}
			
		}
		
		model.addAttribute("orgtypes", orgtypes);
		model.addAttribute("countrys", countrys);
		model.addAttribute("provinces", provinces);
		model.addAttribute("citys", citys);
		model.addAttribute("data", data);
		return ViewUtil.getAdminView("organizationEdit");
	}
	
	@RequestMapping(value=URLConfig.EDIT_AC,method=RequestMethod.POST)
	public String editac(HttpServletRequest request,HttpServletResponse response,Organization organization){
		int r = organizationService.update(organization);
		if(r>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.ORGANIZITION+URLConfig.LIST+"?pageIndex=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.ORGANIZITION+URLConfig.ADD);
			return null;

		}
	}
}
