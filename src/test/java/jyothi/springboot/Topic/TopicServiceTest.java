package jyothi.springboot.Topic;

import static org.junit.jupiter.api.Assertions.*;

<<<<<<< HEAD
import org.junit.jupiter.api.Test;

class TopicServiceTest {

	@Test
	void test() {assertTrue(true);
	}
	@Test
	void test2() {assertTrue(true);
	}
=======
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

class TopicServiceTest {
	@Mock
	
	TopicRepository tr;

	List<Topic> topics= new ArrayList<>( Arrays.asList(new Topic("java","Java","java description"),
			new Topic("oracle","oracle","oracleDescription")
			, new Topic("postgres","postgres","postgres description")));

	@Test
	void getAllTopicsTest() {
		List<Topic> t=new ArrayList<>();
		
	//	Mockito.when(tr.findAll()).thenReturn(topics);
		assertEquals(true, true);

	}

>>>>>>> 2609f6f34eaa20ef83085e248213502f1f532d8b
}
