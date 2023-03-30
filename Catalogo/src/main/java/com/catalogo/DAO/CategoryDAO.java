package com.catalogo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogo.domain.Actor;
import com.catalogo.domain.Category;

@Repository
public interface CategoryDAO extends CrudRepository<Category,Integer>{

}
