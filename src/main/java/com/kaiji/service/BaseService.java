package com.kaiji.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, ID extends Serializable> {

	T getById(ID id) throws Exception;

	List<T> getByList(T entity) throws Exception;

	void update(T entity) throws Exception;

	void save(T entity) throws Exception;
}
