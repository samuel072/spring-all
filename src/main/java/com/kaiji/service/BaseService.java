package com.kaiji.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.Page;

public interface BaseService<T, ID extends Serializable> {

	T getById(ID id) throws Exception;

	List<T> getByList(T entity) throws Exception;

	void update(T entity) throws Exception;

	void save(T entity) throws Exception;
	
	List<T> getAll() throws Exception;
	
	/**
	 * 根据条件查询列表
	 * 
	 * @param filterMap
	 * 		条件
	 * @return
	 * 		T列表
	 * @throws Exception
	 * 		异常信息
	 */
	List<T> findByFilter(Map<String, Object> filterMap) throws Exception;
	
	/**
	 * 分页查询， jdk1.8以上
	 * 
	 * @param filterMap
	 * 		条件
	 * @param page
	 * 		page对象
	 * @return
	 * 		page<T>
	 * @throws Exception
	 * 		抛出异常
	 */
	Page<T> selectByPage8(Map<String, Object> filterMap, Page<T> page) throws Exception;
	
	/**
	 * 分页查询， jdk1.7以上
	 * 
	 * @param filterMap
	 * 		条件
	 * @param page
	 * 		page对象
	 * @return
	 * 		page<T>
	 * @throws Exception
	 * 		抛出异常
	 */
	Page<T> selectByPage(Map<String, Object> filterMap, Page<T> page) throws Exception;
}
