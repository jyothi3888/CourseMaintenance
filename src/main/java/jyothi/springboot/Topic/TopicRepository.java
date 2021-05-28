package jyothi.springboot.Topic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface TopicRepository extends CrudRepository<Topic, String>{

}
