package com.oa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.OfficeDao;
import com.oa.model.Login;
import com.oa.model.User;
import com.oa.service.AccountService;

@Service
public class AccountServiceImpl extends BaseServiceImpl implements
		AccountService {

	@Override
	public Login login(String account, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginUserNo", account);
		map.put("loginPassword", password);
		List<Login> logins = super.query(Login.class, map, null, false);
		if (logins != null && logins.size() > 0) {
			return logins.get(0);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public void logout(String userAccount) {
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("loginStatus", false);
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("loginUserNo", userAccount);
		update(Login.class, values, conditions);
	}

	@Override
	@Transactional
	public void register(User user, Login login) {
		add(user);
		add(login);
	}

	@Override
	public void changePassword(String loginUserNo, String password) {
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("loginPassword", password);
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("loginUserNo", loginUserNo);
		super.update(Login.class, values, conditions);
	}

	@Override
	public Login getLogin(String userAccount) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginUserNo", userAccount);
		List<Login> logins = super.query(Login.class, map, null, false);
		if (logins != null && logins.size() > 0) {
			return logins.get(0);
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public void update(Login login) {
		super.update(login);
	}
}
