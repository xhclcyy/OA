package com.oa.service;

import com.oa.model.User;

public interface UserService {
	/**
	 * 获取用户信息
	 * 
	 * @param userNo
	 *            用户编号
	 * @return 用户信息
	 */
	public User getUserInfo(String userNo);

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
