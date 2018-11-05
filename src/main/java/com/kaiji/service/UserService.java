package com.kaiji.service;

import java.util.List;
import java.util.Map;

import com.kaiji.model.User;

public interface UserService extends BaseService<User, String> {

	List<User> findByFilter(Map<String, Object> filterMap) throws Exception;

}
