package com.catalogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.catalogo.IServices.IActorService;

@SpringBootApplication
public class CatalogoApplication implements CommandLineRunner{

	@Autowired
	IActorService as;
	
	public static void main(String[] args) {
		SpringApplication.run(CatalogoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	 System.out.println("Hoooola");
	 
	 System.out.println(as.getById(3).toString());
		
	}

}
