package com.catalogo.IServices;

import java.util.List;

public interface GenericServiceInterface<C,K> {

	public C getById(K id);
	public List<C> getAll();
	public void delete(K id);
	public C update(C target);
}
