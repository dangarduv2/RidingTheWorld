package com.catalogo.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.catalogo.DAO.ActorDAO;
import com.catalogo.IServices.IActorService;
import com.catalogo.domain.DTO.ActorDTO;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ActorTest {

	@Autowired
	ActorDAO ad;
	
	@Test
	void testConstructorVacio() {
		Actor ac = new Actor();
		assertTrue(ac.getFilmActors()==null);
	}
	
	@Test
	void testConstructorCompletoConGets() {
		Actor ac = new Actor(1,"Daniel", "Garcia",new Timestamp(System.currentTimeMillis()));
		assertEquals(ac.getFirstName(), "Daniel", "Assert nombre");
		assertEquals(ac.getLastName(), "Garcia", "Assert Apellido");
		assertNotNull(ac.getLastUpdate());
		assertEquals(ac.getActorId(), 1, "Assert id");
		assertNull(ac.getFilmActors());	
	}
	
	@Test
	void testConstructorCompletoConSetters() {
		Actor ac = new Actor();
		ac.setActorId(1);
		ac.setFirstName("Daniel");
		ac.setLastName("Garcia");
		ac.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		ac.setFilmActors(null);
	
		assertEquals(ac.getFirstName(), "Daniel", "Assert nombre");
		assertEquals(ac.getLastName(), "Garcia", "Assert Apellido");
		assertNotNull(ac.getLastUpdate());
		assertEquals(ac.getActorId(), 1, "Assert id");
		assertNull(ac.getFilmActors());	
	}

}
