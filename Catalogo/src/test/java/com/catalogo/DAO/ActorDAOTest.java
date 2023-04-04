package com.catalogo.DAO;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import com.catalogo.domain.*;

class ActorDAOTest {
	@Mock
	ActorDAO ad = mock(ActorDAO.class);

	final List<Actor> lista = Lists.newArrayList(new Actor(22, "Daniel", "Garcia"), new Actor(24, "Victor", "Garcia"),
			new Actor(15, "Ana", "Ferreras"), new Actor(19, "Alejandro", "Cotas"));

	
	@ParameterizedTest
	@ValueSource(ints = {22,24,15,19})
	void findByIdNumParametrized(int valores) {
		for(Actor a:lista) {
			if(a.getActorId()==valores) {when(ad.findById(valores)).thenReturn(Optional.of(a));	break;}	
		}
		
		Actor actor = ad.findById(valores).orElseThrow();
		assertEquals(valores,actor.getActorId());
	}
	
	

	@Test
	void findAll() {
		when(ad.findAll()).thenReturn(lista);
		List<Actor> listaActores = (List<Actor>) ad.findAll();
		assertEquals(4, listaActores.size());
	}
	
	@ParameterizedTest
	@ValueSource(ints = {22,24,15,19})
	void deleteParametrized(int valores) {
		for(Actor a:lista) {
			if(a.getActorId()==valores) {when(ad.de(valores)).thenReturn(Optional.of(a));	break;}	
		}
		
		Actor actor = ad.findById(valores).orElseThrow();
		assertEquals(valores,actor.getActorId());
	}
	
	
	
	
	

}
