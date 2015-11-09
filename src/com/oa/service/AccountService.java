package com.oa.service;

import com.oa.model.Login;
import com.oa.model.User;

public interface AccountService {
	/**
	 * 账号登陆
	 * @param account 用户账号（编号）
	 * @param password 用户密码
	 * @return 用户权限信息
	 * @throws Exception
	 */
	public String login(String account,String password) throws Exception;
	/**
	 * 注销登录（把登录状态设置为0）
	 * @param account 用户账号（编号）
	 * @throws Exception
	 */
	public void logout(String account) throws Exception;
	/**
	 * 用户注册
	 * @param user 用户对象
	 * @param login 用户登录信息对象
	 * @throws Exception
	 */
	public void register(User user,Login login) throws Exception;
	/**
	 * 修改密码
	 * @param loginUserNo  账号
	 * @param password 密码
	 * @throws Exception
	 */
	public void changePassword(String loginUserNo,String password) throws Exception;
	
}
