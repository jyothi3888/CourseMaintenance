package jyothi.springboot.Topic;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerExample {

	
	@ExceptionHandler({Exception.class})
	public ResponseEntity MyExcpetionHandler(Exception ex,WebRequest req) {
		
		System.out.println("entered into exception handler");
		System.out.println(ex.getMessage());
		System.out.println(req.getContextPath());
		ErrorMessageEntity eme=new ErrorMessageEntity(HttpStatus.BAD_REQUEST
				,ex.getMessage(),
				LocalDate.now(),
				LocalTime.now());
		List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        //ErrorResponse error = new ErrorResponse("Record Not Found", details);
        return new ResponseEntity(eme, HttpStatus.BAD_REQUEST);

}
}
