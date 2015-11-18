package com.oa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.model.Trash;
import com.oa.service.TrashService;

@Service
public class TrashServiceImpl extends BaseServiceImpl implements TrashService {

	@Override
	@Transactional
	public void addTrash(Trash trash) {
		add(trash);
	}

	@Override
	@Transactional
	public void deleteTrash(String trashId) {
		delete(Trash.class, trashId);
	}

	@Override
	@Transactional
	public void emptyTrash(String departmentNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (departmentNo != null) {
			map.put("trashDepartmentNo", departmentNo);
		}
		delete(Trash.class, map);
	}

	@Override
	public List<Trash> getTrashs() {
		return query(Trash.class, null, "trashTime", false);
	}

	@Override
	public List<Trash> getTrashsByDepartmentNo(String departmentNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("trashDepartmentNo", departmentNo);
		return query(Trash.class, null, "trashTime", false);
	}

	@Override
	@Transactional
	public void deleteTrashByDocOrAccId(int trashDocOrAccId,
			boolean trashDocOrAcc) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("trashDocOrAccId", trashDocOrAccId);
		map.put("trashDocOrAcc", trashDocOrAcc);
		delete(Trash.class, map);
	}

}
