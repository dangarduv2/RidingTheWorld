package com.catalogo.DAO;

import org.springframework.data.repository.CrudRepository;

import com.catalogo.domain.Actor;
import com.catalogo.domain.Category;
import com.catalogo.domain.Film;

public interface FilmDAO extends CrudRepository<Film,Integer>{

}
