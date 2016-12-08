package com.cmz.myweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmz.myweb.constant.URLConfig;
import com.cmz.myweb.domain.Produce;
import com.cmz.myweb.domain.Schema;
import com.cmz.myweb.domain.SysMenu;
import com.cmz.myweb.domain.User;
import com.cmz.myweb.domain.UserSchema;
import com.cmz.myweb.service.ProduceService;
import com.cmz.myweb.service.SchemaService;
import com.cmz.myweb.service.SysMenuService;
import com.cmz.myweb.service.UserSchemaService;
import com.cmz.myweb.service.UserService;
import com.cmz.myweb.util.CommUtil;
import com.cmz.myweb.util.PageUtil;

@Controller
@RequestMapping(URLConfig.SCHEMA)
public class SchemaController {
	@Autowired
	private SchemaService schemaService;
	
	@Autowired
	private ProduceService produceService;

	@Autowired
	private SysMenuService sysMenuService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserSchemaService userSchemaService;
	
	@RequestMapping(URLConfig.LIST)
	public String list(Model model,@RequestParam(name="page",required=false,defaultValue="1")int page){
		int count = schemaService.count();
		int num = 20;
		int from = (page-1)*num;
		List<Schema> datas = schemaService.list(from, num);
		model.addAttribute("pages", PageUtil.getPages(page, count, num, URLConfig.SCHEMA+URLConfig.LIST,null));
		model.addAttribute("datas",datas);
		return "schemaList";
	}
	@RequestMapping(URLConfig.ADD)
	public String add(Model model){
		List<Produce> produces = produceService.getProduces();

		//所有的父菜单
		List<SysMenu> sysMenus = sysMenuService.getSysMenuByPid(0,0,10000);
		List<SysMenu> subMenus = sysMenuService.getAllSubSysMenu();
		model.addAttribute("produces", produces);
		model.addAttribute("sysMenus", sysMenus);
		model.addAttribute("subMenus", subMenus);
		return "schemaAdd";
	}
	@RequestMapping(value=URLConfig.ADD_AC,method=RequestMethod.POST)
	public String addac(HttpServletRequest request,HttpServletResponse response,Schema schema){
		int id = schemaService.add(schema);
		if(id>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.SCHEMA+URLConfig.LIST+"?pageIndex=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.SCHEMA+URLConfig.ADD);
			return null;

			
		}
	}
	
	
	@RequestMapping(URLConfig.EDIT)
	public String add(Model model,int id){
		List<Produce> produces = produceService.getProduces();
		
		Schema schema = schemaService.getSchemaById(id);
		
		//所有的父菜单
		List<SysMenu> sysMenus = sysMenuService.getSysMenuByPid(0,0,10000);
		List<SysMenu> subMenus = sysMenuService.getAllSubSysMenu();
		
		if(schema!=null){
			String powers = schema.getPower();
			if(StringUtils.isNotEmpty(powers)){
				String[] ps = powers.split(",");
				for(SysMenu menu:subMenus){
					if(ArrayUtils.contains(ps, String.valueOf(menu.getId()))){
						menu.setFormchecked(true);
					}
				}
			}
		}
		model.addAttribute("id",id);
		model.addAttribute("produces", produces);
		model.addAttribute("schema",schema);
		model.addAttribute("sysMenus", sysMenus);
		model.addAttribute("subMenus", subMenus);
		return "schemaEdit";
	}
	
	@RequestMapping(value=URLConfig.EDIT_AC,method=RequestMethod.POST)
	public String editac(HttpServletRequest request,HttpServletResponse response,Schema schema){
		int id = schemaService.update(schema);
		if(id>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.SCHEMA+URLConfig.LIST+"?pageIndex=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.SCHEMA+URLConfig.ADD);
			return null;
		}
	}
	
	@RequestMapping(URLConfig.BINDUSER)
	public String bindUser(Model model,int schemaid){
		List<User> users = userService.getUsers(0, 10000);
		Schema schema = schemaService.getSchemaById(schemaid);
		List<UserSchema> userSchemas = userSchemaService.getUserSchemas(schemaid);
		
		for(User user:users){
			for(UserSchema userSchema:userSchemas){
				if(user.getId()==userSchema.getUserid()){
					user.setFormchecked(true);
				}
			}
		}
		StringBuilder builder = new StringBuilder();
		for(UserSchema userSchema: userSchemas){
			builder.append(userSchema.getUserid()).append(",");
		}
		
		model.addAttribute("users",users);
		model.addAttribute("schema",schema);
		model.addAttribute("ouserids", builder.toString());
		return "schemaBindUser";
	}
	@RequestMapping(value=URLConfig.BINDUSER_AC,method=RequestMethod.POST)
	public String bindUserAc(HttpServletRequest request,HttpServletResponse response,String ouserids,String userid,int schemaid){
		String[] oids = null;
		if(StringUtils.isNotEmpty(ouserids)){
			oids = ouserids.split(",");
		}else{
			oids = new String[]{};
		}
		String[] nids = null;
		if(StringUtils.isNotEmpty(userid)){
			nids = userid.split(",");
		}else{
			nids = new String[]{};
		}
		List<Integer> adduids = new ArrayList<Integer>();
		List<Integer> deluids = new ArrayList<Integer>();
		
		for(String nid:nids){
			boolean bol = false;
			for(String oid:oids){
				if(nid.equals(oid)){
					bol = true;
					break;
				}
			}
			if(bol==false){
				adduids.add(Integer.valueOf(nid));
			}
		}
		
		for(String oid:oids){
			boolean bol = false;
			for(String nid:nids){
				if(nid.equals(oid)){
					bol = true;
					break;
				}
			}
			if(bol==false){
				deluids.add(Integer.valueOf(oid));
			}
		}
		
		
		userSchemaService.batchAdd(adduids, schemaid);
		userSchemaService.batchDel(deluids, schemaid);
		CommUtil.showMsg(request,response, "操作成功", URLConfig.SCHEMA+URLConfig.LIST+"?pageIndex=1");
		return null;
	}
}
