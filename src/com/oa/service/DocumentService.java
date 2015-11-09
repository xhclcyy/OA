package com.oa.service;

import java.util.List;
import java.util.Map;

import com.oa.model.Document;

public interface DocumentService {
	/**
	 * 把创建好的文档保存到数据库
	 * @param document 文档对象
	 * @throws Exception
	 */
	public void createDocument(Document document) throws Exception;
	/**
	 * 把编辑好的文档保存到数据库
	 * @param document 文档对象
	 * @throws Exception
	 */
	public void editDocument(Document document) throws Exception;
	/**
	 * 把指定的文档放到回收站（把文档状态设置为0，同时在trash表中添加一行信息表示放到回收站,不用把文档下的附件状态设置为0）
	 * @param documentId	文档Id
	 * @throws Exception
	 */
	public void deleteDocument(String documentId) throws Exception;
	/**
	 * 真正删除文档
	 * @param documentId 文档Id
	 * @throws Exception
	 */
	public void realDeleteDocument(String documentId) throws Exception;
	/**
	 *  清空回收站（批量删除文档和附件），如果departmentNo为null表示管理员操作，会清空
	 *  所有部门的回收站
	 * @param departmentNo 部门编号
	 * @throws Exception
	 */
	public void emptyTrash(String departmentNo) throws Exception;
	/**
	 *  获取文件夹及文档，如果departmentNo不为null表示第一次获取，这时根据登录者的部门
	 *  获取根文件夹和根文档，如果departmentNO为null表示非第一次获取，这时根据parentId
	 *  获取下一层的文件夹和下一层的文档。
	 * @param departmentNo 部门编号
	 * @param parentId 父级文档Id
	 * @return  文件夹及文档信息，map.get("folder")获取到List类型文件夹列表信息，
	 * map.get("document")获取到List类型文档列表信息。
	 * @throws Exception
	 */
	public Map<String,Object> getDocuments(String departmentNo,String parentId) throws Exception;
	/**
	 * 获取文档详细信息，文档可能有附件，map.get("document")得到的是Map类型的文本详细信息,
	 * map.get("accessory")得到的是List类型的附件信息
	 * @param documentId 文档Id
	 * @return 文档详细信息
	 * @throws Exception
	 */
	public Map<String,Object> getDocument(String documentId) throws Exception;
	/**
	 * 分页搜索文档
	 * @param departmentNo	部门编号（如果为null表示管理员进行查询，如果不为null表示部门人员进行查询）
	 * @param conditions	查询条件（文档名称、附件名称、创建者、创建时间（传两个值，起始时间和结束时间））
	 * @return 文档列表信息
	 * @throws Exception
	 */
	public List<Map<String,Object>> queryDocumentsByPage(String departmentNo,Map<String,String> conditions) throws Exception;
	/**
	 * 从回收站还原文档
	 * @param documentId 文档Id
	 * @throws Exception
	 */
	public void restoreDocument(String documentId) throws Exception;
	/**
	 * 分页获取回收站中的文档和附件，默认按时间排序
	 * @param departmentNo 部门编号
	 * @param condition  查询条件
	 * @throws Exception
	 */
	public void getTrashDocAndAccByPage(String departmentNo,String condition) throws Exception;
}
