package com.oa.service;

import java.io.Serializable;
import java.util.Map;

public interface BaseService {
	public void add(Object entity);
	public void update(Object entity);
	public void update(Class<?> clazz, Map<String, Object> values,
			Map<String, Object> conditions);
	public void delete(Class<?> clazz, Serializable id);
}
