package com.cmz.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmz.myweb.util.ViewUtil;

@Controller
@RequestMapping("/org/")
public class OrgFrontController {
	@RequestMapping("index")
	public String index(){
		return ViewUtil.getFrontView("gonglv");
	}
}
