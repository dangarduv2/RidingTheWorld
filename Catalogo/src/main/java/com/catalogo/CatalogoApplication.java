package com.catalogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.catalogo.IServices.IActorService;

@SpringBootApplication
public class CatalogoApplication{

	
	
	@Autowired
	IActorService as;
	
	public static void main(String[] args) {
		SpringApplication.run(CatalogoApplication.class, args);
	}

}
