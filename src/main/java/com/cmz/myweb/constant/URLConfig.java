package com.cmz.myweb.constant;

public class URLConfig {
	public final static String HOME_DIR = "/myweb/";
	
	public final static String ADMIN_CONTROLLER = "admin/";
	
	public final static String ADMIN_LOGIN = ADMIN_CONTROLLER+"login";   //登陆页面
	public final static String ADMIN_LOGIN_AC = ADMIN_CONTROLLER+"login.do";    //登陆动作
	
	public final static String ADMIN_LOGOUT = ADMIN_CONTROLLER+"logout";   //登陆页面

	
	public final static String LOGIN_CODE_IMG = ADMIN_CONTROLLER+"login_code";    //验证码
	
	public final static String ADMIN_INDEX = ADMIN_CONTROLLER+"index";                //index页
	
	//控制器
	public final static String USER = ADMIN_CONTROLLER+"user/";         //用户管理 控制器
	public final static String GROUP = ADMIN_CONTROLLER+"group/";       //组管理 控制器
	public final static String RESOURCE = ADMIN_CONTROLLER+"resource/"; //资源管理 控制器
	public final static String GAME = ADMIN_CONTROLLER+"game/";         //游戏管理 控制器
	public final static String LOG = ADMIN_CONTROLLER+"log/";           //日志管理 控制器
	public final static String GAMEPARTNER = ADMIN_CONTROLLER+"gamepartner/";
	public final static String GAMESERVER = ADMIN_CONTROLLER+"gameserver/";
	public final static String SYSMENU = ADMIN_CONTROLLER+"sysmenu/";
	public final static String SCHEMA = ADMIN_CONTROLLER+"schema/";
	public final static String BINDUSER = ADMIN_CONTROLLER+"binduser";      //删除动作
	public final static String BINDUSER_AC = ADMIN_CONTROLLER+"binduser.do";      //删除动作
	public final static String STATISTIC = ADMIN_CONTROLLER+"statistic/";           //统计 控制器
	public final static String NEWS = ADMIN_CONTROLLER+"news/";
	
	public final static String CATEGORY = ADMIN_CONTROLLER+"category/";
	
	public final static String UPLOAD = ADMIN_CONTROLLER+"upload/";
	
	public final static String COUNTRY = ADMIN_CONTROLLER+"country/";
	public final static String PROVINCE = ADMIN_CONTROLLER+"province/";
	public final static String CITY = ADMIN_CONTROLLER+"city/";
	
	public final static String ORGTYPE = ADMIN_CONTROLLER+"orgtype/";  //机构类型
	public final static String ORGANIZITION = ADMIN_CONTROLLER+"organization/"; //机构信息
	
	public final static String ACTIVITY = ADMIN_CONTROLLER+"activity/";
	
	//页面 动作 资源
	public final static String LIST = "list";          //列表
	public final static String ADD = "add";            //添加表单页面
	public final static String ADD_AC = "add.do";      //添加动作
	public final static String EDIT = "edit";          //编辑表单页面
	public final static String EDIT_AC = "edit.do";    //编辑动作
	public final static String DEL = "del";            //删除表单页面
	public final static String DEL_AC = "del.do";      //删除动作
	
	public final static String POWER = "power";        //权限管理
	public final static String POWER_AC = "power.do";  //保存权限
	
	public final static String JSON = "json";
	
	public final static String UPLOADFILE = "uploadfile";
	public final static String UPLOADFILE1 = "uploadfile1";
	
	
	//前台
	public final static String FRONT = "front/";
	
	public final static String LOGIN = FRONT+"login/";
	public final static String ARTICLE = FRONT+"article/";
	public final static String ORG = FRONT+"org/";
	
	public final static String INDEX = "index";
	public final static String DETAIL = "detail";
}
