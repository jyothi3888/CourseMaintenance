package jyothi.springboot.Topic;

import java.util.Iterator;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class InterceptorExample implements  HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	System.out.println("content type "+ request.getContentType());
	response.setContentType("application/json");
	/*if(request.getContentType().equalsIgnoreCase("application/json")) {
		response.sendRedirect("/TopicsJson");
	} else {
		response.sendRedirect("/TopicsXml");
	} */
	
	
	RequestDispatcher rs= request.getRequestDispatcher("/TopicsJson");
	rs.include(request, response);
	/*
Iterator i =request.getHeaderNames().asIterator();
	while(i.hasNext()) {
		System.out.println(i.next());
	}*/
		
	//if(Optional.ofNullable(request.getContentType()).toString().equalsIgnoreCase(MediaType.APPLICATION_XML_VALUE))

		//response.sendre
return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	

}
