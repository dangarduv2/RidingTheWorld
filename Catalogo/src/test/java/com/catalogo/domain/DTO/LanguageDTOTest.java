package com.catalogo.domain.DTO;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

import com.catalogo.domain.Category;
import com.catalogo.domain.Language;

import lombok.Value;

class LanguageDTOTest {

	

			
		@Test
		void test() {
			LanguageDTO ldto = new LanguageDTO(1,"Spanish");
			Language languageFromDTO = LanguageDTO.from(ldto);
			assertTrue(ldto instanceof LanguageDTO);
			assertTrue(languageFromDTO instanceof Language);
			
			Language la = new Language(1,"Spanish",new Timestamp(System.currentTimeMillis()));
			LanguageDTO ldtoFromCategory =  LanguageDTO.from(la);
			assertTrue(ldtoFromCategory instanceof LanguageDTO);
			assertTrue(la instanceof Language);
			
			LanguageDTO languageDTO = new LanguageDTO(1,"Spanish");
			assertEquals(languageDTO.getLanguageId(), 1);
			assertEquals(languageDTO.getName(),"Spanish");

			
			LanguageDTO languageDTO2 = languageDTO;
			assertTrue(languageDTO.equals(languageDTO2));
			assertTrue(languageDTO.hashCode()==languageDTO2.hashCode());
			
			assertFalse(languageDTO.equals(la));
			assertFalse(languageDTO.equals(null));
			
			assertNotNull(languageDTO.toString()!=null);
		}

	
}
