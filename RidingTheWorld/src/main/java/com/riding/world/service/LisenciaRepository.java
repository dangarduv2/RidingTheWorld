package com.riding.world.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.riding.world.dao.LisenciaDAO;
import com.riding.world.domain.Lisencia;

@Service
public class LisenciaRepository implements ILisenciaRepository {

	@Autowired
	private LisenciaDAO ld;
	
	@Override
	public Lisencia getById(Integer id) {
		return ld.findById(id).orElse(null);
	}

	@Override
	public List<Lisencia> getAll() {
		return (List<Lisencia>) ld.findAll();
	}

	@Override
	public void delete(Integer id) {
		ld.deleteById(id);
	}

	@Override
	public Lisencia update(Integer id) {
		Lisencia lisencia = new Lisencia();
		lisencia.setId(id);
		return ld.save(lisencia);
	}

	@Override
	public List<Lisencia> findByccGreaterThan(int id) {
		return ld.findByccGreaterThan(id);
	}

	
}
