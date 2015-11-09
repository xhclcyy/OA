package com.oa.service;

import com.oa.model.Accessory;

public interface AccessoryService {
	/**
	 * 添加附件
	 * @param accessory 附件对象
	 * @throws Exception
	 */
	public void uploadAccessory(Accessory accessory) throws Exception;
	/**
	 * 从回收站还原附件
	 * @param accessoryId 附件Id
	 * @throws Exception
	 */
	public void restoreAccessory(String accessoryId) throws Exception;
	/**
	 * 删除附件
	 * @param accessoryId 附件Id
	 * @throws Exception
	 */
	public void deleteAccessory(String accessoryId) throws Exception;
	/**
	 * 从回收站删除附件
	 * @param accessoryId 附件Id
	 * @throws Exception
	 */
	public void realDeleteAccessory(String accessoryId)throws Exception;
}
