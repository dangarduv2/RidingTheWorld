package com.catalogo.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.IServices.IActorService;
import com.catalogo.domain.Actor;
import com.catalogo.domain.DTO.ActorDTO;

@RestController
public class MainController {

	@Autowired
	IActorService as;
	
	@GetMapping("/p")
	public String index() {
		as.delete(1);
		return "ss";
	}
}
