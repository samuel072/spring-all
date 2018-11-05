package com.kaiji.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaiji.mapper.UserMapper;
import com.kaiji.model.User;
import com.kaiji.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {

	@Resource
	private UserMapper userMapper;

	public List<User> findByFilter(Map<String, Object> filterMap) throws Exception {
		return userMapper.selectByFilter(filterMap);
	}
	
	
}
