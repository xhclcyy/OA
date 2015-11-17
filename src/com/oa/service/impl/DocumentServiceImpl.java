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
public class DocumentServiceImpl implements DocumentService {
	private OfficeDao officeDao;

	@Autowired
	public void setVolunteerDao(OfficeDao officeDao) {
		this.officeDao = officeDao;
	}

	@Override
	@Transactional
	public void createDocument(Document document) {
		this.officeDao.save(document);
	}

	@Override
	public void editDocument(Document document) {
		this.officeDao.update(document);

	}

	@Override
	public void deleteDocument(String documentId, Trash trash) {
		String hql = "update Document set documentStatus=:flag where documentId=:id";
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("id", documentId);
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("flag", false);
		this.officeDao.update(hql, map1, map2);
		this.officeDao.save(trash);
	}

	@Override
	public void realDeleteDocument(String documentId) {
		this.officeDao.deleteByPriKey(Document.class, documentId);

	}

	@Override
	public void emptyTrash(String departmentNo) {

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

	}

	@Override
	public void getTrashDocAndAccByPage(String departmentNo, String condition) {

	}

}
