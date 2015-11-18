package com.oa.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.model.Accessory;
import com.oa.model.Trash;
import com.oa.service.AccessoryService;
import com.oa.service.TrashService;

@Service
public class AccessoryServiceImpl extends BaseServiceImpl implements
		AccessoryService {
	private TrashService trashService;

	@Autowired
	public void setTrashService(TrashService trashService) {
		this.trashService = trashService;
	}

	@Override
	@Transactional
	public void uploadAccessory(Accessory accessory) {
		add(accessory);
	}

	@Override
	@Transactional
	public void restoreAccessory(int accessoryId) {
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("accessoryStatus", true);
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("accessoryId", accessoryId);
		update(Accessory.class, values, conditions);
		trashService.deleteTrashByDocOrAccId(accessoryId, false);
	}

	@Override
	@Transactional
	public void deleteAccessory(int accessoryId, String userAccount) {
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("accessoryStatus", false);
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("accessoryId", accessoryId);
		update(Accessory.class, values, conditions);
		Accessory accessory = this.getAccessory(accessoryId);
		Trash trash = new Trash();
		trash.setTrashUserNo(userAccount);
		trash.setTrashDocOrAccName(accessory.getAccessoryName());
		trash.setTrashDocOrAccId(accessoryId);
		trash.setTrashDocOrAcc(false);
		trash.setTrashDepartmentNo(accessory.getLogin().getDepartment()
				.getDepartmentNo());
		trash.setTrashTime(new Timestamp(System.currentTimeMillis()));
		add(trash);
	}

	@Override
	@Transactional
	public void realDeleteAccessory(int accessoryId) {
		delete(Accessory.class, accessoryId);
	}

	@Override
	public Accessory getAccessory(int accessoryId) {
		String hql = "FROM Accessory ac WHERE ac.accessoryId=:accessoryId";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("accessoryId", accessoryId);
		return officeDao.queryByCondition(Accessory.class, hql, null).get(0);
	}

}
