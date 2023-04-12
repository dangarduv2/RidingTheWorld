package com.catalogo.Controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.catalogo.IServices.ICategoryService;
import com.catalogo.IServices.ILanguageService;
import com.catalogo.domain.Category;
import com.catalogo.domain.Language;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(LanguageControlador.class)
class LanguageControladorTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	ILanguageService ls;
	
	ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

	@Test
	void getCategoryById_Found() throws Exception  {
		Language lan = new Language(1,"English",new Timestamp(System.currentTimeMillis()));
		when(ls.getById(anyInt())).thenReturn(lan);
		
		mvc.perform(get("http://localhost:8081/catalogo/language/1").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.name").value("English"))
			.andExpect(jsonPath("$.languageId").value(1));
		
	}
	
	@Test
	void testGetUsuarioById_Not_Found() throws Exception  {
		when(ls.getById(anyInt())).thenReturn(null);
		
		mvc.perform(get("http://localhost:8081/catalogo/language/1").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
		
	}

	@Test
	void testGetAllUsuariosByPage_Found() throws Exception {
		Language lan1 = new Language(1,"English",new Timestamp(System.currentTimeMillis()));
		Language lan2 = new Language(2,"Spanish",new Timestamp(System.currentTimeMillis()));
		Language lan3 = new Language(3,"Urdu",new Timestamp(System.currentTimeMillis()));
		Language lan4 = new Language(4,"Pale",new Timestamp(System.currentTimeMillis()));
		List<Language> listaLanguages= new ArrayList<Language>();
		listaLanguages.add(lan1);
		listaLanguages.add(lan2);
		listaLanguages.add(lan3);
		listaLanguages.add(lan4);
		
		when(ls.getByPage(anyInt())).thenReturn(listaLanguages);
		
		mvc.perform(get("http://localhost:8081/catalogo/language/page/0").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].name").value("English"))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
	}
	
	@Test
	void testGetAllUsuariosByPage_Not_Found() throws Exception {
		when(ls.getByPage(anyInt())).thenReturn(new ArrayList<Language>());
		
		mvc.perform(get("http://localhost:8081/catalogo/language/page/0").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());
		
	}

	@Test
	void testDelete_Found() throws Exception {
		Language lan1 = new Language(1,"English",new Timestamp(System.currentTimeMillis()));
		when(ls.getById(anyInt())).thenReturn(lan1);
		
		mvc.perform(delete("http://localhost:8081/catalogo/language/1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").value("Lengua con id: 1 eliminado"));
		
	}
	
	@Test
	void testDelete_Not_Found() throws Exception {
		when(ls.getById(anyInt())).thenReturn(null);
		
		mvc.perform(delete("http://localhost:8081/catalogo/language/1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound())
		.andExpect(jsonPath("$").value("La lengua con tal ID no existe"));
		
	}

	
	
	@Test
	void testUpdate_Found() throws Exception {
		mvc.perform(put("http://localhost:8081/catalogo/language/").contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$").value("La lengua con id null no existe"))
		.andExpect(status().isBadRequest());
		
	}

}
