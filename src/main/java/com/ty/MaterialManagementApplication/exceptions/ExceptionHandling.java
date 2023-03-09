package com.ty.MaterialManagementApplication.exceptions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.MaterialManagementApplication.util.ResponseStructure;


@ControllerAdvice
public class ExceptionHandling extends  ResponseEntityExceptionHandler{

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandlerEntity(IdNotFoundException ex){
		ResponseStructure<String> response = new ResponseStructure<>();
		response.setMessage("Given id is not present");
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setData("No data found for given ID");
		return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
	}
	
	
	
	
	
	
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructure<String>> NoSuchElementFoundExceptionHandlerEntity(NoSuchElementException no){
		ResponseStructure<String> response = new ResponseStructure<>();
		response.setMessage("Invalid ID");
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setData("No data found for given ID");
		return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> error = ex.getAllErrors();
		Map<String, String> map =new  LinkedHashMap<String, String>();
		for (ObjectError objectError : error) {
			String fieldName = ((FieldError) objectError).getField();
			String message = ((FieldError) objectError).getDefaultMessage();
			map.put(fieldName, message);
		}
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}
//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<ResponseStructure<String>> getException(ConstraintViolationException ex){
//		ResponseStructure<String> response = new ResponseStructure<>();
//		response.setMessage("Give valid input");
//		response.setStatus(HttpStatus.BAD_REQUEST.value());
//		response.setMessage(ex.getMessage());
//		return new ResponseEntity<ResponseStructure<String>>(response,HttpStatus.BAD_REQUEST);
//	}
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstriantEntityViolationException(ConstraintViolationException constExcep) {

		Set<ConstraintViolation<?>> set = constExcep.getConstraintViolations();
		List<String> list = new ArrayList<>();
		for (ConstraintViolation<?> constViolation : set) {
			String name = constViolation.getMessage();
			list.add(name);
		}
		return new ResponseEntity<Object>(list, HttpStatus.BAD_REQUEST);
	}
	
}
