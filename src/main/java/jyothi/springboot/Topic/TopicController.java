package jyothi.springboot.Topic;


import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.sun.el.util.ReflectionUtil;
 

@RestController

public class TopicController {
	@Autowired
	private TopicService topicService;
	@Value("${topic.name}")
	private String courseName1;
	@Value("${topic.concate}")
	private String concate;
	Logger logger = LoggerFactory.getLogger(TopicController.class);
	@GetMapping()
	public String sayHello() {
		return " hellov";
	}
	
	@GetMapping(path="TopicsXml" ,produces=MediaType.APPLICATION_XML_VALUE)

	public List<Topic> getTopics() {
		logger.debug("this is error message");
		List<Topic> t= topicService.getTopics();
		t.get(0).setCourseDesc("java1234");
		return t;
	}
	
	
	@GetMapping(path="TopicsJson" ,produces=MediaType.APPLICATION_JSON_VALUE)

	public List<Topic> getTopicsJson() {
		logger.debug("this is error message");
		List<Topic> t= topicService.getTopics();
		t.get(0).setCourseDesc("java1234");
		return t;
	}

	@Cacheable(value = "xyz" ,key = "'Cache'+#id")
	
	@GetMapping(path="TopicXml/{xmlid}" ,produces=MediaType.APPLICATION_XML_VALUE)

	
	public Topic getTopicXML(@PathVariable String xmlid) throws InterruptedException {
		System.out.println("xml controller");
		Topic t= topicService.getTopic(xmlid);
		Thread.sleep(5000);
		t.setCourseName(courseName1+"  "+concate);
	
		return t;
		 
	}
	
	@GetMapping(path="TopicJson/{jsonid}" ,produces=MediaType.APPLICATION_JSON_VALUE)
	
	public Topic getTopicJSON(@PathVariable String jsonid) throws InterruptedException {
		System.out.println("json controller");
		Topic t= topicService.getTopic(jsonid);
		Thread.sleep(5000);
		t.setCourseName(courseName1+"  "+concate);
		/*if(0==0)
		throw new ArithmeticException();
		*/
		
		return t;
		 
	}
	@RequestMapping(method = RequestMethod.POST,value="Insert")
	public void insertTopic(@RequestBody Topic t) {
	
		topicService.insertTopic(t);
		throw new ArithmeticException("this is from insert method for testing");
	}
	
	@RequestMapping(value="/updateTopic" ,method = RequestMethod.PUT)
	
	public void updateTopic(@RequestBody Topic t) {
		topicService.updateTopic(t);
	}
	
	@PatchMapping(value="/patch/{id}")
	public void patchTest(@PathVariable String id,@RequestBody Map<String,String> columns) {
		Topic t=topicService.getTopic(id);
		columns.forEach((k,v)->{
		
		Field f= ReflectionUtils.findField(t.getClass(), (String) k)  ;
		f.setAccessible(true);
		ReflectionUtils.setField(f, t, v);
		
	});
		topicService.updateTopic(t);
	}
	

}
