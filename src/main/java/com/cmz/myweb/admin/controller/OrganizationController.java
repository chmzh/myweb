package com.cmz.myweb.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmz.myweb.constant.URLConfig;
import com.cmz.myweb.domain.Orgtype;
import com.cmz.myweb.service.OrgtypeService;
import com.cmz.myweb.util.ViewUtil;

@Controller
@RequestMapping(URLConfig.ORGANIZITION)
public class OrganizationController {
	@Autowired
	private OrgtypeService orgtypeService;
	
	@RequestMapping(URLConfig.LIST)
	public String list(Model model,@RequestParam(name="page",required=false,defaultValue="1")int page){
//		int count = orgtypeService.count();
//		int num = 20;
//		int from = (page-1)*num;
//		
//		List<Orgtype> datas = orgtypeService.list(from, num);
//		model.addAttribute("pages", PageUtil.getPages(page, count, num, URLConfig.ORGTYPE+URLConfig.LIST,null));
//		model.addAttribute("datas",datas);
		return ViewUtil.getAdminView("organizationList");
	}
	
	@RequestMapping(value=URLConfig.ADD)
	public String add(Model model){	
		List<Orgtype> orgtypes = orgtypeService.list(0, 100);
		model.addAttribute("orgtypes", orgtypes);
		return ViewUtil.getAdminView("organizationAdd");
	}
	
	@RequestMapping(value=URLConfig.EDIT)
	public String edit(){		
		return ViewUtil.getAdminView("organizationEdit");
	}
}
