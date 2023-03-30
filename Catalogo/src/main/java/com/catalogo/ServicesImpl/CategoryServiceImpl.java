package com.catalogo.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogo.DAO.ActorDAO;
import com.catalogo.DAO.CategoryDAO;
import com.catalogo.IServices.IActorService;
import com.catalogo.IServices.ICategoryService;
import com.catalogo.domain.Actor;
import com.catalogo.domain.Category;
@Service
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	CategoryDAO cd;

	@Override
	public Category getById(Byte id) {
		return cd.findById(id).orElse(null);
	}

	@Override
	public List<Category> getAll() {
		return (List<Category>) cd.findAll();
	}

	@Override
	public void delete(Byte id) {
		cd.deleteById(id);
		
	}

	@Override
	public Category update(Byte id) {
		Category category = this.getById(id);
		return category;
	}

}