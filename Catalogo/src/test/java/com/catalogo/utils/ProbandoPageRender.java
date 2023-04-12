package com.catalogo.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.catalogo.DAO.ActorDAO;
import com.catalogo.DAO.CategoryDAO;
import com.catalogo.IServices.IActorService;
import com.catalogo.domain.Actor;
import com.catalogo.domain.Category;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ProbandoPageRender {

	@Autowired()
	CategoryDAO cd;
	
	@Autowired()
	ActorDAO ad;
	
	
	
	
	@Test
	void test() {
		Pageable pageRequest = PageRequest.of(0, 10);
		Page<Category> categorias = cd.findAll(pageRequest);
		PageRender<Category> pr = new PageRender<Category>("/catalogo/category/page/0",categorias);
		
		assertEquals(pr.getUrl(), "/catalogo/category/page/0", "Assert Url");
		assertEquals(pr.getTotalPaginas(), 2, "Assert TotalPaginas");
		assertEquals(pr.getPaginaActual(), 1, "Assert PaginaActual");
		assertEquals(pr.getPaginas().size(), 2, "Assert getPaginas");
		assertTrue(pr.isFirst(), "Assert isFirst");
		assertFalse(pr.isLast(), "Assert isLast");
		assertTrue(pr.isHasNext(), "Assert isHasNext");
		assertFalse(pr.isHasPrevious(), "Assert isHasPrevious");
	}
}
