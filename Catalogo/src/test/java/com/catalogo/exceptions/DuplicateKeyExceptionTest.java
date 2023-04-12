package com.catalogo.exceptions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DuplicateKeyExceptionTest {

ProbandoExcepciones probando;
	
	@BeforeEach
	void setUp() {
		probando = new ProbandoExcepciones();
	}
	
	@Test
	void DuplicateKeyException1() {
		assertThrows(DuplicateKeyException.class, ()-> {probando.PruebaDuplicateKeyException(1);});
	}
	
	@Test
	void DuplicateKeyException2() {
		assertThrows(DuplicateKeyException.class, ()-> {probando.PruebaDuplicateKeyException(2);});
	}
	
	@Test
	void DuplicateKeyException3() throws DuplicateKeyException {
		Boolean bandera = false;
		probando.PruebaDuplicateKeyException(3);
		bandera = true;
		assertTrue(bandera);
	}

}
