package com.riding.world.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.riding.world.dao.MarcaDAO;
import com.riding.world.domain.Marca;

@Service
public class MarcaRepository implements IMarcaRepository {

	@Autowired
	private MarcaDAO md;
	
	@Override
	public Marca getById(Integer id) {
		return md.findById(id).orElse(null);
	}

	@Override
	public List<Marca> getAll() {
		return (List<Marca>) md.findAll();
	}

	@Override
	public void delete(Integer id) {
		md.deleteById(id);
	}

	@Override
	public Marca update(Integer id) {
		Marca marca = new Marca();
		marca.setId(id);
		return md.save(marca);
	}

	
}
