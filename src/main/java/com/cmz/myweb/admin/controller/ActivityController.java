package com.cmz.myweb.admin.controller;

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
import com.cmz.myweb.domain.Activity;
import com.cmz.myweb.service.ActivityService;
import com.cmz.myweb.util.CommUtil;
import com.cmz.myweb.util.PageUtil;
import com.cmz.myweb.util.ViewUtil;

@Controller
@RequestMapping(URLConfig.ACTIVITY)
public class ActivityController {
	@Autowired
	private ActivityService activityService;
	
	@RequestMapping(URLConfig.LIST)
	public String list(Model model,@RequestParam(name="page",required=false,defaultValue="1")int page){
		int count = activityService.count();
		int num = 20;
		int from = (page-1)*num;
		
		List<Activity> datas = activityService.list(from, num);
		model.addAttribute("pages", PageUtil.getPages(page, count, num, URLConfig.ACTIVITY+URLConfig.LIST,null));
		model.addAttribute("datas",datas);
		return ViewUtil.getAdminView("activityList");
	}
	
	@RequestMapping(value=URLConfig.ADD)
	public String add(){
		return ViewUtil.getAdminView("activityAdd");
	}
	
	@RequestMapping(value=URLConfig.ADD_AC,method=RequestMethod.POST)
	public String add_ac(HttpServletRequest request,HttpServletResponse response,Activity activity){
		int r = activityService.add(activity);
		if(r>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.ACTIVITY+URLConfig.LIST+"?pageIndex=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.ACTIVITY+URLConfig.ADD);
			return null;

			
		}
	}
	
	@RequestMapping(value=URLConfig.EDIT)
	public String edit(Model model,int id){		
		Activity data = activityService.getActivityById(id);
		model.addAttribute("data", data);
		return ViewUtil.getAdminView("activityEdit");
	}
	
	@RequestMapping(value=URLConfig.EDIT_AC,method=RequestMethod.POST)
	public String edit_ac(HttpServletRequest request,HttpServletResponse response,Activity province){
		int r = activityService.update(province);
		if(r>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.ACTIVITY+URLConfig.LIST+"?pageIndex=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.ACTIVITY+URLConfig.ADD);
			return null;

		}
	}
	

}
