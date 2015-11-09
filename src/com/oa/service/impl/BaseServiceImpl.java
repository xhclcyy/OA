package com.oa.service.impl;

import java.io.Serializable;

import com.oa.dao.OfficeDao;
import com.oa.service.BaseService;

public class BaseServiceImpl implements BaseService{
	public OfficeDao getOfficeDao(){
		return null;
	}
	@Override
	public void add(Object t) throws Exception {
		this.getOfficeDao().save(t);
	}

	@Override
	public void update(Object t) throws Exception {
		this.getOfficeDao().update(t);
	}

	@Override
	public void delete(Class<?> clazz, Serializable id) throws Exception {
		this.getOfficeDao().deleteByPriKey(clazz, id);
	}

}
