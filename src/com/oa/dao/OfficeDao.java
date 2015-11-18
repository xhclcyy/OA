package com.oa.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface OfficeDao {
	/**
	 * 保存对象
	 * 
	 * @param obj
	 *            对象
	 */
	public void save(Object obj);

	/**
	 * 保存或更新对象
	 * 
	 * @param obj
	 *            对象
	 */
	public void saveOrUpdate(Object obj);

	/**
	 * 更新对象
	 * 
	 * @param obj
	 *            对象
	 */
	public void update(Object obj);

	/**
	 * 更新对象
	 * 
	 * @param hql
	 *            hql语句
	 * @param values
	 *            更新的字段键值对
	 * @param condictions
	 *            更新条件键值对
	 */
	void update(String hql, Map<String, Object> values,
			Map<String, Object> condictions);

	/**
	 * 根据主键删除对象
	 * 
	 * @param entity
	 *            对象类型
	 * @param id
	 *            主键
	 */
	public void deleteByPriKey(Class<?> entity, Serializable id);

	/**
	 * 批量删除对象
	 * 
	 * @param hql
	 *            hql语句
	 * @param objects
	 *            查询字段的字段值，可包含多个值
	 */
	public void batchDelete(String hql, Object[] objects);

	/**
	 * 查询
	 * 
	 * @param clazz
	 *            对象类型
	 * @param hql
	 *            hql语句
	 * @param map
	 *            查询条件键值对
	 * @return 对象列表
	 */
	public <T> List<T> queryByCondition(Class<T> clazz, String hql,
			Map<String, Object> map);

	/**
	 * SQL查询
	 * 
	 * @param sql
	 *            sql语句
	 * @param map
	 *            查询条件键值对
	 * @return 元组列表
	 */
	public List<Object> queryBySQL(String sql, Map<String, Object> map);

	/**
	 * 分页查询
	 * 
	 * @param clazz
	 *            对象类型
	 * @param hql
	 *            hql语句
	 * @param map
	 *            查询条件键值对
	 * @param start
	 *            页码
	 * @param size
	 *            分页大小
	 * @return 对象列表
	 */
	public <T> List<T> queryByConditionWithPaging(Class<T> clazz, String hql,
			Map<String, Object> map, Integer start, Integer size);

	/**
	 * 统计数量
	 * 
	 * @param hql
	 *            hql语句
	 * @return 数量
	 */
	public int count(String hql);

	/**
	 * 统计数量
	 * 
	 * @param hql
	 *            hql语句
	 * @param map
	 *            统计条件键值对
	 * @return 数量
	 */
	public int count(String hql, Map<String, Object> map);

	/**
	 * 根据hql语句执行删除操作
	 * 
	 * @param hql
	 *            hql语句
	 * @param conditions
	 *            条件键值对
	 */
	public void deleteByHQL(String hql, Map<String, Object> conditions);

}
