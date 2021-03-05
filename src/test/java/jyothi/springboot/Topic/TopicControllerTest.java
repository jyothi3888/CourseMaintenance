package jyothi.springboot.Topic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import  org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.TestCase;
import jyothi.springboot.Topic.Topic;
import jyothi.springboot.Topic.TopicController;
import jyothi.springboot.Topic.TopicService;

@ExtendWith(MockitoExtension.class)
public class TopicControllerTest {
@Mock
	TopicService topicService;
@InjectMocks
TopicController t;
/*
@BeforeEach

void setup() throws Exception {
	MockitoAnnotations.initMocks(this);
} */
	
	@Test
	void test() {

System.out.println("test for git branch");
		
		List<Topic> topics= new ArrayList<>( Arrays.asList(new Topic("java","Java","java description"),
				new Topic("oracle","oracle","oracleDescription")
				, new Topic("postgres","postgres","postgres description")));


when(topicService.getTopics()).thenReturn(topics);
		/*Collections.sort(topics, (a,b)->a.getCourseName().compareTo(b.getCourseName()));
		topics.forEach(i ->System.out.println(i));
		topics.sort((a,b)->a.getCourseName().compareTo(b.getCourseName()));
		topics.forEach(i->System.out.println(i.getCourseName()));
		System.out.println("test");*/
		
		List<Topic> tl=t.getTopics();
		assertEquals(3, tl.size());
	}
}
