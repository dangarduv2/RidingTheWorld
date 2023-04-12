package com.catalogo.Controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.ArrayList;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;

import com.catalogo.IServices.IActorService;
import com.catalogo.domain.Actor;
import com.catalogo.domain.DTO.ActorDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ActorControlador.class)
class ActorControladorTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	IActorService as;
	
	ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

	@Test
	void testGetUsuarioById_Found() throws Exception  {
		Actor ac = new Actor(1,"Daniel", "Garcia",new Timestamp(System.currentTimeMillis()));
		when(as.getById(anyInt())).thenReturn(ac);
		
		mvc.perform(get("http://localhost:8081/catalogo/actor/1").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.firstName").value("Daniel"))
			.andExpect(jsonPath("$.actorId").value(1));
		
	}
	
	@Test
	void testGetUsuarioById_Not_Found() throws Exception  {
		when(as.getById(anyInt())).thenReturn(null);
		
		mvc.perform(get("http://localhost:8081/catalogo/actor/1").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound());
		
	}

	@Test
	void testGetAllUsuariosByPage_Found() throws Exception {
		Actor ac1 = new Actor(1,"Daniel", "Garcia",new Timestamp(System.currentTimeMillis()));
		Actor ac2 = new Actor(2,"Victor", "Garcia",new Timestamp(System.currentTimeMillis()));
		Actor ac3 = new Actor(3,"Ana", "Ferreras",new Timestamp(System.currentTimeMillis()));
		Actor ac4 = new Actor(4,"Xavier", "Ferreras",new Timestamp(System.currentTimeMillis()));
		List<Actor> listaActores = new ArrayList<Actor>();
		listaActores.add(ac1);
		listaActores.add(ac2);
		listaActores.add(ac3);
		listaActores.add(ac4);
		
		when(as.getByPage(anyInt())).thenReturn(listaActores);
		
		mvc.perform(get("http://localhost:8081/catalogo/actor/page/0").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].firstName").value("Daniel"))
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
	}
	
	@Test
	void testGetAllUsuariosByPage_Not_Found() throws Exception {
		when(as.getByPage(anyInt())).thenReturn(new ArrayList<Actor>());
		
		mvc.perform(get("http://localhost:8081/catalogo/actor/page/0").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound());
		
	}

	@Test
	void testDelete_Found() throws Exception {
		Actor ac1 = new Actor(1,"Daniel", "Garcia",new Timestamp(System.currentTimeMillis()));
		when(as.getById(anyInt())).thenReturn(ac1);
		
		mvc.perform(delete("http://localhost:8081/catalogo/actor/1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").value("Usuario con id: 1 eliminado"));
		
	}
	
	@Test
	void testDelete_Not_Found() throws Exception {
		when(as.getById(anyInt())).thenReturn(null);
		
		mvc.perform(delete("http://localhost:8081/catalogo/actor/1").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isNotFound())
		.andExpect(jsonPath("$").value("El usuario con tal ID no existe"));
		
	}

	
	
	@Test
	void testUpdate_Found() throws Exception {
		mvc.perform(put("http://localhost:8081/catalogo/actor/").contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$").value("Los datos intorducidos no son válidos"))
		.andExpect(status().isBadRequest());
		
	}

	
	
	
	
	@Test
	void testCreate() throws Exception {
		mvc.perform(post("http://localhost:8081/catalogo/actor/").contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$").value("Los datos intorducidos no son válidos"))
		.andExpect(status().isBadRequest());
	}

}
