package com.cmz.myweb.admin.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cmz.myweb.constant.GlobalConstant;
import com.cmz.myweb.constant.URLConfig;
import com.cmz.myweb.domain.Produce;
import com.cmz.myweb.service.ProduceService;
import com.cmz.myweb.util.CommUtil;
import com.cmz.myweb.util.PageUtil;

@Controller()
@RequestMapping(URLConfig.GAME)
public class ProduceController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProduceController.class);
	@Autowired
	private ProduceService produceService;
	
	@RequestMapping(value=URLConfig.LIST, method = RequestMethod.GET)
    public String gameList(
    		@RequestParam(name="page",required=false,defaultValue="1") int page, Model model) {
		
		int count = produceService.count();
		int num = 20;
		int from = (page-1)*num;
		List<Produce> produces = produceService.getPageList(from, num);
		model.addAttribute("pages", PageUtil.getPages(page, count, num, URLConfig.GAME+URLConfig.LIST, null));
		model.addAttribute("produces",produces);
        
        return "produceList";
    }
	
	@RequestMapping(URLConfig.ADD)
    public String gameAdd(HttpServletRequest request,HttpServletResponse response,Model model) {
		return "produceAdd";
	}
	
	@RequestMapping(URLConfig.ADD_AC)
    public String gameaddAction(HttpServletRequest request,HttpServletResponse response,
    		Model model,Produce produce) {
		String orign = null;
        if(StringUtils.isEmpty(produce.getName())){
			CommUtil.showMsg(request,response, "请填写游戏名称!", URLConfig.GAME+URLConfig.ADD);
			return null;
		}
        int id = produceService.add(produce);
		if(id>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.GAME+URLConfig.LIST+"?page=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.GAME+URLConfig.ADD);
			return null;
			
		}

    }
	
	@RequestMapping(URLConfig.EDIT)
    public String gameUpdate(HttpServletRequest request,HttpServletResponse response,Model model,
    		@RequestParam(name="id",required=false,defaultValue="1") int id) {
		
		Produce produce = produceService.getById(id);
		
		model.addAttribute("produce",produce);
        return "produceEdit";
    }
	
	@RequestMapping(URLConfig.EDIT_AC)
    public String gameUpdateAction(
    		HttpServletRequest request,HttpServletResponse response,Model model,Produce produce) {
		int id = produce.getId();
		if(StringUtils.isEmpty(produce.getName())){
			CommUtil.showMsg(request,response, "请填写游戏名称!", URLConfig.GAME+URLConfig.EDIT+"?id="+id);
			return null;
		}
        
        
        
        int result = produceService.update(produce);
		if(result>0){
			CommUtil.showMsg(request,response, "操作成功", URLConfig.GAME+URLConfig.LIST+"?page=1");
			return null;
			
		}else{
			CommUtil.showMsg(request,response, "操作失败", URLConfig.GAME+URLConfig.EDIT+"?id="+id);
			return null;
			
		}
    }
}
