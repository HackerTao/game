package com.hackertao.dao;

import java.util.List;
import java.util.Map;

import com.hackertao.po.BasePO;
/**
 * ClassName:IBaseDao
 * Function: Dao基础接口
 * @author   HackerTao
 * @version  1.0.1
 * @Date	 2014-11-23	下午4:15:08
 *	 
 */
public interface IBaseDao<T extends BasePO> {

	/**
	 * 插入一条记录
	 * @param statement
	 * @param po
	 * @return The number of rows affected by the insert.
	 */
	public int insert(String statement, T po);
	
	/**
	 * 批量更新
	 * @param statement
	 * @param poList 待插入对象
	 * @return The number of rows affected by the insert.
	 */
	public int insert(String statement, List<T> poList);
	
	/**
	 * 根据删除一条记录
	 * @param statement
	 * @param id
	 * @return The number of rows affected by the delete.
	 */
	public int delete(String statement, int id);
	
	/**
	 * 更新一条记录
	 * @param statement
	 * @param po
	 * @return The number of rows affected by the update.
	 */
	public int update(String statement, T po);
	
	/**
	 * 更新一条记录
	 * @param statement
	 * @param po
	 * @return The number of rows affected by the update.
	 */
	public int update(String statement, Object param);
	
	/**
	 * 批量更新记录
	 * @param statement 
	 * @param poList 待更新对象
	 * @return The number of rows affected by the update.
	 */
	public int update(String statement, List<T> poList);
	
	/**
	 * 根据ID查询一条记录
	 * @param statement
	 * @param id
	 * @return
	 */
	public T find(String statement, int id);
	
	/**
	 * 根据相关条件查询一条记录
	 * @param statement
	 * @param param
	 * @return
	 */
	public T find(String statement, Object param);
	
	/**
	 * 一般查找方法
	 * @param statement
	 * @param param
	 * @return
	 */
	public <E> E FindOneGeneric(String statement, Object param);
	
	/**
	 * 一般查找方法
	 * @param statement
	 * @param param
	 * @return
	 */
	public <E> List<E> FindListGeneric(String statement, Object param);
	
	/**
	 * 查询单个字段的方法（如查询总数等）
	 * @param statement
	 * @param param
	 * @return
	 */
	public <E> E findOneColumn(String statement, Object param);
	
	/**
	 * 根据条件查询一批记录
	 * @param statement
	 * @param param
	 * @return
	 */
	public List<T> findList(String statement, Object param);
	
	/**
	 * 获取分页数据
	 * @param statementForDataList
	 * @param statementForTotalCount
	 * @param paramMap
	 * @param curPageNo
	 * @param pageSize
	 * @return
	 */
	/*
	 * TODO 添加分页功能
	public <E> Page<E> findForPage(
	        String statementForDataList, 
	        String statementForTotalCount, 
	        Map<String, Object> paramMap, 
	        int curPageNo, 
	        int pageSize
	        );
	        
	 */
	
	/**
	 * 获取分页数据列表
	 * @param statementForDataList
	 * @param paramMap
	 * @param curPageNo
	 * @param pageSize
	 * @return
	 */
	public <E> List<E> findForPageDataList(
			 	String statementForDataList, 
		        Map<String, Object> paramMap, 
		        int curPageNo, 
		        int pageSize);
	
	/**
	 * 设置分页参数
	 * @param paramMap
	 * @param pageNo
	 * @param pageSize
	 */
	public void setPageParam(Map<String, Object> paramMap, int pageNo, int pageSize);
	
}