package com.catalogo.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotFoundExceptionTest {
	ProbandoExcepciones probando;
	
	@BeforeEach
	void setUp() {
		probando = new ProbandoExcepciones();
	}
	
	@Test
	void NotFoundException1() {
		assertThrows(NotFoundException.class, ()-> {probando.PruebaNotFoundException(1);});
	}
	
	@Test
	void NotFoundException2() {
		assertThrows(NotFoundException.class, ()-> {probando.PruebaNotFoundException(2);});
	}
	
	@Test
	void NotFoundException3() throws NotFoundException {
		Boolean bandera = false;
		probando.PruebaNotFoundException(3);
		bandera = true;
		assertTrue(bandera);
	}

}
