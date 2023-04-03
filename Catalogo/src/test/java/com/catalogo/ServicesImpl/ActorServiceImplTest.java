package com.catalogo.ServicesImpl;

import static org.junit.jupiter.api.Assertions.*;

import com.catalogo.ServicesImpl.ActorServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;

import com.catalogo.DAO.ActorDAO;
import com.catalogo.IServices.IActorService;

@DataJpaTest
class ActorServiceImplTest {

	
	@MockBean
	ActorDAO ad;
	
	@Autowired(required=true)
	IActorService asss;
	
	@Test
	void getByIdNumero1() {
		
	}

}
