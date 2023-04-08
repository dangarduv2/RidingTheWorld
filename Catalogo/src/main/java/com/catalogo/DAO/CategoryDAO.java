package com.catalogo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.catalogo.domain.Category;

@Repository("CategoryDAO")
public interface CategoryDAO extends CrudRepository<Category,Integer>, PagingAndSortingRepository<Category,Integer>{

}
