package com.catalogo.ServicesImpl;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<?> errorForeignKey(SQLIntegrityConstraintViolationException ex) {
		return new ResponseEntity<String>("Error al eliminar el Objeto, tiene RESTRICT", HttpStatus.NOT_FOUND);
	}

}
