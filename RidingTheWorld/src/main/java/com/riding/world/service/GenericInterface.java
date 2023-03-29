package com.riding.world.service;

import java.util.List;


public interface GenericInterface<C,K> {

	public C getById(K id);
	public List<C> getAll();
	public void delete(K id);
	public C update(K id);
}
