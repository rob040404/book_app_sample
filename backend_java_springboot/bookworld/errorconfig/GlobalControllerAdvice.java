package com.bookworld.errorconfig;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bookworld.books.error.InvalidBookSearchException;
import com.bookworld.user.error.BadPasswordException;
import com.bookworld.user.error.NewUserWithDifferentPasswordsException;
import com.bookworld.user.error.UserNotFoundException;

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler{

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiError> handleUserNotFoundException(UserNotFoundException ex){
		
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
	
	@ExceptionHandler(BadPasswordException.class)
	public ResponseEntity<ApiError> handleBadPasswordException(BadPasswordException ex) {
		
	    ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, ex.getMessage());
	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiError);
	}

	@ExceptionHandler(NewUserWithDifferentPasswordsException.class)
	public ResponseEntity<ApiError> handleNewUserWithDifferentPasswordsException(NewUserWithDifferentPasswordsException ex){
		
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
	
	@ExceptionHandler
	public ResponseEntity<ApiError> hanldeInvalidBookSearchException(InvalidBookSearchException ex){
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatusCode statusCode, WebRequest request) {
		 // Convertimos el HttpStatusCode a HttpStatus para usarlo en ApiError
	    HttpStatus status = HttpStatus.resolve(statusCode.value());
	    ApiError apiError = new ApiError(status != null ? status : HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
	    
	    return ResponseEntity.status(status != null ? status : HttpStatus.INTERNAL_SERVER_ERROR)
	            .headers(headers)
	            .body(apiError);
	}
	
	
}
