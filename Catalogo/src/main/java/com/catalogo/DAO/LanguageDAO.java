package com.catalogo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.catalogo.domain.Language;

@Repository("LanguageDAO")
public interface LanguageDAO extends CrudRepository<Language,Integer>, PagingAndSortingRepository<Language,Integer>{

}
