package jyothi.springboot.Topic;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;


public class TopicFilter  implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// TODO Auto-generated method stub
		HttpServletRequest hsr=(HttpServletRequest)request;
		
		if(hsr.getRequestURI().toLowerCase().contains("xml" )){
			if(hsr.getContentType().toLowerCase().contains("xml"))
			chain.doFilter(request, response);
			else
			{
				try {
				throw new MyDefinedException("REquest URI contains XML but content type is not xml");
			} catch (Exception e) {
				HandlerExceptionResolver her=new HandlerExceptionResolver() {
					
					@Override
					public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
							Exception ex) {
						// TODO Auto-generated method stub
						return null;
					}
				};
			}
			}
			
		} 
	}

}
