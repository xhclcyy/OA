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
public class AccountServiceImpl implements AccountService {
	private OfficeDao officeDao;

	@Autowired
	public void setVolunteerDao(OfficeDao officeDao) {
		this.officeDao = officeDao;
	}
	@Override
	public Login login(String account, String password) {
		String hql="from Login lg where lg.loginUserNo=:account and lg.loginPassword=:password";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("account", account);
		map.put("password", password);
		List<Login> logins=(List<Login>)officeDao.queryByCondition(Login.class,hql, map);
		if(logins!=null&&logins.size()>0){
			return logins.get(0);
		}else{
			return null;
		}
		
	}

	@Override
	public void logout(String account) {
		// TODO Auto-generated method stub

	}

	@Override
	public void register(User user, Login login) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePassword(String loginUserNo, String password) {
		// TODO Auto-generated method stub

	}
	@Override
	@Transactional
	public void update(Login login) {
		officeDao.update(login);
	}

}
