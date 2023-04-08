package com.catalogo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.catalogo.domain.Actor;
import com.catalogo.domain.Category;
import com.catalogo.domain.Film;

@Repository("FilmDAO")
public interface FilmDAO extends CrudRepository<Film,Integer>, PagingAndSortingRepository<Film,Integer>{

}
