package com.catalogo.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.catalogo.DAO.FilmDAO;
import com.catalogo.IServices.IFilmService;
import com.catalogo.domain.Film;
@Service("FilmServiceImpl")
public class FilmServiceImpl implements IFilmService{

	@Autowired
	FilmDAO fd;
	
	@Override
	public Film getById(Integer id) {
		return fd.findById(id).orElse(null);
	}

	@Override
	public List<Film> getAll() {
		return (List<Film>) fd.findAll();
	}

	@Override
	public void delete(Integer id){
		fd.deleteById(id);
	}

	@Override
	public Film update(Film film) {
		return fd.save(film);
	}

	@Override
	public List<Film> getByPage(int page) {
		Pageable pageRequest = PageRequest.of(page, 10);
		Page<Film> films = fd.findAll(pageRequest);
		return films.getContent();
	}

	@Override
	public Film create(Film target) {
		return fd.save(target);
	}

}
