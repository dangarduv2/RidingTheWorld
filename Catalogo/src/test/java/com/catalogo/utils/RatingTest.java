package com.catalogo.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RatingTest {

	ValidadorRating vr = new ValidadorRating();
	
	@Test
	void test() {
		assertTrue(vr.isValid("G", null));
		assertFalse(vr.isValid("GPP", null));
	}

}
