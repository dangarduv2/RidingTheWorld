package com.catalogo.ServicesImpl;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.catalogo.DAO.CategoryDAO;

import com.catalogo.IServices.ICategoryService;

import com.catalogo.domain.Category;

@SpringBootTest
class CategoryServiceImplTest {
	
	@Autowired
	ICategoryService cs ;
	
	@Autowired
	CategoryDAO cd ;
	
	@ParameterizedTest
	@ValueSource(ints = { 1,2,3 })
	void getById(int valores) {
		
		Category category = cs.getById(valores);
		
		assertNotNull(category);
		
		assertEquals(valores,category.getCategoryId());
	}
	
	
	@Test
	void getAll() {
		
		List<Category> listaActores = cs.getAll();
		
		assertNotNull(listaActores);
		
		assertTrue(listaActores.size() > 10);
	}
	
	
	
	@ParameterizedTest
	@ValueSource(ints = { 4,5,6 })
	void delete(int valores) {
		
		assertNotNull(cs.getById(valores));
		
		cs.delete(valores);
		
		assertNull(cs.getById(valores));
	}
	
	
	
	@ParameterizedTest
	@ValueSource(ints = { 7,8,9,10})
	void update(int valores) {
		
		Category category = cs.getById(valores);
		
		assertNotNull(category);
		
		switch (valores) {
		case 7: category.setName("Nombre Update 1"); break;
		case 8: category.setName("Nombre Update 2"); break;
		case 9: category.setName("Nombre Update 3"); break;
		case 10: category.setName("Nombre Update 4"); break;
		}
		
		cd.save(category);
		
		assertEquals(category.getName(), cs.getById(valores).getName());

	}
	
	
	@ParameterizedTest
	@ValueSource(ints = { 4,5,6})
	void save(int valores) {
		
		Category category= null;
		
		switch (valores) {
		case 4: category= new Category(4,"Classics"); break;
		case 5: category= new Category(5,"Comedy"); break;
		case 6: category= new Category(6,"Documentary"); break;
		}
		
		assertNotNull(category);
		
		cd.save(category);
		
		

	}
	

	

}
