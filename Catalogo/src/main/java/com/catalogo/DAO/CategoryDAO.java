package com.catalogo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.catalogo.domain.Category;

@Component
public interface CategoryDAO extends CrudRepository<Category,Byte>{

}
