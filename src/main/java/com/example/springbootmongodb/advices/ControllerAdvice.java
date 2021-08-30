package com.example.springbootmongodb.advices;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

	private final static Logger log = LoggerFactory.getLogger(ControllerAdvice.class);
	private Map<String, String> map = new HashMap<>();
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Map<String, String>> handleIssuingBankDoesNotMatch(HttpServletRequest req, NoSuchElementException e) {
		log.info("handleNoSuchElementException...");
		map.put("status", String.valueOf(HttpStatus.NOT_FOUND));
		map.put("error", e.getLocalizedMessage());
		map.put("URI", req.getRequestURI());

		return new ResponseEntity<Map<String,String>>(map, HttpStatus.NOT_FOUND);
	}
}
