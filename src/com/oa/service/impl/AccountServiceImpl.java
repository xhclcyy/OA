package com.oa.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

	@Override
	public Map<String, Object> getUserInfo(String userNo) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userNo",userNo);
		List<User> list=super.query(User.class, map,null,false);
		if(list==null||list.size()==0) return null;
		else{
			User user=list.get(0);
			return getUserMap(user,true);
		}
	}

	@Override
	public List<Map<String, Object>> getUserListInfo(Map<String, Object> map,
			int start, int size, String filedName, boolean up) {
		List<User> list=super.queryByPage(User.class, map, start, size, filedName, up);
		List<Map<String,Object>> maps=new ArrayList<Map<String,Object>>();
		for( int i=0;i<list.size();i++){
			maps.add(getUserMap(list.get(i),false));
		}
		return maps;
	}
	SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
	private Map<String,Object> getUserMap(User user,boolean bool){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userId", user.getUserId());
		map.put("userNo",user.getUserNo() );
		map.put("userAge",user.getUserAge() );
		map.put("userSex", user.getUserSex());
		map.put("userPhone", user.getUserPhone());
		map.put("userEmail", user.getUserEmail());
		map.put("userName", user.getUserName());
		if(bool){
		map.put("userBirthday", format.format(user.getUserBirthday()));
		map.put("userNation", user.getUserNation());
		map.put("userMaritalStatus", user.getUserMaritalStatus());
		map.put("userTelphone", user.getUserTelphone());
		map.put("userRemark", user.getUserRemark());
		map.put("userAddress", user.getUserAddress());
		map.put("userHiredate",format.format( user.getUserHiredate()));
		map.put("userPoliticsStatus", user.getUserPoliticsStatus());
		map.put("userOfficePhone", user.getUserOfficePhone());
		map.put("userNativePlace", user.getUserNativePlace());
		map.put("userPicture", user.getUserPicture());
		map.put("userOfficeAddress", user.getUserOfficeAddress());
		}
		return map;
	}
	@Override
	@Transactional
	public void uptateUserInfo(User user) {
		super.update(user);
	}

	@Override
	@Transactional
	public void addUserInfo(User user) {
		super.add(user);
	}

	@Override
	@Transactional
	public void deleteUserInfo(String userId) {
		super.delete(User.class,userId);
	}
}
