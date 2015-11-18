package com.oa.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.OfficeDao;
import com.oa.service.BaseService;

@Component
public class BaseServiceImpl implements BaseService {
	protected OfficeDao officeDao;

	@Autowired
	public void setVolunteerDao(OfficeDao volunteerDao) {
		this.officeDao = volunteerDao;
	}

	@Override
	public void add(Object entity) {
		this.officeDao.save(entity);
	}

	@Override
	public void update(Object entity) {
		this.officeDao.update(entity);
	}

	@Override
	public void update(Class<?> clazz, Map<String, Object> values,
			Map<String, Object> conditions) {
		String className = clazz.getName();
		StringBuffer hql = new StringBuffer("UPDATE " + className + " cn SET ");
		if (values != null && !values.isEmpty()) {
			for (String key : values.keySet()) {
				hql.append(" cn." + key + "=:" + key + ",");
			}
			hql.deleteCharAt(hql.length() - 1);
		}
		if (conditions != null && !conditions.isEmpty()) {
			hql.append(" WHERE");
			for (String key : conditions.keySet()) {
				hql.append(" cn." + key + "=:" + key + " AND");
			}
			hql.delete(hql.length() - 4, hql.length());
		}
		officeDao.update(hql.toString(), values, conditions);
	}

	@Override
	public void delete(Class<?> clazz, Serializable id) {
		officeDao.deleteByPriKey(clazz, id);
	}

	@Override
	public void delete(Class<?> clazz, Map<String, Object> conditions) {
		String className = clazz.getName();
		StringBuffer hql = new StringBuffer("DELETE " + className + " cn ");
		if (conditions != null && !conditions.isEmpty()) {
			hql.append(" WHERE");
			for (String key : conditions.keySet()) {
				hql.append(" cn." + key + "=:" + key + " AND");
			}
			hql.delete(hql.length() - 4, hql.length());
		} else {
			hql.append(" WHERE 1=1");
		}
		officeDao.deleteByHQL(hql.toString(), conditions);
	}

	@Override
	public <T> List<T> query(Class<T> clazz, Map<String, Object> map,
			String filedName, boolean up) {
		List<T> list = null;
		String className = clazz.getSimpleName();
		StringBuffer hql = new StringBuffer("FROM " + className + " cn");
		if (map != null && !map.isEmpty()) {
			hql.append(" WHERE");
			for (String key : map.keySet()) {
				hql.append(" cn." + key + "=:" + key + " AND");
			}
			hql.delete(hql.length() - 4, hql.length());
		}
		if (filedName != null) {
			hql.append(" ORDER BY cn." + filedName);
			if (up)
				hql.append(" ASC");
			else
				hql.append(" DESC");
		}
		list = officeDao.queryByCondition(clazz, hql.toString(), map);
		return list;
	}
}
