package jyothi.springboot.Topic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;





@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Topic {
	@Id
	@Column(name="courseid")
	String courseId;
	@Column(name="course_name")
	String courseName;
	@Column(name="course_desc")
	String courseDesc;
	
	
	
	
	
	
	
	
	

}
