package com.oa.service;

import java.io.Serializable;

public interface BaseService {
	/**
	 * 添加对象
	 * @param t 对象
	 * @throws Exception
	 */
	public  void add(Object t) throws Exception;
	/**
	 * 更新对象
	 * @param t 对象
	 * @throws Exception
	 */
	public  void update(Object t) throws Exception;
	/**
	 * 删除对象
	 * @param clazz 对象类型
	 * @param id 对象Id
	 * @throws Exception
	 */
	public void delete(Class<?> clazz, Serializable id)throws Exception;
}
