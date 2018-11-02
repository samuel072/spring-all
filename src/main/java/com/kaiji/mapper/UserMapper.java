package com.kaiji.mapper;

import java.util.List;
import java.util.Map;

import com.kaiji.model.User;

public interface UserMapper extends BaseDao<User> {

	List<User> findByFilter(Map<String, String> filterMap);
	
}