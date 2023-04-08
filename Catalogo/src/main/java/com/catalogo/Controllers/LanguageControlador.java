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

import com.catalogo.IServices.ICategoryService;
import com.catalogo.IServices.ILanguageService;
import com.catalogo.domain.Category;
import com.catalogo.domain.Language;
import com.catalogo.domain.DTO.CategoryDTO;
import com.catalogo.domain.DTO.LanguageDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "catalogo/language")
public class LanguageControlador {
	
	
	@Autowired
	ILanguageService ls;


	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getLanguageById(@PathVariable Optional<Integer> id) {

		if (id.isPresent()) {
			Language language = ls.getById(id.get());

			if (language != null) {
				return new ResponseEntity<LanguageDTO>(LanguageDTO.from(language), HttpStatus.OK);
			}

		}
		return new ResponseEntity<String>("La lengua con tal ID no existe", HttpStatus.NOT_FOUND);

	}
	
	
	
	
	
	@GetMapping(path = "/page/{n}")
	public ResponseEntity<?> getAllLanguages(@PathVariable Optional<Integer> n) {
		List<Language> languages = ls.getByPage(n.get());
		if(languages.size()<1) {
			return new ResponseEntity<String>("No existe ese número de página", HttpStatus.NOT_FOUND);
		}
		
		List<LanguageDTO> listDTO = new ArrayList<LanguageDTO>();
		for(Language lan: languages) {
			listDTO.add(LanguageDTO.from(lan));
		}
		return new ResponseEntity<List<LanguageDTO>>(listDTO, HttpStatus.OK);
		
	
	}
	

	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Optional<Integer> id) {
		if (id.isPresent()) {
			if (ls.getById(id.get()) != null) {
				ls.delete(id.get());
				return new ResponseEntity<String>("Lengua con id: " + id.get() + " eliminado", HttpStatus.OK);
			}

		}
		return new ResponseEntity<String>("La lengua con tal ID no existe", HttpStatus.NOT_FOUND);
	}
	
	
	
	
	@PutMapping("/")
	public ResponseEntity<?> update(@Valid LanguageDTO item,BindingResult result){

		if(!result.hasErrors() && (ls.getById(item.getLanguageId()) != null )) {
			ls.update(LanguageDTO.from(item));
			return new ResponseEntity<LanguageDTO>(item, HttpStatus.OK);
		}else if(result.hasErrors()) {
			return new ResponseEntity<String>("Los datos intorducidos no son válidos" , HttpStatus.BAD_REQUEST);
		}else {
				return new ResponseEntity<String>("La lengua con id "+item.getLanguageId()+" no existe", HttpStatus.BAD_REQUEST);
		}	
	}

}
