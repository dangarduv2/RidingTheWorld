package com.catalogo.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.catalogo.DAO.LanguageDAO;
import com.catalogo.IServices.ILanguageService;
import com.catalogo.domain.Category;
import com.catalogo.domain.Language;
@Service("LanguageServiceImpl")
public class LanguageServiceImpl implements ILanguageService{

	@Autowired
	LanguageDAO ld;
	
	@Override
	public Language getById(Integer id) {
		return ld.findById(id).orElse(null);
	}

	@Override
	public List<Language> getAll() {
		return (List<Language>) ld.findAll();
	}

	@Override
	public void delete(Integer id) {
		ld.deleteById(id);
		
	}

	@Override
	public Language update(Language language) {
		return ld.save(language);
	}

	@Override
	public List<Language> getByPage(int page) {
		Pageable pageRequest = PageRequest.of(page, 10);
		Page<Language> languages = ld.findAll(pageRequest);
		return languages.getContent();
	}

	@Override
	public Language create(Language target) {
		return ld.save(target);
	}

}
