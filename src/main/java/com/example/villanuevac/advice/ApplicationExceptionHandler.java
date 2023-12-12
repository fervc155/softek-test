package com.example.villanuevac.advice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> constraintViolationException(ConstraintViolationException ex, WebRequest request) {
	  List<String> errors = new ArrayList<>();
	  
	  ex.getConstraintViolations().forEach(cv -> errors.add(cv.getMessage()));
	  
	  Map<String, List<String>> result = new HashMap<>();
	  
	  result.put("errors", errors);
	  
	  return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
	

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return errorMap;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public Map<String, String> exception(Exception ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", ex.getMessage());
        return errorMap;
    }
}
