package com.catalogo.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InvalidDataExceptionTest {
	
	ProbandoExcepciones probando;
	
	@BeforeEach
	void setUp() {
		probando = new ProbandoExcepciones();
	}
	
	@Test
	void PruebaInvalidDataException1() {
		assertThrows(InvalidDataException.class, ()-> {probando.PruebaInvalidDataException(1);});
	}
	
	@Test
	void PruebaInvalidDataException2() {
		assertThrows(InvalidDataException.class, ()-> {probando.PruebaInvalidDataException(2);});
	}
	
	@Test
	void PruebaInvalidDataException3() throws InvalidDataException {
		Boolean bandera = false;
		probando.PruebaInvalidDataException(3);
		 bandera = true;
		 assertTrue(bandera);
	}

}