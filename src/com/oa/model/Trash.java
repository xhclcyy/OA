package com.oa.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Trash entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "trash", catalog = "office_automation")
public class Trash implements java.io.Serializable {

	// Fields

	private Integer trashId;
	private Integer trashDocOrAccId;
	private Boolean trashDocOrAcc;
	private String trashDocOrAccName;
	private Timestamp trashTime;
	private String trashDepartmentNo;
	private String trashUserNo;

	// Constructors

	/** default constructor */
	public Trash() {
	}

	/** full constructor */
	public Trash(Integer trashDocOrAccId, Boolean trashDocOrAcc,
			String trashDocOrAccName, Timestamp trashTime,
			String trashDepartmentNo, String trashUserNo) {
		this.trashDocOrAccId = trashDocOrAccId;
		this.trashDocOrAcc = trashDocOrAcc;
		this.trashDocOrAccName = trashDocOrAccName;
		this.trashTime = trashTime;
		this.trashDepartmentNo = trashDepartmentNo;
		this.trashUserNo = trashUserNo;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "trash_id", unique = true, nullable = false)
	public Integer getTrashId() {
		return this.trashId;
	}

	public void setTrashId(Integer trashId) {
		this.trashId = trashId;
	}

	@Column(name = "trash_docOrAcc_id", nullable = false)
	public Integer getTrashDocOrAccId() {
		return this.trashDocOrAccId;
	}

	public void setTrashDocOrAccId(Integer trashDocOrAccId) {
		this.trashDocOrAccId = trashDocOrAccId;
	}

	@Column(name = "trash_docOrAcc", nullable = false)
	public Boolean getTrashDocOrAcc() {
		return this.trashDocOrAcc;
	}

	public void setTrashDocOrAcc(Boolean trashDocOrAcc) {
		this.trashDocOrAcc = trashDocOrAcc;
	}

	@Column(name = "trash_docOrAcc_name", nullable = false, length = 30)
	public String getTrashDocOrAccName() {
		return this.trashDocOrAccName;
	}

	public void setTrashDocOrAccName(String trashDocOrAccName) {
		this.trashDocOrAccName = trashDocOrAccName;
	}

	@Column(name = "trash_time", nullable = false, length = 19)
	public Timestamp getTrashTime() {
		return this.trashTime;
	}

	public void setTrashTime(Timestamp trashTime) {
		this.trashTime = trashTime;
	}

	@Column(name = "trash_department_no", nullable = false, length = 15)
	public String getTrashDepartmentNo() {
		return this.trashDepartmentNo;
	}

	public void setTrashDepartmentNo(String trashDepartmentNo) {
		this.trashDepartmentNo = trashDepartmentNo;
	}

	@Column(name = "trash_user_no", nullable = false, length = 15)
	public String getTrashUserNo() {
		return this.trashUserNo;
	}

	public void setTrashUserNo(String trashUserNo) {
		this.trashUserNo = trashUserNo;
	}

}