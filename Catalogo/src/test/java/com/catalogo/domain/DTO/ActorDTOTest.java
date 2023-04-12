package com.catalogo.domain.DTO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

import com.catalogo.domain.Actor;

class ActorDTOTest {

	@Test
	void test() {
		ActorDTO adto = new ActorDTO(1,"Daniel","Garcia");
		Actor actorFromDTO = ActorDTO.from(adto);
		assertTrue(adto instanceof ActorDTO);
		assertTrue(actorFromDTO instanceof Actor);
		
		Actor ac = new Actor(1,"Daniel", "Garcia",new Timestamp(System.currentTimeMillis()));
		ActorDTO adtoFromActor =  ActorDTO.from(ac);
		assertTrue(adtoFromActor instanceof ActorDTO);
		assertTrue(ac instanceof Actor);
		
		ActorDTO actorDTO = new ActorDTO(1,"Daniel","Garcia");
		assertEquals(actorDTO.getActorId(), 1);
		assertEquals(actorDTO.getFirstName(),"Daniel");
		assertEquals(actorDTO.getLastName(),"Garcia");
		
		ActorDTO actorDTO2 = actorDTO;
		assertTrue(actorDTO.equals(actorDTO2));
		assertTrue(actorDTO.hashCode()==actorDTO2.hashCode());
		
		assertFalse(actorDTO.equals(ac));
		assertFalse(actorDTO.equals(null));
		
		assertNotNull(actorDTO.toString()!=null);
	}

}
