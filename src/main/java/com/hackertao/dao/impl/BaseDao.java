/**
 * BaseDao.java
 * data
 *
 * Function：
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2014-11-23 		JH
 *
 * Copyright (c) 2014, TNT All Rights Reserved.
*/

package com.hackertao.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hackertao.dao.IBaseDao;
import com.hackertao.po.BasePO;

/**
 * ClassName:BaseDao
 * Function: Dao基础类
 * @author   JH
 * @version  
 * @Date	 2014-11-23	下午4:15:08
 *	 
 */
public abstract class BaseDao<T extends BasePO> extends SqlSessionDaoSupport implements IBaseDao<T> {
	
	/*分页起始页码参数名*/
	public static final String PAGE_START_POS = "p_startPos";
	/*分页终止页码参数名*/
	public static final String PAGE_END_POS= "p_endPos";
	/*分页中每页记录数*/
	public static final String PAGE_SIZE = "p_pageSize";
	
	@Override
	public int insert(String statement, T po) {
		return this.getSqlSession().insert(statement, po);
	}
	
	@Override
	public int insert(String statement, List<T> poList) {
		return this.getSqlSession().insert(statement, poList);
	}
	@Override
	public int delete(String statement, int id) {
		return this.getSqlSession().delete(statement, id);
	}
	@Override
	public int update(String statement, T po) {
		return this.getSqlSession().update(statement, po);
	}
	@Override
	public int update(String statement, Object param) {
		return this.getSqlSession().update(statement, param);
	}
	@Override
	public int update(String statement, List<T> poList) {
		return this.getSqlSession().update(statement, poList);
	}
	@Override
	public T find(String statement, int id) {
		return this.getSqlSession().selectOne(statement, id);
	}
	@Override
	public T find(String statement, Object param) {
		return this.getSqlSession().selectOne(statement, param);
	}
	@Override
	public <E> E FindOneGeneric(String statement, Object param) {
		return this.getSqlSession().selectOne(statement, param);
	}
	@Override
	public <E> List<E> FindListGeneric(String statement, Object param) {
		return this.getSqlSession().selectList(statement, param);
	}
	@Override
	public <E> E findOneColumn(String statement, Object param) {
		return this.getSqlSession().selectOne(statement, param);
	}
	@Override
	public List<T> findList(String statement, Object param) {
		return this.getSqlSession().selectList(statement, param);
	}
	/*
	@Override
	public <E> Page<E> findForPage(
	        String statementForDataList, 
	        String statementForTotalCount, 
	        Map<String, Object> paramMap, 
	        int curPageNo, 
	        int pageSize
	        ) {
	    Page<E> page = new Page<E>(curPageNo, pageSize);
	    
	    int totalRecords = (Integer)this.getSqlSession().selectOne(statementForTotalCount, paramMap);
	    page.setTotalRecords(totalRecords);
	    int startIndex = page.getStartIndex();
	    if(totalRecords > 0 && totalRecords >= startIndex) {
	    	List<E> dataList = this.findForPageDataList(statementForDataList, paramMap, curPageNo, pageSize);
	    	page.setDataList(dataList);
	    } else {
	    	page.setDataList(new ArrayList<E>());
	    }
	    
	    return page;
	}
	
	*/
	@Override
	public <E> List<E> findForPageDataList(
			 	String statementForDataList, 
		        Map<String, Object> paramMap, 
		        int curPageNo, 
		        int pageSize) {
		if(paramMap == null) {
    		paramMap = new HashMap<String, Object>();
    	}
    	this.setPageParam(paramMap, curPageNo, pageSize);
    	List<E> dataList = this.getSqlSession().selectList(statementForDataList, paramMap);
    	if(dataList == null) {
    		dataList = new ArrayList<E>();
    	}
    	
    	return dataList;
	}
	@Override
	public void setPageParam(Map<String, Object> paramMap, int pageNo, int pageSize) {
		//设置开始索引
		paramMap.put(PAGE_START_POS, (pageNo - 1) * pageSize);
		//设置结束索引
		paramMap.put(PAGE_END_POS, (pageNo) * pageSize);
		//设置每页大小
		paramMap.put(PAGE_SIZE, pageSize);
	}
}


