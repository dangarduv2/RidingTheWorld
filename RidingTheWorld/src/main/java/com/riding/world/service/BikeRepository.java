package com.riding.world.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riding.world.dao.BikeDAO;
import com.riding.world.domain.Bike;
import com.riding.world.service.IBikeRepository;

@Service
public class BikeRepository implements IBikeRepository {

	@Autowired
	private BikeDAO bd;
	
	@Override
	public Bike getBikeById(int id) {
		return bd.findById(id).orElse(null);
	}

	@Override
	public List<Bike> getAllBikes() {
		return (List<Bike>) bd.findAll();
	}

	@Override
	public void deleteBike(int id) {
		bd.deleteById(id);
	}

	@Override
	public Bike updateBike(int id) {
		Bike bike = new Bike();
		bike.setId(id);
		return bd.save(bike);
	}

	@Override
	public List<Bike> findByccGreaterThan(int id) {
		return bd.findByccGreaterThan(id);
	}

	
}
