package com.catalogo.domain.DTO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import com.catalogo.domain.Category;

import lombok.Value;

@Value
class CategoryDTOTest {
		
	@Test
	void test() {
		CategoryDTO cdto = new CategoryDTO(1,"Adultos");
		Category categoryFromDTO = CategoryDTO.from(cdto);
		assertTrue(cdto instanceof CategoryDTO);
		assertTrue(categoryFromDTO instanceof Category);
		
		Category ca = new Category(1,"Adultos",new Timestamp(System.currentTimeMillis()));
		CategoryDTO cdtoFromCategory =  CategoryDTO.from(ca);
		assertTrue(cdtoFromCategory instanceof CategoryDTO);
		assertTrue(ca instanceof Category);
		
		CategoryDTO categoryDTO = new CategoryDTO(1,"Adultos");
		assertEquals(categoryDTO.getCategoryId(), 1);
		assertEquals(categoryDTO.getName(),"Adultos");

		
		CategoryDTO categoryDTO2 = categoryDTO;
		assertTrue(categoryDTO.equals(categoryDTO2));
		assertTrue(categoryDTO.hashCode()==categoryDTO2.hashCode());
		
		assertFalse(categoryDTO.equals(ca));
		assertFalse(categoryDTO.equals(null));
		
		assertNotNull(categoryDTO.toString()!=null);
	}

}
