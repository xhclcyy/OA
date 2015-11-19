package com.oa.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseService {
	public void add(Object entity);

	public void update(Object entity);

	public void update(Class<?> clazz, Map<String, Object> values,
			Map<String, Object> conditions);

	public void delete(Class<?> clazz, Serializable id);

	public void delete(Class<?> clazz, Map<String, Object> conditions);

	public <T> List<T> query(Class<T> clazz, Map<String, Object> map,
			String filedName, boolean up);

	public <T> List<T> queryByPage(Class<T> clazz, Map<String, Object> map,
			int start, int size, String filedName, boolean up);
}
