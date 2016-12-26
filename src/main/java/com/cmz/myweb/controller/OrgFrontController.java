package com.cmz.myweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmz.myweb.constant.URLConfig;
import com.cmz.myweb.util.ViewUtil;

@Controller
@RequestMapping(URLConfig.ORG)
public class OrgFrontController {
	@RequestMapping(URLConfig.INDEX)
	public String index(){
		return ViewUtil.getFrontView("gonglv");
	}
}
