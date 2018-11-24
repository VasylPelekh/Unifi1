package ua.unifi1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 6576416309770019450L;

	public ResourseNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ResourseNotFoundException(String message) {
		super(message);
		
	}
	
	
}
