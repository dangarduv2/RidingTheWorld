package com.catalogo.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogo.DAO.FilmDAO;
import com.catalogo.IServices.IFilmService;
import com.catalogo.domain.Actor;
import com.catalogo.domain.Category;
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
	public void delete(Integer id) {
		fd.deleteById(id);
	}

	@Override
	public Film update(Integer id) {
		Film film = this.getById(id);
		return film;
	}

}
