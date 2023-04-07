package com.catalogo.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalogo.DAO.LanguageDAO;
import com.catalogo.IServices.ILanguageService;
import com.catalogo.domain.Language;
@Service("LanguageServiceImpl")
public class LanguageServiceImpl implements ILanguageService{

	@Autowired
	LanguageDAO ld;
	
	@Override
	public Language getById(Byte id) {
		return ld.findById(id).orElse(null);
	}

	@Override
	public List<Language> getAll() {
		return (List<Language>) ld.findAll();
	}

	@Override
	public void delete(Byte id) {
		ld.deleteById(id);
		
	}

	@Override
	public Language update(Language language) {
		return language;
	}

	@Override
	public List<Language> getByPage(int page) {
		// TODO Auto-generated method stub
		return null;
	}

}
