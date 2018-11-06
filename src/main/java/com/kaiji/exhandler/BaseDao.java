package com.kaiji.exhandler;

import java.util.List;

import org.apache.ibatis.annotations.SelectProvider;

import com.kaiji.mapper.SelectByFilter;

import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

@RegisterMapper
public interface BaseDao<T> extends Mapper<T> {

	@SelectProvider(type = SelectByFilter.class, method = "dynamicSQL")
	List<T> selectByFilter(Example example);
}
