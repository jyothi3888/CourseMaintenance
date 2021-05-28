package jyothi.springboot.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class interceptorRegistry implements WebMvcConfigurer{

	@Autowired
	private  InterceptorExample interceptorExample;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		

		registry.addInterceptor(interceptorExample);
	}

}
