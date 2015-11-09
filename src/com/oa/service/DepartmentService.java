package com.oa.service;

import java.util.List;
import java.util.Map;

import com.oa.model.Department;

public interface DepartmentService {
	/**
	 * 添加部门
	 * @param department 部门对象
	 * @throws Exception
	 */
	public void addDepartment(Department department) throws Exception;
	/**
	 * 删除部门
	 * @param departmentId 部门Id
	 * @throws Exception
	 */
	public void deleteDepartment(String departmentId) throws Exception;
	/**
	 * 更新部门信息
	 * @param department 部门对象
	 * @throws Exception
	 */
	public void updateDepartment(Department department) throws Exception;
	/**
	 * 获取所有部门信息
	 * @return	部门信息列表
	 * @throws Exception
	 */
	public List<Map<String,Object>> getDeprtments()throws Exception;
}
