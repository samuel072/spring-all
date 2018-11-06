package com.kaiji.mapper;

import org.apache.ibatis.mapping.MappedStatement;

import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

/**
 * 自定义基础查询
 * 
 * @author kaiji
 * @since 2018-11-5
 */
public class SelectByFilter extends MapperTemplate {

	public SelectByFilter(Class<?> mapperClass, MapperHelper mapperHelper) {
		super(mapperClass, mapperHelper);
	}
	
	public String selectByFilter(MappedStatement ms) {
		 Class<?> entityClass = getEntityClass(ms);
	        //将返回值修改为实体类型
	        setResultType(ms, entityClass);
	        StringBuilder sql = new StringBuilder("SELECT ");
	        if (isCheckExampleEntityClass()) {
	            sql.append(SqlHelper.exampleCheck(entityClass));
	        }
	        sql.append("<if test=\"distinct != null\">distinct</if>");
	        //支持查询指定列
	        sql.append(SqlHelper.exampleSelectColumns(entityClass));
	        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
	        sql.append(SqlHelper.exampleWhereClause());
	        sql.append(SqlHelper.exampleOrderBy(entityClass));
	        sql.append(SqlHelper.exampleForUpdate());
	        return sql.toString();
	}

}
