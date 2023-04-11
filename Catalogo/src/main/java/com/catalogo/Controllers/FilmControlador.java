package com.catalogo.Controllers;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogo.DAO.FilmDAO;
import com.catalogo.IServices.ICategoryService;
import com.catalogo.IServices.IFilmService;
import com.catalogo.IServices.ILanguageService;
import com.catalogo.domain.Category;
import com.catalogo.domain.Film;
import com.catalogo.domain.Language;
import com.catalogo.domain.DTO.CategoryDTO;
import com.catalogo.domain.DTO.FilmDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "catalogo/pelicula")
public class FilmControlador {
	
	
	@Autowired
	IFilmService fs;
	
	@Autowired
	ILanguageService ls;
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getFilmById(@PathVariable Optional<Integer> id) {

		if (id.isPresent()) {
			Film film = fs.getById(id.get());

			if (film != null) {
				return new ResponseEntity<FilmDTO>(FilmDTO.from(film), HttpStatus.OK);
			}

		}
		return new ResponseEntity<String>("La pelicula con tal ID no existe", HttpStatus.NOT_FOUND);

	}
	
	
	
	
	@GetMapping(path = "/page/{n}")
	public ResponseEntity<?> getAllFilms(@PathVariable Optional<Integer> n) {
		List<Film> films = fs.getByPage(n.get());
		if(films.size()<1) {
			return new ResponseEntity<String>("No existe ese número de página", HttpStatus.NOT_FOUND);
		}
		
		List<FilmDTO> listDTO = new ArrayList<FilmDTO>();
		for(Film fm: films) {
			listDTO.add(FilmDTO.from(fm));
		}
		return new ResponseEntity<List<FilmDTO>>(listDTO, HttpStatus.OK);
		
	
	}
	

	
	
	
	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> delete(@PathVariable Optional<Integer> id)throws SQLIntegrityConstraintViolationException{
//		List<FilmActor>
//		Film filmer = null;
//		if (id.isPresent()) {
//			filmer =(fs.getById(id.get()));
//			if (filmer != null) {
//				filmer.setTitle("ss");
//				Language lengeli = ls.getById(7);
//				filmer.setLanguage1(lengeli);
//				filmer.setLanguage2(null);
//				fs.update(filmer);
//				fs.delete(id.get());
//				return new ResponseEntity<String>("Pelicula con id: " + id.get() + " eliminado", HttpStatus.OK);
//			}
//
//		}
//		return new ResponseEntity<String>("La pelicula con tal ID no existe", HttpStatus.NOT_FOUND);
//	}
	
	
	@PutMapping("/")
	public ResponseEntity<?> update(@Valid FilmDTO item,BindingResult result){
		
		if(!result.hasErrors() && (fs.getById(item.getFilmId()) != null )) {
			fs.update(FilmDTO.from(item,ls));
			return new ResponseEntity<FilmDTO>(item, HttpStatus.OK);
		}else if(result.hasErrors()) {
			List<ObjectError> erro = result.getAllErrors();
			for(ObjectError ee: erro) {
				System.out.println(ee.toString());
			}
			return new ResponseEntity<String>("Los datos intorducidos no son válidos" , HttpStatus.BAD_REQUEST);
		}else {
				return new ResponseEntity<String>("La pelicula con id "+item.getFilmId()+" no existe", HttpStatus.BAD_REQUEST);
		}	
	}
	
	
	


}

