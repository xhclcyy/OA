package com.oa.service;

import com.oa.model.Accessory;

public interface AccessoryService {
	/**
	 * 添加附件
	 * 
	 * @param accessory
	 *            附件对象
	 */
	public void uploadAccessory(Accessory accessory);

	/**
	 * 从回收站还原附件
	 * 
	 * @param accessoryId
	 *            附件Id
	 */
	public void restoreAccessory(int accessoryId);

	/**
	 * 删除附件
	 * 
	 * @param accessoryId
	 *            附件Id
	 * @param userAccount
	 *            用户账号
	 */
	public void deleteAccessory(int accessoryId, String userAccount);

	/**
	 * 从回收站删除附件
	 * 
	 * @param accessoryId
	 *            附件Id
	 */
	public void realDeleteAccessory(int accessoryId);

	/**
	 * 根据附件id获取附件对象
	 * 
	 * @param accessoryId
	 *            附件id
	 * @return 附件对象
	 */
	public Accessory getAccessory(int accessoryId);
}
