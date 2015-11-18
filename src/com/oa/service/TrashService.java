package com.oa.service;

import java.util.List;

import com.oa.model.Trash;

public interface TrashService {
	/**
	 * 添加垃圾
	 * 
	 * @param trash
	 *            垃圾对象
	 */
	void addTrash(Trash trash);

	/**
	 * 删除垃圾
	 * 
	 * @param trashId
	 *            垃圾id
	 */
	void deleteTrash(String trashId);

	/**
	 * 删除垃圾
	 * 
	 * @param trashDocOrAccId
	 *            文档或附件id
	 * @param trashDocOrAcc
	 *            true表示文档，false表示附件
	 */
	void deleteTrashByDocOrAccId(int trashDocOrAccId, boolean trashDocOrAcc);

	/**
	 * 清空回收站（批量删除文档和附件），如果departmentNo为null表示管理员操作，会清空 所有部门的回收站
	 * 
	 * @param departmentNo
	 *            部门编号
	 */
	void emptyTrash(String departmentNo);

	/**
	 * 获取所有垃圾对象（管理员）
	 * 
	 * @return 垃圾对象列表
	 */
	List<Trash> getTrashs();

	/**
	 * 获取垃圾对象列表（员工、部门经理、管理员）
	 * 
	 * @param departmentNo
	 *            部门编号
	 * @return 垃圾对象列表
	 */
	List<Trash> getTrashsByDepartmentNo(String departmentNo);
}
