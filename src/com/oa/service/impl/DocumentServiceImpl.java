package com.oa.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.oa.dao.OfficeDao;
import com.oa.model.Document;
import com.oa.model.Trash;
import com.oa.service.DocumentService;

public class DocumentServiceImpl implements DocumentService{
	public	 BaseServiceImpl getBaseServiceImpl(){
		BaseServiceImpl t=new BaseServiceImpl();
		return t;
	}
	public OfficeDao getOfficeDao(){
		return null;
	}
	@Override
	public void createDocument(Document document) throws Exception {
		this.getBaseServiceImpl().add(document);
		
	}

	@Override
	public void editDocument(Document document) throws Exception {
		this.getBaseServiceImpl().update(document);
		
	}

	@Override
	public void deleteDocument(String documentId,Trash trash) throws Exception {
		String hql="update Document set documentStatus=:flag where documentId=:id";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id",documentId);
		map.put("flag", false	);
		this.getOfficeDao().update(hql, map);
		this.getBaseServiceImpl().add(trash);
	}

	@Override
	public void realDeleteDocument(String documentId) throws Exception {
		this.getBaseServiceImpl().delete(Document.class, documentId);
		
	}

	@Override
	public void emptyTrash(String departmentNo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> getDocuments(String departmentNo, String parentId)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getDocument(String documentId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> queryDocumentsByPage(String departmentNo,
			Map<String, String> conditions) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void restoreDocument(String documentId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTrashDocAndAccByPage(String departmentNo, String condition)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
