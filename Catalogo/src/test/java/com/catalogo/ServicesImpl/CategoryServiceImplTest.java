package com.catalogo.ServicesImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.catalogo.IServices.ICategoryService;
import com.catalogo.IServices.ILanguageService;
import com.catalogo.domain.Category;
import com.catalogo.domain.Language;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CategoryServiceImplTest {

	@Autowired
	ICategoryService service;
	

	@Test
	void testGetById() {
		Category category = service.getById(10);
		assertNotNull(category);
		assertEquals(category.getName(),"Games");
		assertTrue(category instanceof Category);
	}
	
	@Test
	void testGetAll() {
		List<Category> listaCategorias = service.getAll();

		assertAll(
				()->assertTrue(listaCategorias!=null),
				()->assertTrue(listaCategorias.size()>12),
				()->assertTrue(listaCategorias.get(10).getName().equals("Horror"))
		);
	}
	
	@Test
	void testGetByPage() {
		List<Category> listaCategorias = service.getByPage(0);

		assertAll(
				()->assertTrue(listaCategorias!=null),
				()->assertTrue(listaCategorias.size()==10),
				()->assertTrue(listaCategorias.get(1).getName().equals("Animation"))
		);
	}
	
	
	@Test
	void testDelete() {
		Category category = service.getById(13);
		assertTrue(category.getName().equals("New"));

		service.delete(13);
		Category category2 = service.getById(13);
		assertNull(category2);
	}
	
	
	@Test
	void testUpdate() {
		Category category = service.getById(15);
		assertNotNull(category);
		assertTrue(category.getName().equals("Sports"), "Falla el firstname antes de update");
		
		category.setName("NintendoSports");
		
		service.update(category);
		category = service.getById(15);
		
		assertNotNull(category, "Falla el objeto siendo nulo después de update");
		assertTrue(category.getName().equals("NintendoSports"),"Falla el firstname después de update");
	}

	
	@Test
	void testCreate() {
		Category category = new Category(99,"Play5",new Timestamp(System.currentTimeMillis()));
		assertNotNull(category);
		
		service.create(category);
		category = service.getById(17);
		
		assertNotNull(category, "Falla el objeto siendo nulo después de update");
		assertTrue(category.getName().equals("Play5"),"Falla el firstname después de update");
	}


}