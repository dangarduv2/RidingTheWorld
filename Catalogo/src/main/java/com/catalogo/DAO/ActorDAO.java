package com.catalogo.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.catalogo.domain.Actor;
@Repository("ActorDAO")
public interface ActorDAO extends CrudRepository<Actor,Integer>{

}
