package com.riding.world.service;

import java.util.List;

import com.riding.world.domain.Bike;



public interface IBikeRepository {
	
	public Bike getBikeById(int id);
	public List<Bike> getAllBikes();
	public void deleteBike(int id);
	public Bike updateBike(int id);
	public List<Bike> findByccGreaterThan(int id);
	
	
}
