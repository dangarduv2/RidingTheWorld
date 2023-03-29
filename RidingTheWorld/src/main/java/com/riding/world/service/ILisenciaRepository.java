package com.riding.world.service;

import java.util.List;

import com.riding.world.domain.Lisencia;



public interface ILisenciaRepository extends GenericInterface<Lisencia, Integer> {
	
	public List<Lisencia> findByccGreaterThan(int id);
	
	
}
