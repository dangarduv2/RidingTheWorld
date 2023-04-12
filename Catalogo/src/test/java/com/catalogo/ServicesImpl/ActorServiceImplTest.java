package com.catalogo.ServicesImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.catalogo.IServices.IActorService;
import com.catalogo.domain.Actor;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ActorServiceImplTest {

	@Autowired
	IActorService service;
	
	
	@Test
	void testGetById() {
		Actor actor = service.getById(2);
		assertNotNull(actor);
		assertEquals(actor.getFirstName(),"NICK");
		assertEquals(actor.getLastName(),"WAHLBERG");
		assertTrue(actor instanceof Actor);
	}
	
	@Test
	void testGetAll() {
		List<Actor> listaActores = service.getAll();

		assertAll(
				()->assertTrue(listaActores!=null),
				()->assertTrue(listaActores.size()>100),
				()->assertTrue(listaActores.get(19).getFirstName().equals("LUCILLE"))
		);
	}
	
	@Test
	void testGetByPage() {
		List<Actor> listaActores = service.getByPage(0);

		assertAll(
				()->assertTrue(listaActores!=null),
				()->assertTrue(listaActores.size()==10),
				()->assertTrue(listaActores.get(0).getFirstName().equals("PENELOPE"))
		);
	}
	
	
	@Test
	void testDelete() {
		Actor actor = service.getById(199);
		assertTrue(actor.getFirstName().equals("JULIA"));

		service.delete(199);
		Actor actor2 = service.getById(199);
		assertNull(actor2);
	}
	
	
	@Test
	void testUpdate() {
		Actor actor = service.getById(150);
		assertNotNull(actor);
		assertTrue(actor.getFirstName().equals("JAYNE"), "Falla el firstname antes de update");
		
		actor.setFirstName("Daniel");
		actor.setLastName("Garcia");
		
		service.update(actor);
		actor = service.getById(150);
		
		assertNotNull(actor, "Falla el objeto siendo nulo después de update");
		assertTrue(actor.getFirstName().equals("Daniel"),"Falla el firstname después de update");
		assertTrue(actor.getLastName().equals("Garcia"),"Falla el lastname después de update");
	}

	
	@Test
	void testCreate() {
		Actor actor = new Actor(999,"Jose","Reche", new Timestamp(System.currentTimeMillis()));
		assertNotNull(actor);
		
		service.create(actor);
		actor = service.getById(201);
		
		assertNotNull(actor, "Falla el objeto siendo nulo después de update");
		assertTrue(actor.getFirstName().equals("Jose"),"Falla el firstname después de update");
		assertTrue(actor.getLastName().equals("Reche"),"Falla el lastname después de update");
	}


}
