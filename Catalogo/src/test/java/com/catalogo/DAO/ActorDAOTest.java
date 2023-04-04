package com.catalogo.DAO;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.catalogo.domain.*;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

class ActorDAOTest {
	@Mock
	ActorDAO ad = mock(ActorDAO.class);
	
	final List<Actor> lista= Lists.newArrayList(
			new Actor(22,"Daniel", "Garcia"),
			new Actor(24,"Victor", "Garcia"),
			new Actor(15,"Ana", "Ferreras"),
			new Actor(19,"Alejandro", "Cotas")
			);
	
	@Test
	void findByIdNum5() {
		when(ad.findById(5)).thenReturn(Optional.of(new Actor(5,"Daniel", "Garcia")));
		Actor actor = ad.findById(5).orElseThrow();
		assertEquals(5,actor.getActorId());
	}
	
	@Test
	void findByIdNumInexistente() {
		Actor actor = ad.findById(10).orElse(null);
		assertNull(actor);
	}
	
	
	

}
