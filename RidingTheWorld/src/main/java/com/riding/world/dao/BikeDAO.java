package com.riding.world.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.riding.world.domain.Bike;



public interface BikeDAO extends CrudRepository<Bike,Integer>{

	public List<Bike> findByccGreaterThan(int n);
}
