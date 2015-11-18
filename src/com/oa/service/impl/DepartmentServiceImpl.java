package com.oa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.model.Department;
import com.oa.service.DepartmentService;

@Service
public class DepartmentServiceImpl extends BaseServiceImpl implements
		DepartmentService {

	@Override
	@Transactional
	public void addDepartment(Department department) {
		add(department);
	}

	@Override
	@Transactional
	public void deleteDepartment(String departmentId) {
		delete(Department.class, departmentId);
	}

	@Override
	public void updateDepartment(Department department) {
		update(department);
	}

	@Override
	@Transactional
	public void updateDepartmentPopulation(String departmentId) {
		String hql = "SELECT COUNT(*) FROM Login lg WHERE lg.department.departmentId=:departmentId";
		int count = officeDao.count(hql);
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("departmentPopulation", count);
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("departmentId", departmentId);
		update(Department.class, values, conditions);
	}

	@Override
	public List<Map<String, Object>> getDeprtments() {
		return null;
	}

}
