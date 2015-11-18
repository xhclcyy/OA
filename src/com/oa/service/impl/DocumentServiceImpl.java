package com.oa.service.impl;

import java.sql.Timestamp;
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
		Map<String, String> document = this.getDocument(documentId);
		Trash trash = new Trash();
		trash.setTrashUserNo(document.get("documentCreaterId"));
		trash.setTrashDocOrAccName(document.get("documentName"));
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
	public Map<String, String> getDocuments(String parentId) {
		return null;
	}

	@Override
	public Map<String, String> getDocument(int documentId) {
		return null;
	}

	@Override
	public List<Map<String, String>> queryDocumentsByPage(String departmentNo,
			Map<String, String> conditions) {
		return null;
	}

	@Override
	public void restoreDocument(int documentId) {
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("flag", true);
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("id", documentId);
		update(Document.class, values, conditions);
		trashService.deleteTrashByDocOrAccId(documentId, true);
	}
}
