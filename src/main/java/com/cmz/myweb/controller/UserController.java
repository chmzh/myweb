package com.cmz.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.ArrayUtils;

import com.cmz.myweb.constant.URLConfig;
import com.cmz.myweb.domain.Produce;
import com.cmz.myweb.domain.SysMenu;
import com.cmz.myweb.domain.User;
import com.cmz.myweb.domain.UserPower;
import com.cmz.myweb.service.ProduceService;
import com.cmz.myweb.service.SysMenuService;
import com.cmz.myweb.service.UserPowerService;
import com.cmz.myweb.service.UserService;
import com.cmz.myweb.util.CommUtil;
import com.cmz.myweb.util.MD5Util;
import com.cmz.myweb.util.PageUtil;

@Controller
@RequestMapping(URLConfig.USER)
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private SysMenuService sysMenuService;
	@Autowired
	private UserPowerService userPowerService;
	@Autowired
	private ProduceService produceService;
	
	/**
	 * 用户列表
	 * @param model
	 * @param pageIndex
	 * @return
	 */
	@RequestMapping(URLConfig.LIST)
	public String listUsers(Model model,@RequestParam(name="page",required=false,defaultValue="1")int page){
		int count = userService.getCount();
		int num = 20;
		int from = (page-1)*num;
		List<User> users = userService.getUsers(from, num);
		model.addAttribute("pages", PageUtil.getPages(page, count, num, URLConfig.USER+URLConfig.LIST,null));
		model.addAttribute("users",users);
		return "userList";
	}
	/**
	 * 添加用户页面
	 * @param user
	 * @return
	 */
	@RequestMapping(URLConfig.ADD)
	public String userForm(){
		return "userAdd";
	}
	
	@RequestMapping(value=URLConfig.ADD_AC,method=RequestMethod.POST)
	public String addUser(HttpServletRequest request,HttpServletResponse response,User user){
		
		if(StringUtils.isEmpty(user.getUname())){
			CommUtil.showMsg(request,response, "请填写用户名!", URLConfig.USER+URLConfig.ADD);
			return null;
		}
		
		if(StringUtils.isEmpty(user.getPwd())){
			CommUtil.showMsg(request,response, "请填写密码!", URLConfig.USER+URLConfig.ADD);
			return null;
		}
		
		if(userService.getUser(user.getUname()) != null){
			CommUtil.showMsg(request,response, "用户已存在!", URLConfig.USER+URLConfig.ADD);
			return null;
		}
		
		
		user.setPwd(MD5Util.getMD5(user.getPwd()));
		int id = userService.addUser(user);
		if(id>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.USER+URLConfig.LIST+"?pageIndex=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.USER+URLConfig.ADD);
			return null;

			
		}
	}
	
	
	@RequestMapping(URLConfig.EDIT)
    public String userEdit(HttpServletRequest request,HttpServletResponse response,Model model,
    		@RequestParam(name="id",required=false,defaultValue="1") int id) {
		
		User user = userService.getById(id);
		model.addAttribute("user",user);
        return "userEdit";
    }
	
	@RequestMapping(value=URLConfig.EDIT_AC,method=RequestMethod.POST)
	public String editUser(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "id", required = false, defaultValue = "0")int id,
			@RequestParam(value = "oldpwd", required = false, defaultValue = "")String oldpwd,
			@RequestParam(value = "pwd", required = false, defaultValue = "")String pwd,
			@RequestParam(value = "enabled", required = false, defaultValue = "true")boolean enabled
			){
		
		int result = 0;
		if(StringUtils.isEmpty(oldpwd) || StringUtils.isEmpty(pwd)){
			result = userService.updateEnabled(enabled, id);
		}else{
			User user = userService.getById(id);
			//如果不时超级管理员，则只能修改自己的密码
			if(user.getGroupid()!=1){
				if(!user.getUname().equals(userService.loginUser(request))){
					CommUtil.showMsg(request,response, "请不要修改别人的密码", URLConfig.USER+URLConfig.EDIT+"?id="+id);
					return null;
				}
			}
			if(!user.getPwd().equals(MD5Util.getMD5(oldpwd))){
				CommUtil.showMsg(request,response, "原密码密码不对", URLConfig.USER+URLConfig.EDIT+"?id="+id);
				return null;
			}
			String newPwd = MD5Util.getMD5(pwd);
			result = userService.update(newPwd, enabled, id);
		}
		
		if(result>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.USER+URLConfig.LIST);
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.USER+URLConfig.ADD);
			return null;
		}
	}
	@RequestMapping(value=URLConfig.POWER)
	public String userPower(Model model,int userid,int produceid){
		List<Produce> produces = produceService.getProduces();
		if(produceid==0){
			Produce produce = produces.get(0);
			produceid = produce.getId();
		}
		
		UserPower userPower = userPowerService.getUserPower(userid, produceid);
		//所有的父菜单
		List<SysMenu> sysMenus = sysMenuService.getSysMenuByPid(0,0,10000);
		List<SysMenu> subMenus = sysMenuService.getAllSubSysMenu();
		if(userPower!=null){
			String powers = userPower.getPowers();
			if(StringUtils.isNotEmpty(powers)){
				String[] ps = powers.split(",");
				for(SysMenu menu:subMenus){
					if(ArrayUtils.contains(ps, String.valueOf(menu.getId()))){
						menu.setFormchecked(true);
					}
				}
			}
			
			
		}
		
		model.addAttribute("userid", userid);
		model.addAttribute("produceid", produceid);
		model.addAttribute("produces", produces);
		model.addAttribute("sysMenus", sysMenus);
		model.addAttribute("subMenus", subMenus);
		
		return "userPower";
	}
	@RequestMapping(value=URLConfig.POWER_AC,method=RequestMethod.POST)
	public String userPowerAc(HttpServletRequest request,HttpServletResponse response,UserPower userPower){
		
		UserPower userPower1 = userPowerService.getUserPower(userPower.getUserid(), userPower.getProduceid());
		int r = 0;
		if(null!=userPower1){
			r = userPowerService.update(userPower);
		}else{
			r = userPowerService.add(userPower);
		}
		
		if(r>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.USER+URLConfig.LIST);
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.USER+URLConfig.ADD);
			return null;
		}
	}
	
}
