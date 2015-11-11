package com.oa.service;

import java.util.List;
import java.util.Map;

import com.oa.model.Role;

public interface RoleService {
	/**
	 * 添加角色
	 * 
	 * @param role
	 *            角色对象
	 */
	public void addRole(Role role);

	/**
	 * 删除角色
	 * 
	 * @param roleId
	 *            角色Id
	 */
	public void deleteRole(String roleId);

	/**
	 * 更新角色
	 * 
	 * @param role
	 *            角色对象
	 */
	public void updateRole(Role role);

	/**
	 * 获取所有角色
	 * 
	 * @return 角色信息列表
	 */
	public List<Map<String, Object>> getRoles();
}
