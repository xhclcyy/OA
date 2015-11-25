package com.oa.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.OfficeDao;
import com.oa.model.Accessory;
import com.oa.model.Document;
import com.oa.model.Trash;
import com.oa.service.DocumentService;
import com.oa.service.TrashService;

@Service
public class DocumentServiceImpl extends BaseServiceImpl implements
		DocumentService {
	private TrashService trashService;

	@Autowired
	public void setTrashService(TrashService trashService) {
		this.trashService = trashService;
	}

	@Override
	@Transactional
	public void createDocument(Document document) {
		add(document);
	}

	@Override
	@Transactional
	public void editDocument(Document document) {
		update(document);
	}

	@Override
	public void deleteDocument(int documentId) {
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("flag", false);
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("id", documentId);
		update(Document.class, values, conditions);
		Map<String, Object> document = this.getDocument(documentId);
		Trash trash = new Trash();
		trash.setTrashUserNo((String) document.get("documentCreaterId"));
		trash.setTrashDocOrAccName((String) document.get("documentName"));
		trash.setTrashDocOrAccId(documentId);
		trash.setTrashDocOrAcc(false);
		trash.setTrashDepartmentNo("departmentNo");
		trash.setTrashTime(new Timestamp(System.currentTimeMillis()));
		add(trash);
	}

	@Override
	@Transactional
	public void realDeleteDocument(int documentId) {
		delete(Document.class, documentId);

	}

	@Override
	public Map<String, Object> getDocuments(String parentId) {
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("documentStatus", true);
		if (parentId == null) {
			conditions.put("document", null);
		} else {
			conditions.put("document.documentId", parentId);
		}
		List<Document> documents = query(Document.class, conditions,
				"documentName", true);
		List<Map<String, Object>> list1 = new ArrayList<Map<String, Object>>();
		for (Document document : documents) {
			list1.add(getDocumentMap(document, true));
		}
		List<Map<String, Object>> list2 = new ArrayList<Map<String, Object>>();
		if (parentId != null) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("document.documentId", parentId);
			map.put("document.documentStatus", true);
			List<Accessory> accessorys = super.query(Accessory.class, map,
					"accessoryName", true);
			for (Accessory accessory : accessorys) {
				list2.add(getAccessoryMap(accessory));
			}
		}
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("folders", list1);
		result.put("files", list2);
		return result;
	}

	private Map<String, Object> getAccessoryMap(Accessory accessory) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("accessoryId", accessory.getAccessoryId());
		map.put("accessoryName", accessory.getAccessoryName());
		map.put("accessoryPath", accessory.getAccessoryPath());
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		map.put("accessoryCreateTime",
				format.format(accessory.getAccessoryCreateTime()));
		return map;
	}

	@Override
	public Map<String, Object> getDocument(int documentId) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Document> documents = query(Document.class, map, null, false);
		if (documents == null || documents.size() == 0)
			return null;
		else {
			return getDocumentMap(documents.get(0), false);
		}
	}

	@Override
	public List<Map<String, Object>> queryDocumentsByPage(
			Map<String, Object> conditions, int start, int size,
			String filedName, boolean up) {
		conditions.put("documentStatus", true);
		// conditions.put("documentProperty", "文本文档");
		List<Document> documents = queryByPage(Document.class, conditions,
				start, size, filedName, up);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (Document document : documents) {
			list.add(getDocumentMap(document, true));
		}
		return list;
	}

	private Map<String, Object> getDocumentMap(Document document,
			boolean isSimple) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("documentId", document.getDocumentId());
		map.put("documentName", document.getDocumentName());
		map.put("documentCreater", document.getLogin() == null ? null
				: document.getLogin().getLoginUserName());
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		map.put("documentCreateTime",
				format.format(document.getDocumentCreateTime()));
		if (!isSimple) {
			map.put("documentRemark", document.getDocumentRemark());
			map.put("documentProperty", document.getDocumentProperty());
			// map.put("documentPath", document.getDocumentPath());
			map.put("documentDepartmentName", document.getDepartment()
					.getDepartmentName());
		}
		return map;

	}

	@Override
	@Transactional
	public void restoreDocument(int documentId) {
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("flag", true);
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("id", documentId);
		update(Document.class, values, conditions);
		trashService.deleteTrashByDocOrAccId(documentId, true);
	}
}
