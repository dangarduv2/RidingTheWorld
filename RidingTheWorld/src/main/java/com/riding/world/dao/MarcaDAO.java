package com.riding.world.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.riding.world.domain.Marca;



public interface MarcaDAO extends CrudRepository<Marca,Integer>{}
