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

class CategoryDAOTest {

	@Mock
	CategoryDAO cd = mock(CategoryDAO.class);

	final List<Category> lista = Lists.newArrayList(new Category((byte)1,"PG-3"),new Category((byte)2,"PG-7"),new Category((byte)3,"PG-12"));

	List<Actor> listaVacia = Lists.newArrayList();
	
	
	@ParameterizedTest
	@ValueSource(ints = {1,2,3})
	void findByIdNumParametrized(int valores) {
		for(Category c:lista) {
			if(c.getCategoryId()==valores) {when(cd.findById(valores)).thenReturn(Optional.of(c));break;}	
		}
		
		Category category = cd.findById(valores).orElseThrow();
		assertEquals(valores,category.getCategoryId());
	}
	
	

	@Test
	void findAll() {
		when(cd.findAll()).thenReturn(lista);
		List<Category> listaCategorias = (List<Category>) cd.findAll();
		assertEquals(3, listaCategorias.size());
	}

}
