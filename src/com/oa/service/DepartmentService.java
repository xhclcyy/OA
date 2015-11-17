package com.oa.service;

import java.util.List;
import java.util.Map;

import com.oa.model.Department;

public interface DepartmentService {
	/**
	 * 添加部门
	 * 
	 * @param department
	 *            部门对象
	 */
	public void addDepartment(Department department);
	/**
	 * 删除部门
	 * 
	 * @param departmentId
	 *            部门Id
	 */
	public void deleteDepartment(String departmentId);

	/**
	 * 更新部门信息
	 * 
	 * @param department
	 *            部门对象
	 */
	public void updateDepartment(Department department);

	/**
	 * 获取所有部门信息
	 * 
	 * @return 部门信息列表
	 */
	public List<Map<String, Object>> getDeprtments();
}
