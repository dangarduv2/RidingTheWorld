package com.catalogo.DAO;

import org.springframework.data.repository.CrudRepository;

import com.catalogo.domain.Actor;
import com.catalogo.domain.Category;

public interface CategoryDAO extends CrudRepository<Category,Integer>{

}
