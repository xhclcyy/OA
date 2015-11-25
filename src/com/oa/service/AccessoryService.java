package com.oa.service;

import java.util.List;
import java.util.Map;

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
	/**
	 * 按条件查找附件
	 * @param userName 用户名
	 * @param accessoryName 附件名
	 * @param start 页码
	 * @param size 分页大小
	 * @return 附件列表信息
	 */
	public List<Map<String,Object>> queryAccessorys(String userName,String accessoryName,int start,int size);
}
