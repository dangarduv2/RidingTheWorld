package com.catalogo.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.catalogo.DAO.CategoryDAO;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CategoryTest {

	@Autowired
	CategoryDAO cd;
	
	@Test
	void testConstructorVacio() {
		Category ca = new Category();
		assertTrue(ca.getLastUpdate()==null);
	}
	
	@Test
	void testConstructorCompletoConGets() {
		Category ca = new Category(1,"Adultos",new Timestamp(System.currentTimeMillis()));
		assertEquals(ca.getCategoryId(), 1, "Assert id");
		assertEquals(ca.getName(), "Adultos", "Assert name");
		assertNotNull(ca.getLastUpdate());
	}
	
	@Test
	void testConstructorCompletoConSetters() {
		Category ca  = new Category();
		ca.setCategoryId(1);
		ca.setName("Adultos");
		ca.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		ca.setFilmCategories(null);
	
		assertEquals(ca.getCategoryId(), 1, "Assert id");
		assertEquals(ca.getName(), "Adultos", "Assert name");
		assertNotNull(ca.getLastUpdate());
		assertNull(ca.getFilmCategories());	
	}

}
