package com.cmz.myweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cmz.myweb.constant.URLConfig;
import com.cmz.myweb.service.UserService;
import com.cmz.myweb.util.CommUtil;

public class SystemInterceptor implements HandlerInterceptor {
	static Log log = LogFactory.getLog(SystemInterceptor.class);
	@Autowired
	private UserService userService;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String requestUri = request.getRequestURI();
		if (requestUri.indexOf(URLConfig.LOGIN_AC) > 0 || 
				requestUri.indexOf(URLConfig.LOGIN) > 0 || 
				requestUri.indexOf(URLConfig.LOGIN_CODE_IMG)>0||
				requestUri.indexOf("json")>0 ||
				requestUri.indexOf("browser")>0 ||
				requestUri.indexOf("customer/api")>0 ||
				requestUri.indexOf("customer/api/server/op")>0 ||
				requestUri.indexOf("test")>0 ||
				requestUri.indexOf("api/st")>0
				) {
			return true;
		}
		
		
		boolean isLogin = true;
/*		
		boolean isLogin = userService.isLogin(request);
		if(!isLogin){
			response.sendRedirect(URLConfig.HOME_DIR+URLConfig.LOGIN);
			return false;
		}
		
		boolean power = userService.verifyPower(request, requestUri);
		if(!power){
			CommUtil.showMsg(request, response, "该页不存在,请联系管理员", URLConfig.HOME_DIR+URLConfig.INDEX);
			return true;
		}
		*/
		//log.debug("验证成功");

		// TODO 功能权限验证
		// userService.hasPermission(roleId, permission)

		return isLogin;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(modelAndView!=null && modelAndView.getModel()!=null){
			modelAndView.getModel().put("home", URLConfig.HOME_DIR);
			
		}
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
