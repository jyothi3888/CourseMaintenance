package jyothi.springboot.Topic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@PropertySource("db.properties")
public class CourseMaintenance {

	public static void main(String[] args) {
		SpringApplication.run(CourseMaintenance.class, args);
	}

}
