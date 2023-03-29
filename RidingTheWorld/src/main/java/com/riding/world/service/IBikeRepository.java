package com.riding.world.service;

import java.util.List;

import com.riding.world.domain.Bike;



public interface IBikeRepository extends GenericInterface<Bike, Integer> {
	
	public List<Bike> findByccGreaterThan(int id);
	
	
}
