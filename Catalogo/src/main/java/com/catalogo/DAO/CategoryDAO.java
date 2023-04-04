package com.catalogo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.catalogo.domain.Category;

@Repository("CategoryDAO")
public interface CategoryDAO extends CrudRepository<Category,Byte>{

}
