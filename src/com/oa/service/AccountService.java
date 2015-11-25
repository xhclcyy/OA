package com.oa.service;

import java.util.List;
import java.util.Map;

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
	 * 获取登录对象
	 * 
	 * @param userAccount
	 *            用户账号
	 * @return 登录对象
	 */
	public Login getLogin(String userAccount);

	/**
	 * 更新登录对象
	 * 
	 * @param login
	 *            登录对象
	 */
	public void update(Login login);
	
	/**
	 * 获取用户信息
	 * 
	 * @param userNo
	 *            用户编号
	 * @return 用户信息
	 */
	public Map<String, Object> getUserInfo(String userNo);

	/**
	 * 获取用户信息列表
	 * 
	 * @param map
	 *            查询条件键值对
	 * @param start
	 *            页码
	 * @param size
	 *            分页大小
	 * @param filedName
	 *            排序字段名
	 * @param up
	 *            true为按filedName字段升序排序，false为按filedName字段降序排序
	 * @return 用户信息列表
	 */
	public List<Map<String, Object>> getUserListInfo(Map<String, Object> map,
			int start, int size, String filedName, boolean up);

	/**
	 * 更新用户信息
	 * 
	 * @param user
	 *            用户对象
	 */
	public void uptateUserInfo(User user);

	/**
	 * 添加用户信息
	 * 
	 * @param user
	 *            用户对象
	 */
	public void addUserInfo(User user);

	/**
	 * 删除用户
	 * 
	 * @param userId
	 *            用户Id
	 */
	public void deleteUserInfo(String userId);
}
