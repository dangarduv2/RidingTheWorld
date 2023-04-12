package com.catalogo.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

class FilmActorTest {

	@Test
	void test() {
		FilmActorPK fap = new FilmActorPK();
		fap.setActorId(1);
		fap.setFilmId(1);
		
		Timestamp tst= new Timestamp(System.currentTimeMillis());
		
		Actor ac = new Actor(1,"Daniel", "Garcia",new Timestamp(System.currentTimeMillis()));
		
		Film film = new Film(1,"Descripcion",180,"G",2006,10,new BigDecimal("7.9"),
				new BigDecimal("3.2"),"titulo",null,null,new Timestamp(System.currentTimeMillis()));
		
		FilmActor fa = new FilmActor();
		fa.setActor(ac);
		fa.setFilm(film);
		fa.setId(fap);
		fa.setLastUpdate(tst);
		
		assertNotNull(fa.getActor());
		assertNotNull(fa.getFilm());
		assertNotNull(fa.getId());
		assertNotNull(fa.getLastUpdate());
	}

}
