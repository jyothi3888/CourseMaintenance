package jyothi.springboot.Topic;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;

@RestController
public class TopicController {
	@Autowired
	private TopicService topicService;
	@Value("${topic.name}")
	private String courseName1;
	@Value("${topic.concate}")
	private String concate;
	@RequestMapping()
	public String sayHello() {
		return " hello";
	}
	
	
	@RequestMapping("/Topics")
	public List<Topic> getTopics() {
		List<Topic> t= topicService.getTopics();
		t.get(0).setCourseDesc("java1234");
		return t;
	}
	
	@RequestMapping("Topic/{id}")
	public Topic getTopic(@PathVariable String id) {
		Topic t= topicService.getTopic(id);
		
		t.setCourseName(courseName1+"  "+concate);
		return t;
		 
	}
	@RequestMapping(method = RequestMethod.POST,value="Insert")
	public void insertTopic(@RequestBody Topic t) {
		topicService.insertTopic(t);
	}
	
	@RequestMapping(value="/updateTopic" ,method = RequestMethod.PUT)
	
	public void updateTopic(@RequestBody Topic t) {
		topicService.updateTopic(t);
	}

}
