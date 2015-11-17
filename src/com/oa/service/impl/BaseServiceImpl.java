package com.oa.service.impl;

import java.io.Serializable;
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
	@Transactional
	public void add(Object entity) {
		this.officeDao.save(entity);
	}

	@Override
	@Transactional
	public void update(Object entity) {
		this.officeDao.update(entity);
	}

	@Override
	@Transactional
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
	@Transactional
	public void delete(Class<?> clazz, Serializable id) {
		officeDao.deleteByPriKey(clazz, id);
	}
}
