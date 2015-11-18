package com.oa.service;

import java.util.List;
import java.util.Map;

import com.oa.model.Document;
import com.oa.model.Trash;

public interface DocumentService {
	/**
	 * 把创建好的文档保存到数据库
	 * 
	 * @param document
	 *            文档对象
	 */
	public void createDocument(Document document);

	/**
	 * 把编辑好的文档保存到数据库
	 * 
	 * @param document
	 *            文档对象
	 */
	public void editDocument(Document document);

	/**
	 * 把指定的文档放到回收站（把文档状态设置为0，同时在trash表中添加一行信息表示放到回收站,不用把文档下的附件状态设置为0）
	 * 
	 * @param documentId
	 *            文档Id
	 */
	public void deleteDocument(int documentId);

	/**
	 * 真正删除文档
	 * 
	 * @param documentId
	 *            文档Id
	 */
	public void realDeleteDocument(int documentId);

	/**
	 * 获取根文件夹和根文档，如果departmentNO为null表示非第一次获取，这时根据parentId 获取下一层的文件夹和下一层的文档。
	 * 
	 * @param parentId
	 *            父级文档Id
	 * @return 文件夹及文档信息，map.get("folder")获取到List类型文件夹列表信息，
	 *         map.get("document")获取到List类型文档列表信息。
	 */
	public Map<String, String> getDocuments(String parentId);

	/**
	 * 获取文档详细信息，文档可能有附件，map.get("document")得到的是Map类型的文本详细信息,
	 * map.get("accessory")得到的是List类型的附件信息
	 * 
	 * @param documentId
	 *            文档Id
	 * @return 文档详细信息
	 */
	public Map<String, String> getDocument(int documentId);

	/**
	 * 分页搜索文档
	 * 
	 * @param departmentNo
	 *            部门编号（如果为null表示管理员进行查询，如果不为null表示部门人员进行查询）
	 * @param conditions
	 *            查询条件（文档名称、附件名称、创建者、创建时间（传两个值，起始时间和结束时间））
	 * @return 文档列表信息
	 */
	public List<Map<String, String>> queryDocumentsByPage(String departmentNo,
			Map<String, String> conditions);

	/**
	 * 从回收站还原文档
	 * 
	 * @param documentId
	 *            文档Id
	 */
	public void restoreDocument(int documentId);

}
