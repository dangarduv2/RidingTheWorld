package com.catalogo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FilmActorPKTest {

	@Test
	void test() {
		FilmActorPK fap1 = new FilmActorPK();
		fap1.setActorId(1);
		fap1.setFilmId(1);
		
		FilmActorPK fap2 = fap1;
		
		FilmActorPK fapdiff = new FilmActorPK();
		fapdiff.setActorId(2);
		fapdiff.setFilmId(2);
		
		Actor ac = new Actor();
		
		assertEquals(fap1.getActorId(),1);
		assertEquals(fap1.getFilmId(),1);
		
		assertTrue(fap1.equals(fap2));
		assertTrue(fap1.hashCode()==fap2.hashCode());
		
		assertFalse(fap1.equals(fapdiff));
		assertFalse(fap1.equals(ac));
	
	}
}
