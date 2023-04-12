package com.catalogo.domain.DTO;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.catalogo.IServices.ILanguageService;
import com.catalogo.domain.Film;
import com.catalogo.domain.Language;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class FilmDTOTest {

	@Autowired
	ILanguageService service;
	
	@Test
	void test() {
		Language lan1 = new Language(1,"Indu",new Timestamp(System.currentTimeMillis()));
		
		FilmDTO fdto = new FilmDTO(1,"Descripcion",180,"G",2006,10,new BigDecimal("7.9"),
				new BigDecimal("3.2"),"titulo",1,2);
		
		Film filmFromDTO = FilmDTO.from(fdto,service);
		assertTrue(fdto instanceof FilmDTO);
		assertTrue(filmFromDTO instanceof Film);
		
		Film fil = new Film(1,"Descripcion",180,"G",2006,10,new BigDecimal("7.9"),
				new BigDecimal("3.2"),"titulo",lan1,null,new Timestamp(System.currentTimeMillis()));
		FilmDTO fdtoFromCategory =  FilmDTO.from(fil);
		assertTrue(fdtoFromCategory instanceof FilmDTO);
		assertTrue(fil instanceof Film);
		
		FilmDTO filmDTO = new FilmDTO(1,"Descripcion",180,"G",2006,10,new BigDecimal("7.9"),
				new BigDecimal("3.2"),"titulo",1,2);
		assertEquals(filmDTO.getFilmId(), 1);
		assertEquals(filmDTO.getDescription(),"Descripcion");

		
		FilmDTO filmDTO2 = filmDTO;
		assertTrue(filmDTO.equals(filmDTO2));
		assertTrue(filmDTO.hashCode()==filmDTO2.hashCode());
		
		assertFalse(filmDTO.equals(fil));
		assertFalse(filmDTO.equals(null));
		
		assertNotNull(filmDTO.toString()!=null);
	}

}
