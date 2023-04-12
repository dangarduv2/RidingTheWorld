package com.catalogo.ServicesImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.catalogo.IServices.ILanguageService;
import com.catalogo.domain.Language;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class LanguageServiceImplTest {

	@Autowired
	ILanguageService service;
	
	
	@Test
	void testGetById() {
		Language language = service.getById(2);
		assertNotNull(language);
		assertEquals(language.getName(),"Italian");
		assertTrue(language instanceof Language);
	}
	
	@Test
	void testGetAll() {
		List<Language> listaLanguages = service.getAll();

		assertAll(
				()->assertTrue(listaLanguages!=null),
				()->assertTrue(listaLanguages.size()<7),
				()->assertTrue(listaLanguages.get(2).getName().equals("Japanese"))
		);
	}
	
	@Test
	void testGetByPage() {
		List<Language> listaLanguages = service.getByPage(0);

		assertAll(
				()->assertTrue(listaLanguages!=null),
				()->assertTrue(listaLanguages.size()>3),
				()->assertTrue(listaLanguages.get(2).getName().equals("Japanese"))
		);
	}
	
	
	@Test
	void testDelete() {
		Language language = service.getById(5);
		assertTrue(language.getName().equals("French"));

		service.delete(5);
		Language language2 = service.getById(5);
		assertNull(language2);
	}
	
	
	@Test
	void testUpdate() {
		Language language = service.getById(6);
		assertNotNull(language);
		assertTrue(language.getName().equals("German"), "Falla el firstname antes de update");
		
		language.setName("Checoslovako");
		
		service.update(language);
		language = service.getById(6);
		
		assertNotNull(language, "Falla el objeto siendo nulo después de update");
		assertTrue(language.getName().equals("Checoslovako"),"Falla el firstname después de update");
	}

	
	@Test
	void testCreate() {
		Language language = new Language(99,"Vulgaro",new Timestamp(System.currentTimeMillis()));
		assertNotNull(language);
		
		service.create(language);
		language = service.getById(7);
		
		assertNotNull(language, "Falla el objeto siendo nulo después de update");
		assertTrue(language.getName().equals("Vulgaro"),"Falla el firstname después de update");
	}


}