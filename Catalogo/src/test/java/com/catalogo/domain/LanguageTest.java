package com.catalogo.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.catalogo.DAO.LanguageDAO;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class LanguageTest {

	@Autowired
	LanguageDAO ld;
	
	@Test
	void testConstructorVacio() {
		Language lan = new Language();
		assertTrue(lan.getFilms1()==null);
	}
	
	@Test
	void testConstructorCompletoConGets() {
		Language lan = new Language(1,"Indu",new Timestamp(System.currentTimeMillis()));

		assertEquals(lan.getLanguageId(), 1, "Assert id");
		assertEquals(lan.getName(), "Indu", "Assert Nombre");
		assertNotNull(lan.getLastUpdate(),"Assert Update");
		assertNull(lan.getFilms1());	
		assertNull(lan.getFilms2());
	}
	
	@Test
	void testConstructorCompletoConSetters() {
		Language lan = new Language();
		lan.setLanguageId(1);
		lan.setName("Indu");
		lan.setFilms1(null);
		lan.setFilms2(null);
		lan.setLastUpdate(new Timestamp(System.currentTimeMillis()));
	
		assertEquals(lan.getLanguageId(), 1, "Assert id");
		assertEquals(lan.getName(), "Indu", "Assert Nombre");
		assertNotNull(lan.getLastUpdate(),"Assert Update");
		assertNull(lan.getFilms1());	
		assertNull(lan.getFilms2());
	}
}
