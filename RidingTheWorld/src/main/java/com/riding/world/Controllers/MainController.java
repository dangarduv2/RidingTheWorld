package com.riding.world.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riding.world.domain.Bike;
import com.riding.world.service.BikeRepository;

@RestController
public class MainController {

	@Autowired
	BikeRepository bdbr;
	
	@GetMapping("/")
	public ResponseEntity<?> mostrar() {
		ListaBike lb = new ListaBike(bdbr.findByccGreaterThan(1));
		return new ResponseEntity<ListaBike>(lb,HttpStatus.OK);
	} 
}

 class ListaBike  {
	  private List<Bike> Lista_De_Motos;

	  public ListaBike() {
		}
	  
	public ListaBike(List<Bike> lista) {
		
		this.Lista_De_Motos = lista;
	}

	public List<Bike> getLista_De_Motos() {
		return Lista_De_Motos;
	}

	public void setLista(List<Bike> lista) {
		this.Lista_De_Motos = lista;
	}
	  
	}