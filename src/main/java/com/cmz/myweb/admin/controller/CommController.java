package com.cmz.myweb.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmz.myweb.util.ViewUtil;

@Controller
public class CommController {
	@RequestMapping("admin/empty")
	public String empty(){
		return ViewUtil.getAdminView("empty");
	}
	
	@RequestMapping("admin/message")
	public String succMsg(Model model,String msg,String url){
		model.addAttribute("msg", msg);
		model.addAttribute("url", url);
		return ViewUtil.getAdminView("message");
	}
}
