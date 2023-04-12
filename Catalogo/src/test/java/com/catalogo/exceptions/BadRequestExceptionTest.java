package com.catalogo.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BadRequestExceptionTest {

ProbandoExcepciones probando;
	
	@BeforeEach
	void setUp() {
		probando = new ProbandoExcepciones();
	}
	
	@Test
	void BadRequestException1() {
		assertThrows(BadRequestException.class, ()-> {probando.PruebaBadRequestException(1);});
	}
	
	@Test
	void BadRequestException2() {
		assertThrows(BadRequestException.class, ()-> {probando.PruebaBadRequestException(2);});
	}
	
	@Test
	void BadRequestException3() throws BadRequestException {
		Boolean bandera = false;
		probando.PruebaBadRequestException(3);
		bandera = true;
		assertTrue(bandera);
		
	}

}
