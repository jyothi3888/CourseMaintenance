package jyothi.springboot.Topic;

import java.io.IOException;
import java.lang.reflect.Type;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;


@ControllerAdvice
public class RequestbodyadviceExample  implements RequestBodyAdvice{

	@Override
	public boolean supports(MethodParameter methodParameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		// TODO Auto-generated method stub
		System.out.println("from Requestbodyaddvice support method");
		return false;
	}

	@Override
	public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("from Requestbodyaddvice bodybodtread method");
		HttpHeaders rs= inputMessage.getHeaders();
		System.out.println("content type " +rs.getContentType());
		
		return inputMessage;
	}

	@Override
	public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		// TODO Auto-generated method stub
		System.out.println("from  Requestbodyaddvice afterbodyread  method");
		try {
			System.out.println(inputMessage.getBody()+"   "+inputMessage.getClass().toString()+"   "+inputMessage.getHeaders());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	System.out.println(targetType.toString());
		return body;
	}

	@Override
	public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter,
			Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
		// TODO Auto-generated method stub
		System.out.println("from Requestbodyaddvice handleempty body  method");
	
		return body;
	}

}
