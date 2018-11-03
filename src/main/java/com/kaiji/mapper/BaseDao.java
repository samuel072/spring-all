package com.kaiji.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import tk.mybatis.mapper.common.BaseMapper;

@Component
public interface BaseDao<T> extends BaseMapper<T> {

	List<T> selectByFilter(Map<String, Object> filterMap);
}
