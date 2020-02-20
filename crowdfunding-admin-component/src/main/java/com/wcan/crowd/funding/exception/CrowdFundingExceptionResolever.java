package com.wcan.crowd.funding.exception;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.wcan.crowd.funding.entity.ResultEntity;
import com.wcan.crowd.funding.utils.CrowdFundingConstant;
import com.wcan.crowd.funding.utils.CrowdFundingUtils;

@ControllerAdvice
public class CrowdFundingExceptionResolever {
	
	@ExceptionHandler(value=Exception.class)
	public ModelAndView catchException(
			Exception exception, 
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		// 1.对当前请求进行检查
		boolean checkAsyncRequestResult = CrowdFundingUtils.checkAsyncRequest(request);
		
		// 2.如果是异步请求
		if(checkAsyncRequestResult) {
			
			// 根据异常类型在常量中的映射，使用比较友好的文字显示错误提示消息
			String exceptionClassName = exception.getClass().getName();
			
			String message = CrowdFundingConstant.EXCEPTION_MESSAGE_MAP.get(exceptionClassName);
			
			if(message == null) {
				message = "系统未知错误";
			}
			
			// 3.创建ResultEntity对象
			ResultEntity<String> resultEntity = ResultEntity.failed(ResultEntity.NO_DATA, message);
			
			// 4.将resultEntity转换为JSON格式
			Gson gson = new Gson();
			String json = gson.toJson(resultEntity);
			
			// 5.将json作为响应数据返回给浏览器
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(json);
			
			return null;
		}
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("exception", exception);
		
		mav.setViewName("system-error");
		
		return mav;
	}

}