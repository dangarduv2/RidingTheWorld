package com.catalogo.DAO;

import org.springframework.data.repository.CrudRepository;

import com.catalogo.domain.Actor;

public interface ActorDAO extends CrudRepository<Actor,Integer>{

}
