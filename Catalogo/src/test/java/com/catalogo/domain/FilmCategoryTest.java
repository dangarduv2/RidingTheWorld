package com.catalogo.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

class FilmCategoryTest {

	@Test
	void test() {
		Category ca = new Category(1,"Adultos",new Timestamp(System.currentTimeMillis()));
		
		FilmCategoryPK fcp = new FilmCategoryPK();
		fcp.setCategoryId((byte)1);
		fcp.setFilmId(1);
		
		Timestamp tst= new Timestamp(System.currentTimeMillis());
		
		Film film = new Film(1,"Descripcion",180,"G",2006,10,new BigDecimal("7.9"),
				new BigDecimal("3.2"),"titulo",null,null,new Timestamp(System.currentTimeMillis()));
		
		FilmCategory fc = new FilmCategory();
		fc.setCategory(ca);
		fc.setFilm(film);
		fc.setId(fcp);
		fc.setLastUpdate(tst);
		
		assertNotNull(fc.getCategory());
		assertNotNull(fc.getFilm());
		assertNotNull(fc.getId());
		assertNotNull(fc.getLastUpdate());
	}

}
