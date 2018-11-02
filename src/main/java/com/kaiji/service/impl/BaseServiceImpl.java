package com.kaiji.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.kaiji.service.BaseService;

import tk.mybatis.mapper.common.BaseMapper;

public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

	@Resource
	private BaseMapper<T> baseMapper;
	
	public T getById(ID id) throws Exception {
		return baseMapper.selectByPrimaryKey(id);
	}
	
	public List<T> getByList(T entity) throws Exception {
		return baseMapper.select(entity);
	}
	
	public void update(T entity) throws Exception {
		baseMapper.updateByPrimaryKeySelective(entity);
	}
	
	public void save(T entity) throws Exception {
		baseMapper.insertSelective(entity);
	}
}
