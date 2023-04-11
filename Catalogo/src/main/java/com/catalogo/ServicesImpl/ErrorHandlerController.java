package com.catalogo.ServicesImpl;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<?> errorForeignKey(SQLIntegrityConstraintViolationException ex) {
		return new ResponseEntity<String>("Error: "+ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	
	
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<?> errorForeignKey(SQLException ex) {
		return new ResponseEntity<String>("Error: "+ex.getMessage(), HttpStatus.NOT_FOUND);
	}
}
