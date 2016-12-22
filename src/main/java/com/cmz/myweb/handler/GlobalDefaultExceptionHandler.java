package com.cmz.myweb.handler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	public static final String DEFAULT_ERROR_VIEW = "err/message";

	@ExceptionHandler(value = NullPointerException.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		// 如果异常使用了ResponseStatus注解，那么重新抛出该异常，Spring框架会处理该异常。
		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
			throw e;

		// 否则创建ModleAndView，处理该异常。
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}

	/**
	 * 处理404
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler({NoSuchRequestHandlingMethodException.class})
	public ModelAndView http404Error(HttpServletRequest req, Exception e) throws Exception {
		// 如果异常使用了ResponseStatus注解，那么重新抛出该异常，Spring框架会处理该异常。
		// if (AnnotationUtils.findAnnotation(e.getClass(),
		// ResponseStatus.class) != null)
		// throw e;

		// 否则创建ModleAndView，处理该异常。
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}
	
	/**
	 * 处理500
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler({SQLException.class})
	public ModelAndView httpError(HttpServletRequest req, Exception e) throws Exception {
		// 如果异常使用了ResponseStatus注解，那么重新抛出该异常，Spring框架会处理该异常。
		// if (AnnotationUtils.findAnnotation(e.getClass(),
		// ResponseStatus.class) != null)
		// throw e;

		// 否则创建ModleAndView，处理该异常。
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}
	
	private void outputMessage(HttpServletResponse response, long errCode, String errMsg) throws IOException {  
//        BasicResult result = BasicResult.createFailResult(errCode, errMsg);  
//        String json = new JsonMapper().toJson(result);  
//        response.setCharacterEncoding("UTF-8");  
//        response.setContentType("text/json");  
//        ServletOutputStream os = response.getOutputStream();  
//        os.write(json.getBytes("utf-8"));  
    }  
}
