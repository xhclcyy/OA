package com.oa.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oa.dao.OfficeDao;

@Repository
public class OfficeDaoImpl implements OfficeDao {
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Object obj) {
		getSession().save(obj);
	}

	@Override
	public void saveOrUpdate(Object obj) {
		getSession().saveOrUpdate(obj);
	}

	@Override
	public void update(Object obj) {
		getSession().update(obj);
	}

	@Override
	public void update(String hql, Map<String, Object> values,
			Map<String, Object> conditions) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		if (values != null && !values.isEmpty()) {
			for (String key : values.keySet()) {
				query.setParameter(key, values.get(key));
			}
		}
		if (conditions != null && !conditions.isEmpty()) {
			for (String key : conditions.keySet()) {
				query.setParameter(key, conditions.get(key));
			}
		}
		query.executeUpdate();
	}

	@Override
	public void deleteByPriKey(Class<?> entity, Serializable id) {
		getSession().delete(getSession().load(entity, id));
	}

	@Override
	public void deleteByHQL(String hql, Map<String, Object> conditions) {
		Query query = getSession().createQuery(hql);
		if (conditions != null && !conditions.isEmpty()) {
			for (String key : conditions.keySet()) {
				query.setParameter(key, conditions.get(key));
			}
		}
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> queryByCondition(Class<T> clazz, String hql,
			Map<String, Object> map) {
		Query query = getSession().createQuery(hql);
		if (map != null && !map.isEmpty()) {
			for (String key : map.keySet()) {
				query.setParameter(key, map.get(key));
			}
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> queryBySQL(String sql, Map<String, Object> map) {
		Query query = getSession().createSQLQuery(sql);
		if (map != null && !map.isEmpty()) {
			for (String key : map.keySet()) {
				query.setParameter(key, map.get(key));
			}
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> List<T> queryByConditionWithPaging(Class<T> clazz, String hql,
			Map<String, Object> map, Integer start, Integer size) {
		Query query = getSession().createQuery(hql);
		if (map != null && !map.isEmpty()) {
			for (String key : map.keySet()) {
				query.setParameter(key, map.get(key));
			}
		}
		query = query.setFirstResult((start - 1) * size);
		query = query.setMaxResults(size);
		return query.list();
	}

	@Override
	public int count(String hql) {
		Query query = getSession().createQuery(hql);
		return Integer.parseInt(query.uniqueResult().toString());
	}

	@Override
	public int count(String hql, Map<String, Object> map) {
		Query query = getSession().createQuery(hql);
		if (map != null && !map.isEmpty()) {
			for (String key : map.keySet()) {
				query.setParameter(key, map.get(key));
			}
		}
		return Integer.parseInt(query.uniqueResult().toString());
	}

	@Override
	public void batchDelete(String hql, Object[] objects) {
		Query q = getSession().createQuery(hql);
		q.setParameterList("objects", objects);
		q.executeUpdate();
	}

}
