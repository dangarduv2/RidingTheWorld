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
	void NotFoundException1() {
		assertThrows(BadRequestException.class, ()-> {probando.PruebaBadRequestException(1);});
	}
	
	@Test
	void NotFoundException2() {
		assertThrows(BadRequestException.class, ()-> {probando.PruebaBadRequestException(2);});
	}

}
