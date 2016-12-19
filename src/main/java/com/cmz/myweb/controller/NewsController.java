package com.cmz.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cmz.myweb.constant.URLConfig;
import com.cmz.myweb.util.ViewUtil;

@Controller
@RequestMapping(URLConfig.NEWS)
public class NewsController {
	@RequestMapping(URLConfig.ADD)
	public String add(){
		return ViewUtil.getAdminView("newsAdd");
	}
	
	@RequestMapping(value=URLConfig.ADD_AC,method=RequestMethod.POST)
	public String addac(Model model,String editor1){
		model.addAttribute("content", editor1);
		return ViewUtil.getAdminView("newsAdd");
	}
}
