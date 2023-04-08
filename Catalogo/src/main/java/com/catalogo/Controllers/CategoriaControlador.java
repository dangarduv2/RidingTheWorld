package com.catalogo.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.IServices.IActorService;
import com.catalogo.IServices.ICategoryService;
import com.catalogo.domain.Actor;
import com.catalogo.domain.Category;
import com.catalogo.domain.DTO.ActorDTO;
import com.catalogo.domain.DTO.CategoryDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "catalogo/categoria")
public class CategoriaControlador {
	
	
	@Autowired
	ICategoryService cs;


	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Optional<Integer> id) {

		if (id.isPresent()) {
			Category category = cs.getById(id.get());

			if (category != null) {
				return new ResponseEntity<CategoryDTO>(CategoryDTO.from(category), HttpStatus.OK);
			}

		}
		return new ResponseEntity<String>("La categoria con tal ID no existe", HttpStatus.NOT_FOUND);

	}
	
	
	
	
	
	@GetMapping(path = "/page/{n}")
	public ResponseEntity<?> getAllCategorias(@PathVariable Optional<Integer> n) {
		List<Category> categorias = cs.getByPage(n.get());
		if(categorias.size()<1) {
			return new ResponseEntity<String>("No existe ese número de página", HttpStatus.NOT_FOUND);
		}
		
		List<CategoryDTO> listDTO = new ArrayList<CategoryDTO>();
		for(Category cat: categorias) {
			listDTO.add(CategoryDTO.from(cat));
		}
		return new ResponseEntity<List<CategoryDTO>>(listDTO, HttpStatus.OK);
		
	
	}
	

	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Optional<Integer> id) {
		if (id.isPresent()) {
			if (cs.getById(id.get()) != null) {
				cs.delete(id.get());
				return new ResponseEntity<String>("Categoria con id: " + id.get() + " eliminado", HttpStatus.OK);
			}

		}
		return new ResponseEntity<String>("La categoria con tal ID no existe", HttpStatus.NOT_FOUND);
	}
	
	
	
	
	@PutMapping("/")
	public ResponseEntity<?> update(@Valid CategoryDTO item,BindingResult result){

		if(!result.hasErrors() && (cs.getById(item.getCategoryId()) != null )) {
			cs.update(CategoryDTO.from(item));
			return new ResponseEntity<CategoryDTO>(item, HttpStatus.OK);
		}else if(result.hasErrors()) {
			return new ResponseEntity<String>("Los datos intorducidos no son válidos" , HttpStatus.BAD_REQUEST);
		}else {
				return new ResponseEntity<String>("La categoria con id "+item.getCategoryId()+" no existe", HttpStatus.BAD_REQUEST);
		}	
	}

}
