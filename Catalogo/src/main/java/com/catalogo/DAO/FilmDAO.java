package com.catalogo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogo.domain.Actor;
import com.catalogo.domain.Category;
import com.catalogo.domain.Film;

@Repository
public interface FilmDAO extends CrudRepository<Film,Integer>{

}
