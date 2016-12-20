package com.cmz.myweb.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test/")
public class TestController {
	@RequestMapping("hello")
	public String index(Model model){
		model.addAttribute("content", "模型中文测试");
		return "hello";
	}
	
	@RequestMapping("hello1")
	@ResponseBody
	public String index1(Model model){
		model.addAttribute("content", "模型中文测试");
		return "你好";
	}
}
