package com.catalogo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogo.domain.Actor;
import com.catalogo.domain.Category;
import com.catalogo.domain.Film;
import com.catalogo.domain.Language;

@Repository
public interface LanguageDAO extends CrudRepository<Language,Byte>{

}
