package com.catalogo.DAO;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.catalogo.domain.*;

class ActorDAOTest {
	@Mock
	ActorDAO ad = mock(ActorDAO.class);
	
	@Test
	void test() {
		if(ad==null)System.out.println("sssssssssssssssssssssssssssssss");
		when(ad.findById(5)).thenReturn(Optional.of(new Actor(5,"Daniel", "Garcia")));
		Actor actor = ad.findById(5).orElseThrow();
		assertEquals(5,actor.getActorId());
	}

}
