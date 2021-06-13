package jyothi.springboot.Topic;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository<Topic, String>{
	
	
/*	@Query (value="update topic set courseName=? where id=?")
	@Modifying
	public void updateTopic(String courseName,int id);
	*/

}
