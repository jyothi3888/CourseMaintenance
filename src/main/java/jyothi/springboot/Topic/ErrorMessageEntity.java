package jyothi.springboot.Topic;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ErrorMessageEntity {
	private HttpStatus statuscode;
	private String OriginalException;
	private LocalDate date;
	private LocalTime time;

}
