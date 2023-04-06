package com.catalogo.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		return (List<Actor>) ad.findAll();
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
