package com.kaiji.mapper;

import java.util.List;
import java.util.Map;

import tk.mybatis.mapper.common.BaseMapper;

public interface BaseDao<T> extends BaseMapper<T> {

	List<T> selectByFilter(Map<String, Object> filterMap);
}
