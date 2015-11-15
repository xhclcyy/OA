package com.oa.service;

import javax.transaction.Transactional;

import com.oa.model.Login;
import com.oa.model.User;

public interface AccountService {
	/**
	 * 账号登陆
	 * 
	 * @param account
	 *            用户账号（编号）
	 * @param password
	 *            用户密码
	 * @return 登录信息
	 */
	public Login login(String account, String password);

	/**
	 * 注销登录（把登录状态设置为0）
	 * 
	 * @param account
	 *            用户账号（编号）
	 */
	public void logout(String account);

	/**
	 * 用户注册
	 * 
	 * @param user
	 *            用户对象
	 * @param login
	 *            用户登录信息对象
	 */
	public void register(User user, Login login);

	/**
	 * 修改密码
	 * 
	 * @param loginUserNo
	 *            账号
	 * @param password
	 *            密码
	 */
	public void changePassword(String loginUserNo, String password);
	/**
	 * 更新Login对象
	 * @param login 登录对象
	 */
	@Transactional
	public void update(Login login);
}
