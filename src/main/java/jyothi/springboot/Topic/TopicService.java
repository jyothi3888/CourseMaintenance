package jyothi.springboot.Topic;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.Comparator;

import io.swagger.models.HttpMethod;

@Service
public class TopicService {
	
	
	RestTemplate resttemplate=new RestTemplate();
	
	
	Logger l= org.slf4j.LoggerFactory.getLogger(TopicService.class);
	@Autowired
	TopicRepository tr;
	
	void TopicService(RestTemplateBuilder resttemplatebuilder) {
		this.resttemplate=resttemplatebuilder.build();
	}

	List<Topic> topics= new ArrayList<>( Arrays.asList(new Topic("java","Java","java description"),
						new Topic("oracle","oracle","oracleDescription")
						, new Topic("postgres","postgres","postgres description")));
	
	public void test() {
		System.out.println("Testing");
	}

	public List<Topic> getTopics() {
		
	
		List<Topic> t=new ArrayList();
		//
	

				tr.findAll().forEach(t::add);
				return t;
	}


	@Cacheable(value="topics1",key="'Topic1'+#id")
	
	public Topic getTopic(String id) throws URISyntaxException {
		
		String baseurl="http://localhost:8000/Tutor/Tutor/1";
		URI uri=new URI(baseurl);
		ResponseEntity<Tutor> t= resttemplate.getForEntity(uri, Tutor.class);
		String baseurl2="http://localhost:8000/Tutor/AddTutor";
		URI uri2= new URI(baseurl2);
		Tutor tut= new Tutor(5,"xyz");
		resttemplate.postForEntity(uri2, tut, String.class);
		
		Tutor x=t.getBody();
		System.out.println(x.getTutorName());
		
		l.debug("from get topic  method");
		return tr.findById(id).get();
				
				//topics.stream().filter(t ->t.getCourseId().equals(id)).findFirst().get();
	}


	public void insertTopic(Topic t) {
		
		
		
	
		tr.save(t);
		
	}

@CachePut(value="topics1",key="'Topic1'+#to.courseId" )
	public Topic updateTopic(Topic to) {
	l.debug("from update topic  method");
		// TODO Auto-generated method stub
		
		/*Topic topic =topics.stream().filter(t1 ->t1.getCourseId().equals(t.getCourseId())).findFirst().get();
		topic.setCourseName(t.getCourseName());
		topic.setCourseDesc(t.getCourseDesc());*/
		tr.save(to);
		return to;
	}
}
