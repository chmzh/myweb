package com.cmz.myweb.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmz.myweb.admin.domain.User;

@RestController
@RequestMapping("/rest/")
public class Rest1Controller {
	
	@RequestMapping("index")
	public User showUser(){
		User user = new User();
		user.setUname("你好");
		return user;
	}
}
