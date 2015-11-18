package com.oa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oa.dao.OfficeDao;
import com.oa.model.Document;
import com.oa.model.Trash;
import com.oa.service.DocumentService;

@Service
public class DocumentServiceImpl extends BaseServiceImpl implements
		DocumentService {
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
	public void deleteDocument(String documentId) {
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("flag", false);
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("id", documentId);
		update(Document.class, values, conditions);
		//待完成，添加文档到Trash表
	}

	@Override
	@Transactional
	public void realDeleteDocument(String documentId) {
		delete(Document.class, documentId);

	}

	@Override
	public Map<String, Object> getDocuments(String departmentNo, String parentId) {
		return null;
	}

	@Override
	public Map<String, Object> getDocument(String documentId) {
		return null;
	}

	@Override
	public List<Map<String, Object>> queryDocumentsByPage(String departmentNo,
			Map<String, String> conditions) {
		return null;
	}

	@Override
	public void restoreDocument(String documentId) {
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("flag", true);
		Map<String, Object> conditions = new HashMap<String, Object>();
		conditions.put("id", documentId);
		update(Document.class, values, conditions);
		//待完成，从Trash表中删除文档
	}

	@Override
	public void getTrashDocAndAccByPage(String departmentNo, String condition) {

	}

}
