package com.kaiji.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kaiji.mapper.BaseDao;
import com.kaiji.service.BaseService;

public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

	@Resource
	private BaseDao<T> baseDao;
	
	public T getById(ID id) throws Exception {
		return baseDao.selectByPrimaryKey(id);
	}
	
	public List<T> getByList(T entity) throws Exception {
		return baseDao.select(entity);
	}
	
	public void update(T entity) throws Exception {
		baseDao.updateByPrimaryKeySelective(entity);
	}
	
	public void save(T entity) throws Exception {
		baseDao.insertSelective(entity);
	}

	public List<T> getAll() throws Exception {
		return baseDao.selectAll();
	}

	public Page<T> selectByPage8(Map<String, Object> filterMap, Page<T> page) throws Exception {
		return PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPage(()->baseDao.selectByFilter(filterMap));
	}
	
	public Page<T> selectByPage(Map<String, Object> filterMap, Page<T> page) throws Exception {
		return PageHelper.startPage(page.getPageNum(), page.getPageSize()).doSelectPage(new ISelect() {
			@Override
			public void doSelect() {
				baseDao.selectByFilter(filterMap);
			}
		});
	}
}
