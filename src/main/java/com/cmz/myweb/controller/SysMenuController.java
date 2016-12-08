package com.cmz.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmz.myweb.constant.URLConfig;
import com.cmz.myweb.domain.SysMenu;
import com.cmz.myweb.service.SysMenuService;
import com.cmz.myweb.util.CommUtil;
import com.cmz.myweb.util.PageUtil;

@Controller
@RequestMapping(URLConfig.SYSMENU)
public class SysMenuController {
	@Autowired
	private SysMenuService sysMenuService;
	
	@RequestMapping(URLConfig.LIST)
	public String list(Model model,@RequestParam(name="page",required=false,defaultValue="1")int page){
		int count = sysMenuService.getCount();
		int num = 20;
		int from = (page-1)*num;
		
		List<SysMenu> menus = sysMenuService.getSysMenuByPid(0,from,num);
		model.addAttribute("pages", PageUtil.getPages(page, count, num, URLConfig.SYSMENU+URLConfig.LIST,null));
		model.addAttribute("menus",menus);
		return "sysMenuList";
	}
	
	@RequestMapping(value=URLConfig.ADD)
	public String add(Model model,@RequestParam(name="id",required=false,defaultValue="0")int id){
		SysMenu sysMenu = sysMenuService.getSysMenuById(id);
		if(null!=sysMenu){
			model.addAttribute("parentid", sysMenu.getId());
			model.addAttribute("name", sysMenu.getName());
			model.addAttribute("model", sysMenu.getModel());
		}else{
			model.addAttribute("parentid", 0);
			model.addAttribute("name", "");
			model.addAttribute("model", "");
		}
		
		return "sysMenuAdd";
	}
	
	@RequestMapping(value=URLConfig.ADD_AC,method=RequestMethod.POST)
	public String add_ac(HttpServletRequest request,HttpServletResponse response,SysMenu sysMenu){
		int r = sysMenuService.addSysMenu(sysMenu);
		if(r>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.SYSMENU+URLConfig.LIST+"?pageIndex=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.SYSMENU+URLConfig.ADD);
			return null;

			
		}
	}
}
