package com.oa.service;

import java.util.List;
import java.util.Map;

import com.oa.model.Role;

public interface RoleService {
	/**
	 * 添加角色
	 * @param role 角色对象
	 * @throws Exception
	 */
	public void addRole(Role role) throws Exception;
	/**
	 * 删除角色
	 * @param roleId 角色Id
	 * @throws Exception
	 */
	public void deleteRole(String roleId) throws Exception;
	/**
	 * 更新角色
	 * @param role 角色对象
	 * @throws Exception
	 */
	public void updateRole(Role role) throws Exception;
	/**
	 * 获取所有角色
	 * @return 角色信息列表
	 * @throws Exception
	 */
	public List<Map<String,Object>> getRoles()throws Exception;
}
