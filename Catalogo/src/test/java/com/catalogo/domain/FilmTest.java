package com.catalogo.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.catalogo.DAO.FilmDAO;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class FilmTest {

	@Autowired
	FilmDAO fd;
	
	@Test
	void testConstructorVacio() {
		Film film = new Film();
		assertTrue(film.getLanguage1()==null);
	}
	
	
	@Test
	void testConstructorCompletoConGets() {
		Film film = new Film(1,"Descripcion",180,"G",2006,10,new BigDecimal("7.9"),
				new BigDecimal("3.2"),"titulo",null,null,new Timestamp(System.currentTimeMillis()));
		
		assertEquals(film.getFilmId(), 1, "Assert id");
		assertEquals(film.getDescription(), "Descripcion", "Assert Descripcion");
		assertEquals(film.getLength(), 180, "Assert length");
		assertEquals(film.getRating(), "G", "Assert Rating");
		assertEquals(film.getReleaseYear(), 2006, "Assert year");
		assertEquals(film.getRentalDuration(), 10, "Assert rental duration");
		assertEquals(film.getRentalRate(), new BigDecimal("7.9"), "Assert rental getRentalRate");
		assertEquals(film.getReplacementCost(), new BigDecimal("3.2"), "Assert rental getReplacementCost");
		assertEquals(film.getTitle(), "titulo", "Assert rental getTitle");
		assertNull(film.getLanguage1());
		assertNull(film.getLanguage2());
		assertNotNull(film.getLastUpdate());
		
	}
	
	@Test
	void testConstructorCompletoConSetters() {
		Film film2 = new Film(1,"Descripcion",180,"G",2006,10,new BigDecimal("7.9"),
				new BigDecimal("3.2"),"titulo",null,null,new Timestamp(System.currentTimeMillis()));
		
		Film film = new Film();
		film.setFilmId(1);
		film.setDescription("Descripcion");
		film.setLength(180);
		film.setRating("G");
		film.setReleaseYear(2006);
		film.setRentalDuration(10);
		film.setRentalRate(new BigDecimal("7.9"));
		film.setReplacementCost(new BigDecimal("3.2"));
		film.setTitle("titulo");
		film.setLanguage1(null);
		film.setLanguage2(null);
		film.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		
		
		assertEquals(film.getFilmId(), 1, "Assert id");
		assertEquals(film.getDescription(), "Descripcion", "Assert Descripcion");
		assertEquals(film.getLength(), 180, "Assert length");
		assertEquals(film.getRating(), "G", "Assert Rating");
		assertEquals(film.getReleaseYear(), 2006, "Assert year");
		assertEquals(film.getRentalDuration(), 10, "Assert rental duration");
		assertEquals(film.getRentalRate(), new BigDecimal("7.9"), "Assert rental getRentalRate");
		assertEquals(film.getReplacementCost(), new BigDecimal("3.2"), "Assert rental getReplacementCost");
		assertEquals(film.getTitle(), "titulo", "Assert rental getTitle");
		assertNull(film.getLanguage1());
		assertNull(film.getLanguage2());
		assertNotNull(film.getLastUpdate());
	}

}
