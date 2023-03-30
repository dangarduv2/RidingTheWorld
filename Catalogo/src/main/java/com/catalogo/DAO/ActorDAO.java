package com.catalogo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogo.domain.Actor;

@Repository
public interface ActorDAO extends CrudRepository<Actor,Integer>{

}
