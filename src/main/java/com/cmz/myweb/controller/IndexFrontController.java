package com.cmz.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmz.myweb.util.ViewUtil;

@Controller

public class IndexFrontController {
	@RequestMapping("index11")
	public String index(){
		return ViewUtil.getFrontView("index");
	}
}
