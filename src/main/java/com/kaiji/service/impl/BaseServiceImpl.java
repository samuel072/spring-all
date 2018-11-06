package com.kaiji.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kaiji.exhandler.BaseDao;
import com.kaiji.model.User;
import com.kaiji.service.BaseService;

import tk.mybatis.mapper.entity.Example;

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
	
	public List<T> findByFilter(Map<String, Object> filterMap) throws Exception {
		Example example = new Example(User.class);
		Example.Criteria criteria = example.createCriteria();
		
		String timeKey = null;
		Object startTime = null;
		Object endTime = null;
		for (Map.Entry<String, Object> map : filterMap.entrySet()) {
			String key = map.getKey();
			
			// 默认是and
			if (key.endsWith("or")) {
				key = key.substring(0, key.indexOf("or") -1);
				example.or().andCondition(key, map.getValue());
			} else if (key.endsWith("not")) {
				key = key.substring(0, key.indexOf("not") -1);
				criteria.andNotEqualTo(key, map.getValue());
			} else if (key.endsWith("start")) {
				key = key.substring(0, key.indexOf("start") -1);
				timeKey = key;
				startTime = map.getValue();
			} else if (key.endsWith("end")) {
				key = key.substring(0, key.indexOf("end") -1);
				endTime = map.getValue();
			}
		}
		if (null != startTime && null != endTime && null != timeKey) {
			criteria.andBetween(timeKey, startTime, endTime);
		}
		return baseDao.selectByFilter(example);
	}

	public Page<T> selectByPage8(Map<String, Object> filterMap, Page<T> page) throws Exception {
		return PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPage(()->{
					try {
						findByFilter(filterMap);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
	}
	
	public Page<T> selectByPage(Map<String, Object> filterMap, Page<T> page) throws Exception {
		return PageHelper.startPage(page.getPageNum(), page.getPageSize()).doSelectPage(new ISelect() {
			@Override
			public void doSelect() {
				try {
					findByFilter(filterMap);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
