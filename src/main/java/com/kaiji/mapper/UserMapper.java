package com.kaiji.mapper;

import java.util.List;
import java.util.Map;

import com.kaiji.model.User;

import tk.mybatis.mapper.common.BaseMapper;

public interface UserMapper extends BaseMapper<User> {

	List<User> findByFilter(Map<String, String> filterMap);
	
}