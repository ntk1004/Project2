package com.javaweb.controlleradvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.modol.ErrorResonseDTO;

import customexception.FielRequiredException;
@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(FielRequiredException.class)
	public ResponseEntity <Object> handleFielRequiredException(
			FielRequiredException ex , WebRequest request){
		ErrorResonseDTO error = new ErrorResonseDTO();
		error.setErr(ex.getMessage());
		List<String> l = new ArrayList<>();
		l.add("Lỗi thiếu dữ liệu");
		error.setLi(l);
		return new ResponseEntity(error ,HttpStatus.BAD_GATEWAY);
	} 
@ExceptionHandler(ArithmeticException.class)
public ResponseEntity<Object> handleArgumentException (
		ArithmeticException ex , WebRequest request){
	ErrorResonseDTO error = new ErrorResonseDTO();
	error.setErr(ex.getMessage());
	List<String> l = new ArrayList<>();
	l.add("Lỗi chia cho không");
	error.setLi(l);
	return new ResponseEntity<>(error , HttpStatus.INTERNAL_SERVER_ERROR);
}
 
	}
 