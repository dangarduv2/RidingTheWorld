package com.catalogo.IServices;

import java.util.List;

public interface GenericServiceInterface<C,K> {

	public C getById(K id);
	public C create(C target);
	public List<C> getAll();
	public List<C> getByPage(int page);
	public void delete(K id);
	public C update(C target);
}
