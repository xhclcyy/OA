package com.oa.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.model.Accessory;
import com.oa.service.AccessoryService;

@Service
public class AccessoryServiceImpl extends BaseServiceImpl implements
		AccessoryService {

	@Override
	@Transactional
	public void uploadAccessory(Accessory accessory) {
		add(accessory);
	}

	@Override
	public void restoreAccessory(String accessoryId) {
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("accessoryStatus", true);
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("accessoryId", accessoryId);
		update(Accessory.class, values, conditions);
	}

	@Override
	public void deleteAccessory(String accessoryId) {
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("accessoryStatus", false);
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("accessoryId", accessoryId);
		update(Accessory.class, values, conditions);
	}

	@Override
	@Transactional
	public void realDeleteAccessory(String accessoryId) {
		delete(Accessory.class, accessoryId);
	}

}
