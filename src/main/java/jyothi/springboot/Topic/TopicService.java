package jyothi.springboot.Topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctc.wstx.shaded.msv_core.datatype.xsd.Comparator;

@Service
public class TopicService {
	@Autowired
	TopicRepository tr;
	
	void TopicService() {
		
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

	
	public Topic getTopic(String id) {
		return tr.findById(id).get();
				
				//topics.stream().filter(t ->t.getCourseId().equals(id)).findFirst().get();
	}


	public void insertTopic(Topic t) {
		tr.save(t);
		
	}


	public void updateTopic(Topic t) {
		// TODO Auto-generated method stub
		
		/*Topic topic =topics.stream().filter(t1 ->t1.getCourseId().equals(t.getCourseId())).findFirst().get();
		topic.setCourseName(t.getCourseName());
		topic.setCourseDesc(t.getCourseDesc());*/
		tr.save(t);
	}
}
