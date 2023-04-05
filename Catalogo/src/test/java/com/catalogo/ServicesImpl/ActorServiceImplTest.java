package com.catalogo.ServicesImpl;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.catalogo.DAO.ActorDAO;
import com.catalogo.IServices.IActorService;
import com.catalogo.domain.Actor;


@SpringBootTest
@Disabled
class ActorServiceImplTest {
	
	@Autowired
	IActorService as ;
	
	@Autowired
	ActorDAO ad ;
	
	@ParameterizedTest
	@ValueSource(ints = { 1,2,3,4,5,6,7,8,9,10 })
	void getById(int valores) {
		
		Actor actor = as.getById(valores);
		
		assertNotNull(actor);
		
		assertEquals(valores,actor.getActorId());
	}
	
	
	@Test
	void getAll() {
		
		List<Actor> listaActores = as.getAll();
		
		assertNotNull(listaActores);
		
		assertTrue(listaActores.size() > 100);
	}
	
	
	@ParameterizedTest
	@ValueSource(ints = { 11,12,13,14,15,16,17,18,19,20 })
	void delete(int valores) {
		
		assertNotNull(as.getById(valores));
		
		as.delete(valores);
		
		assertNull(as.getById(valores));
	}
	
	
	@ParameterizedTest
	@ValueSource(ints = { 21,22,23,24,25})
	void update(int valores) {
		
		Actor actor = as.getById(valores);
		
		assertNotNull(actor);
		
		switch (valores) {
		case 21: actor.setFirstName("Nombre Update 1"); break;
		case 22: actor.setFirstName("Nombre Update 2"); break;
		case 23: actor.setFirstName("Nombre Update 3"); break;
		case 24: actor.setFirstName("Nombre Update 4"); break;
		case 25: actor.setFirstName("Nombre Update 5"); break;
		}
		
		ad.save(actor);
		
		assertEquals(actor.getFirstName(), as.getById(valores).getFirstName());

	}
	
	
	@ParameterizedTest
	@ValueSource(ints = { 21,22,23,24,25})
	void save(int valores) {
		
		Actor actor=null;
		
		switch (valores) {
		case 21: actor= new Actor(21, "KIRSTEN", "PALTROW"); break;
		case 22: actor= new Actor(22, "ELVIS", "MARX"); break;
		case 23: actor= new Actor(23, "SANDRA", "KILMER"); break;
		case 24: actor= new Actor(24, "CAMERON", "STREEP"); break;
		case 25: actor= new Actor(25, "KEVIN", "BLOOM"); break;
		}
		
		assertNotNull(actor);
		
		ad.save(actor);
		
		assertEquals(actor.getFirstName(), as.getById(valores).getFirstName());

	}
	

	

}
