package com.catalogo.ServicesImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.catalogo.DAO.ActorDAO;
import com.catalogo.IServices.IActorService;
import com.catalogo.domain.Actor;

@Service("ActorServiceImpl")
public class ActorServiceImpl implements IActorService{

	@Autowired()
	ActorDAO ad;
	
	@Override
	public Actor getById(Integer id) {
		return ad.findById(id).orElse(null);
	}

	@Override
	public List<Actor> getAll() {
		List<Actor> listaa = new ArrayList<Actor>();
		Iterator<Actor> ite =  ad.findAll().iterator();
		while (ite.hasNext()) {
	          listaa.add(ite.next());
	       }
		return listaa;
	}

	public List<Actor> getByPage(int page) {
		Pageable pageRequest = PageRequest.of(page, 10);
		Page<Actor> actores = ad.findAll(pageRequest);
		return actores.getContent();
	}

	@Override
	public void delete(Integer id) {
		ad.deleteById(id);
		
	}

	@Override
	public Actor update(Actor actor) {
		return ad.save(actor);
	}

}
