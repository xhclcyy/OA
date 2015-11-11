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
	public void restoreAccessory(String accessoryId);

	/**
	 * 删除附件
	 * 
	 * @param accessoryId
	 *            附件Id
	 */
	public void deleteAccessory(String accessoryId);

	/**
	 * 从回收站删除附件
	 * 
	 * @param accessoryId
	 *            附件Id
	 */
	public void realDeleteAccessory(String accessoryId);
}
