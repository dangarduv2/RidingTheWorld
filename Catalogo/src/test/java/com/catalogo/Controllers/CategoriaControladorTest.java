package com.catalogo.Controllers;

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
import com.catalogo.domain.Category;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(CategoriaControlador.class)
class CategoriaControladorTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	ICategoryService cs;
	
	ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

	@Test
	void getCategoryById_Found() throws Exception  {
		Category ca = new Category(1,"Adultos",new Timestamp(System.currentTimeMillis()));
		when(cs.getById(anyInt())).thenReturn(ca);
		
		mvc.perform(get("http://localhost:8081/catalogo/categoria/1").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.name").value("Adultos"))
			.andExpect(jsonPath("$.categoryId").value(1));
		
	}
	
	@Test
	void testGetUsuarioById_Not_Found() throws Exception  {
		when(cs.getById(anyInt())).thenReturn(null);
		
		mvc.perform(get("http://localhost:8081/catalogo/categoria/1").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
		
	}

	@Test
	void testGetAllUsuariosByPage_Found() throws Exception {
		Category ca1 = new Category(1,"Adultos",new Timestamp(System.currentTimeMillis()));
		Category ca2 = new Category(2,"Pequenos",new Timestamp(System.currentTimeMillis()));
		Category ca3 = new Category(3,"Tigres",new Timestamp(System.currentTimeMillis()));
		Category ca4 = new Category(4,"Perros",new Timestamp(System.currentTimeMillis()));
		List<Category> listaCategorias = new ArrayList<Category>();
		listaCategorias.add(ca1);
		listaCategorias.add(ca2);
		listaCategorias.add(ca3);
		listaCategorias.add(ca4);
		
		when(cs.getByPage(anyInt())).thenReturn(listaCategorias);
		
		mvc.perform(get("http://localhost:8081/catalogo/categoria/page/0").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].name").value("Adultos"))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
	}
	
	@Test
	void testGetAllUsuariosByPage_Not_Found() throws Exception {
		when(cs.getByPage(anyInt())).thenReturn(new ArrayList<Category>());
		
		mvc.perform(get("http://localhost:8081/catalogo/categoria/page/0").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());
		
	}

	@Test
	void testDelete_Found() throws Exception {
		Category ca1 = new Category(1,"Adultos",new Timestamp(System.currentTimeMillis()));
		when(cs.getById(anyInt())).thenReturn(ca1);
		
		mvc.perform(delete("http://localhost:8081/catalogo/categoria/1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").value("Categoria con id: 1 eliminado"));
		
	}
	
	@Test
	void testDelete_Not_Found() throws Exception {
		when(cs.getById(anyInt())).thenReturn(null);
		
		mvc.perform(delete("http://localhost:8081/catalogo/categoria/1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound())
		.andExpect(jsonPath("$").value("La categoria con tal ID no existe"));
		
	}

	
	
	@Test
	void testUpdate_Found() throws Exception {
		mvc.perform(put("http://localhost:8081/catalogo/categoria/").contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$").value("Los datos intorducidos no son válidos"))
		.andExpect(status().isBadRequest());
		
	}

	
	@Test
	void testCreate() throws Exception {
		mvc.perform(post("http://localhost:8081/catalogo/categoria/").contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$").value("Los datos intorducidos no son válidos"))
		.andExpect(status().isBadRequest());
	}

}
