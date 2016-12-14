package com.cmz.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmz.myweb.util.XSSUtil;

@Controller
@RequestMapping("/xss/")
public class XSSController {
	@RequestMapping("index")
	public String index(Model model){
		model.addAttribute("content", XSSUtil.filter("<script>alert('hello')</script>"));
		return "xss";
	}
}
