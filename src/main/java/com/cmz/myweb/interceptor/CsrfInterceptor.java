package com.cmz.myweb.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cmz.myweb.constant.URLConfig;
import com.cmz.myweb.util.CsrfTokenManager;

public class CsrfInterceptor extends HandlerInterceptorAdapter {

//	@Autowired
//	private HttpSessionCsrfTokenRepository tokenRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(CsrfInterceptor.class);
	private static String csrfToken;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if ("POST".equalsIgnoreCase(request.getMethod())) {

			String CsrfToken = CsrfTokenManager.getTokenFromRequest(request);

			if (CsrfToken == null || !CsrfToken.equals(request.getSession().getAttribute(

					CsrfTokenManager.CSRF_TOKEN_FOR_SESSION_ATTR_NAME))) {

				String reLoginUrl = "/login?backurl="

						+ URLEncoder.encode(getCurrentUrl(request), "utf-8");

				response.sendRedirect(reLoginUrl);

				return false;

			}

		}else{
			//csrfToken = tokenRepository.loadToken(request);//CsrfTokenManager.createTokenForSession(request.getSession());
			csrfToken = CsrfTokenManager.createTokenForSession(request.getSession());
		}

		return true;

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(modelAndView!=null && modelAndView.getModel()!=null){
			modelAndView.getModel().put(CsrfTokenManager.CSRF_PARAM_NAME, csrfToken);
			
		}
		
	}
	
	private String getCurrentUrl(HttpServletRequest request) {

		String currentUrl = request.getRequestURL().toString();

		if (!StringUtils.isEmpty(request.getQueryString())) {

			currentUrl += "?" + request.getQueryString();

		}

		return currentUrl;

	}

}
