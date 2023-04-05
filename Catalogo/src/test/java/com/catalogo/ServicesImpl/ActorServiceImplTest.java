package com.catalogo.ServicesImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import com.catalogo.IServices.IActorService;
import com.catalogo.domain.Actor;

class ActorServiceImplTest {

	@Mock
	IActorService ad = mock(ActorServiceImpl.class);

	final List<Actor> lista = Lists.newArrayList(new Actor(22, "Daniel", "Garcia"), new Actor(24, "Victor", "Garcia"),
			new Actor(15, "Ana", "Ferreras"), new Actor(19, "Alejandro", "Cotas"));

	List<Actor> listaVacia = Lists.newArrayList();

	@ParameterizedTest
	@ValueSource(ints = { 22, 24, 15, 19 })
	void getByIdNumParametrized(int valores) {
		Actor actor = null;
		for (Actor a : lista) {
			if (a.getActorId() == valores) {
				when(ad.getById(valores)).thenReturn(a);
				actor = ad.getById(valores);
				break;
			}
		}

		assertNotNull(actor);
		assertEquals(valores, actor.getActorId());
	}

	@Test
	void testGetAll() {
		when(ad.getAll()).thenReturn(lista);
		List<Actor> listaActores=ad.getAll();
		
		assertNotNull(listaActores);
		assertEquals(4,listaActores.size());
	}

	@ParameterizedTest
	@ValueSource(ints = { 22, 24, 15, 19 })
	void testUpdate(int valores) {
		List<Actor> listaDeActores=lista;
		Actor actor = null;
		for (Actor a : lista) {
			if (a.getActorId() == valores) {
				when(ad.update(valores)).thenReturn(a);
				actor = ad.update(valores);
				break;
			}
		}

		assertNotNull(actor);
		assertEquals(valores, actor.getActorId());
	}

}
