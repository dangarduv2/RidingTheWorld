package com.catalogo.ServicesImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.catalogo.IServices.IActorService;
import com.catalogo.IServices.IFilmService;
import com.catalogo.domain.Actor;
import com.catalogo.domain.Film;
import com.catalogo.domain.Language;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class FilmServiceImplTest {

	@Autowired
	IFilmService service;
	
	
	@Test
	void testGetById() {
		Film film = service.getById(217);
		assertNotNull(film);
		assertEquals(film.getTitle(),"DAZED PUNK");
		assertEquals(film.getReleaseYear(),2006);
		assertTrue(film instanceof Film);
	}
	
	@Test
	void testGetAll() {
		List<Film> listaFilms = service.getAll();

		assertAll(
				()->assertTrue(listaFilms!=null),
				()->assertTrue(listaFilms.size()>900),
				()->assertTrue(listaFilms.get(219).getTitle().equals("DEER VIRGINIAN"))
		);
	}
	
	@Test
	void testGetByPage() {
		List<Film> listaFilms = service.getByPage(5);

		assertAll(
				()->assertTrue(listaFilms!=null),
				()->assertTrue(listaFilms.size()==10),
				()->assertTrue(listaFilms.get(4).getTitle().equals("BARBARELLA STREETCAR"))
		);
	}

	
	@Test
	void testUpdate() {
		Film film = service.getById(250);
		assertNotNull(film);
		assertTrue(film.getTitle().equals("DRAGON SQUAD"), "Falla el firstname antes de update");
		
		film.setTitle("POPEYE");
		
		service.update(film);
		film = service.getById(250);
		System.out.println(film.getLastUpdate());
		
		assertNotNull(film, "Falla el objeto siendo nulo después de update");
		assertTrue(film.getTitle().equals("POPEYE"),"Falla el firstname después de update");
	}

	
	@Test
	void testCreate() {
		Film filmGet = service.getById(399);
	
		Film film = new Film(9999, "Quijote", 141, "PG",
				             2006, 3, new BigDecimal("0.99"), new BigDecimal("17.99"), "Panza", 
				             filmGet.getLanguage1(), filmGet.getLanguage2(), 
				             new Timestamp(System.currentTimeMillis()));
		
	
		assertNotNull(film);
		
		service.create(film);
		film = service.getById(1001);
		
		assertNotNull(film, "Falla el objeto siendo nulo después de update");
		assertTrue(film.getDescription().equals("Quijote"),"Falla el firstname después de update");
		assertTrue(film.getRating().equals("PG"),"Falla el lastname después de update");
	}


}
