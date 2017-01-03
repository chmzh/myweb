package com.cmz.myweb.admin.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.crypto.Mac;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmz.myweb.admin.dao.UserDao;
import com.cmz.myweb.admin.domain.Resource;
import com.cmz.myweb.admin.domain.User;
import com.cmz.myweb.admin.domain.UserPower;
import com.cmz.myweb.constant.GlobalConstant;
import com.cmz.myweb.constant.URLConfig;
import com.cmz.myweb.entries.Menu;
import com.cmz.myweb.util.CommUtil;
import com.cmz.myweb.util.MD5Util;


@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserPowerService userPowerService;
	
	@Autowired
	private SysMenuService sysMenuService;
	@Autowired
	private UserSchemaService userSchemaService;
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public int addUser(User user){
		int id = userDao.addUser(user);
		return id;
	}
	
	//根据ID查询
	public User getById(int id){
		return userDao.getById(id);
	}
	
	/**
	 * 用户列表
	 * @param from
	 * @param num
	 * @return
	 */
	public List<User> getUsers(int from,int num){
		List<User> users = userDao.getUsers(from, num);
		return users;
	}
	
	/**
	 * 查找用户
	 * @param uname
	 * @param pwd
	 * @return
	 */
	public User getUser(String uname,String pwd){
		User user = userDao.getUser(uname,pwd);
		return user;
	}
	
	/**
	 * 查找用户
	 * @param uname
	 * @param pwd
	 * @return
	 */
	public User getUser(String uname){
		User user = userDao.getUserByName(uname);
		return user;
	}
	
	/**
	 * 获取用户总数
	 * @return
	 */
	public int getCount(){
		return userDao.getCount();
	}
	
	/*
	 * 设置使用状态
	 * */
	public int updateEnabled(boolean enabled, int id){
		return userDao.updateEnabled(enabled, id);
	}
	
	/*
	 * 修改密码
	 * */
	public int update(String pwd, boolean enabled, int id){
		return userDao.update(pwd, enabled, id);
	}
	
	public int updateGroupid(int groupid,int id){
		return userDao.updateGroupid(id, groupid);
	}
	
	
	public String loginUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		return (String)session.getAttribute(GlobalConstant.LOGIN_NAME);
	}
	
	public int loginUserid(HttpServletRequest request){
		HttpSession session = request.getSession();
		return (int)session.getAttribute(GlobalConstant.LOGIN_UID);
	}
	
	/**
	 * 是否已登陆
	 * @param session
	 * @return
	 */
	public boolean isLogin(HttpServletRequest request){
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute(GlobalConstant.LOGIN_NAME);
		int time = session.getAttribute(GlobalConstant.LOGIN_TIME) == null?0:(int)session.getAttribute(GlobalConstant.LOGIN_TIME);
		String ip = CommUtil.getIp(request);
		String sign = (String) session.getAttribute(GlobalConstant.LOGIN_SIGN);
		
		boolean empty = StringUtils.isEmpty(name) || time == 0 || StringUtils.isEmpty(ip) || StringUtils.isEmpty(sign);
		if(empty){
			return false;
		}
		String sign1 = genSign(name, time, ip);
		if(!sign.equals(sign1)){
			return false;
		}
		return true;
	}
	
	
	
	
	/**
	 * 保存会话
	 * @param httpSession
	 */
	public void saveSession(HttpSession httpSession,String name,int userid,int time,String sign,String ip){
		httpSession.setAttribute(GlobalConstant.LOGIN_NAME, name);
		httpSession.setAttribute(GlobalConstant.LOGIN_UID, userid);
		httpSession.setAttribute(GlobalConstant.LOGIN_TIME, time);
		httpSession.setAttribute(GlobalConstant.LOGIN_SIGN, sign);
	}
	
	public void unSaveSession(HttpSession httpSession){
		httpSession.removeAttribute(GlobalConstant.LOGIN_NAME);
		httpSession.removeAttribute(GlobalConstant.LOGIN_TIME);
		httpSession.removeAttribute(GlobalConstant.LOGIN_UID);
		//httpSession.removeAttribute(GlobalConstant.LOGIN_IP);
		httpSession.removeAttribute(GlobalConstant.LOGIN_POWER);
		httpSession.removeAttribute(GlobalConstant.LOGIN_SIGN);
	}
	
	public String genSign(String name,int time,String ip){
		return MD5Util.getMD5(ip+name+time+GlobalConstant.LOGIN_KEY);
	}
	
	public int error(){
		return userDao.error(null);
	}
	
	/**
	 * 获取权限菜单
	 * @return
	 */
	public List<Menu> getMenu(int userid,int produceid){
//		String uname = loginUser(request);
//		User user = getUser(uname);
//		int groupid = user.getGroupid();
		List<Menu> menus = new LinkedList<Menu>();
		
		UserPower userPower = userPowerService.getUserPower(userid, produceid);
		String powers = userPower.getPowers();
		String schemaPowers = userSchemaService.getUserProducePower(userid, produceid);
		if(schemaPowers!=null){
			powers +=","+schemaPowers;
		}
		List<Resource> resources = sysMenuService.getUserResources(powers);
		for(Resource resource : resources){
			String model = resource.getModel();
			String action = resource.getAction();
			String name = resource.getName();
			String acname = resource.getAcname();
			boolean visible = resource.isVisible();
			int id = resource.getId();
			
			Menu menu1 = null;
			for(Menu menu : menus){
				if(menu.getModel().equals(model)){
					menu1 = menu;
				}
			}
			if(menu1==null){
				menu1 = new Menu();
				menu1.setId(id);
				menu1.setModel(model);
				menu1.setName(name);
				menu1.setVisible(visible);
				menus.add(menu1);
			}
			
			Menu subMenu = new Menu();
			subMenu.setAction(action);
			subMenu.setName(acname);
			subMenu.setVisible(visible);
			menu1.addSubMenu(subMenu);
	
		}
		return menus;
		
	}
	
	/**
	 * 验证权限
	 * @param ma
	 * @return
	 */
	public boolean verifyPower(HttpServletRequest request,String ma){
		if(ma.equals(URLConfig.HOME_DIR+URLConfig.ADMIN_CONTROLLER+"index") || ma.equals(URLConfig.HOME_DIR+URLConfig.ADMIN_CONTROLLER+"message")){
			return true;
		}
		
		String uname = loginUser(request);
		User user = getUser(uname);
		int groupid = user.getGroupid();
		int produceid = 1;
		List<Menu> menus = getMenu(loginUserid(request),produceid);
		
		String[] mas = ma.split("/");

		if(mas.length!=5){
			return false;
		}
		boolean ok = false;
		for(Menu menu:menus){
			String model = mas[3];
			if(menu.getModel().equals(model)){
				for(Menu subMenu : menu.getSubMenu()){
					if(subMenu.getAction().equals(mas[4]) || (subMenu.getAction()+".do").equals(mas[4])){
						ok = true;
						break;
					}
					
				}
				if(ok){
					break;
				}
			}
		}
		
		
		return ok;
	}
}
