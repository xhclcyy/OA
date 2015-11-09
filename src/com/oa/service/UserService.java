package com.oa.service;

import com.oa.model.User;

public interface UserService {
	/**
	 * 获取用户信息
	 * @param userNo 用户编号
	 * @return 用户信息
	 * @throws Exception
	 */
	public User getUserInfo(String userNo) throws Exception;
	/**
	 * 更新用户信息
	 * @param user 用户对象
	 * @throws Exception
	 */
	public void uptateUserInfo(User user) throws Exception;
	/**
	 * 添加用户信息
	 * @param user 用户对象
	 * @throws Exception
	 */
	public void addUserInfo(User user)throws Exception;
	/**
	 * 删除用户
	 * @param userId 用户Id
	 * @throws Exception
	 */
	public void deleteUserInfo(String userId) throws Exception;
}
