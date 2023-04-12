package com.catalogo.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FilmCategoryPKTest {
	
	@Test
	void test() {
		FilmCategoryPK fcp1 = new FilmCategoryPK();
		fcp1.setCategoryId((byte)1);
		fcp1.setFilmId(1);
		
		FilmCategoryPK fcp2 = fcp1;
		
		FilmCategoryPK fcp1diff = new FilmCategoryPK();
		fcp1diff.setCategoryId((byte)2);
		fcp1diff.setFilmId(2);
		
		Category cat = new Category();
		
		assertEquals(fcp1.getCategoryId(), (byte)1);
		assertEquals(fcp1.getFilmId(),1);
		
		assertTrue(fcp1.equals(fcp2));
		assertTrue(fcp1.hashCode()==fcp2.hashCode());
		
		assertFalse(fcp1.equals(fcp1diff));
		assertFalse(fcp1.equals(cat));
	}

}
