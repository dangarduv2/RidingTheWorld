package com.catalogo.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.catalogo.DAO.ActorDAO;
import com.catalogo.DAO.CategoryDAO;
import com.catalogo.IServices.IActorService;
import com.catalogo.IServices.ICategoryService;
import com.catalogo.domain.Actor;
import com.catalogo.domain.Category;
@Service("CategoryServiceImpl")
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	CategoryDAO cd;

	@Override
	public Category getById(Integer id) {
		return cd.findById(id).orElse(null);
	}

	@Override
	public List<Category> getAll() {
		return (List<Category>) cd.findAll();
	}

	@Override
	public void delete(Integer id) {
		cd.deleteById(id);
		
	}

	@Override
	public Category update(Category category) {
		return cd.save(category);
	}

	public List<Category> getByPage(int page) {
		Pageable pageRequest = PageRequest.of(page, 10);
		Page<Category> categorias = cd.findAll(pageRequest);
		return categorias.getContent();
	}

}