package com.oa.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.model.Role;
import com.oa.service.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl implements RoleService {

	@Override
	@Transactional
	public void addRole(Role role) {
		add(role);
	}

	@Override
	@Transactional
	public void deleteRole(String roleId) {
		delete(Role.class, roleId);
	}

	@Override
	@Transactional
	public void updateRole(Role role) {
		update(role);
	}

	@Override
	public List<Role> getRoles() {
		return query(Role.class, null, "roleName", true);
	}

}
