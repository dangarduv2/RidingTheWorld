package com.catalogo.Controllers;

import java.util.List;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.catalogo.IServices.IActorService;

import com.catalogo.domain.Actor;
import com.catalogo.domain.DTO.ActorDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "catalogo/actor")
public class ActorControlador {

	@Autowired
	IActorService as;

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getUsuarioById(@PathVariable Optional<Integer> id) {

		if (id.isPresent()) {
			Actor actor = as.getById(id.get());

			if (actor != null) {
				return new ResponseEntity<ActorDTO>(ActorDTO.from(actor), HttpStatus.OK);
			}

		}
		return new ResponseEntity<String>("El usuario con tal ID no existe", HttpStatus.NOT_FOUND);

	}

	@GetMapping(path = "/page/{n}")
	public ResponseEntity<?> getAllUsuarios(@PathVariable Optional<Integer> n) {
		List<Actor> actores = as.getByPage(n.get());
		if (actores.size() < 1) {
			return new ResponseEntity<String>("No existe ese número de página", HttpStatus.NOT_FOUND);
		}

		List<ActorDTO> listDTO = new ArrayList<ActorDTO>();
		for (Actor act : actores) {
			listDTO.add(ActorDTO.from(act));
		}
		return new ResponseEntity<List<ActorDTO>>(listDTO, HttpStatus.OK);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Optional<Integer> id) {
		if (id.isPresent()) {
			if (as.getById(id.get()) != null) {
				as.delete(id.get());
				return new ResponseEntity<String>("Usuario con id: " + id.get() + " eliminado", HttpStatus.OK);
			}

		}
		return new ResponseEntity<String>("El usuario con tal ID no existe", HttpStatus.NOT_FOUND);
	}

	@PutMapping("/")
	public ResponseEntity<?> update(@Valid ActorDTO item, BindingResult result) {

		if (!result.hasErrors() && (as.getById(item.getActorId()) != null)) {
			as.update(ActorDTO.from(item));
			return new ResponseEntity<ActorDTO>(item, HttpStatus.OK);
		} else if (result.hasErrors()) {
			return new ResponseEntity<String>("Los datos intorducidos no son válidos", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<String>("El usuario con id " + item.getActorId() + " no existe",
					HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<?> create(@Valid ActorDTO item, BindingResult result) {

		if (!result.hasErrors() && (as.getById(item.getActorId()) == null)) {
			as.create(ActorDTO.from(item));
			return new ResponseEntity<String>("Actor creado con exito", HttpStatus.OK);
		} else if (result.hasErrors()) {
			return new ResponseEntity<String>("Los datos intorducidos no son válidos", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<String>("El usuario con id " + item.getActorId() + " ya existe",
					HttpStatus.BAD_REQUEST);
		}
	}
	

}
