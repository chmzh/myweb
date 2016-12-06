package com.cmz.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/")
public class TestController {
	@RequestMapping("hello")
	public String index(Model model){
		model.addAttribute("content", "模型中文测试");
		return "hello";
	}
}
