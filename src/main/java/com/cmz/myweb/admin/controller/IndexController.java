package com.cmz.myweb.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cmz.myweb.domain.User;
import com.cmz.myweb.entries.Menu;
import com.cmz.myweb.entries.UserPowerEntry;
import com.cmz.myweb.service.ProduceService;
import com.cmz.myweb.service.UserPowerService;
import com.cmz.myweb.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ProduceService produceService;
	@Autowired
	private UserPowerService userPowerService;
	
	@RequestMapping("index")
	public String index(HttpServletRequest request,HttpServletResponse response,Model model){
		String uname = userService.loginUser(request);
		model.addAttribute("adminUser",uname);
		User user = userService.getUser(uname);
		int produceid = 1;
		List<Menu> menus = userService.getMenu(userService.loginUserid(request),produceid);
		model.addAttribute("menus", menus);
		
		List<UserPowerEntry> userPowers = userPowerService.getUserPowerEntrys(userService.loginUserid(request));
		model.addAttribute("userPowers", userPowers);
		
		return "index";
	}
}
