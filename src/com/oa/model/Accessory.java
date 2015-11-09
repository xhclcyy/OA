package com.oa.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Accessory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "accessory", catalog = "office_automation")
public class Accessory implements java.io.Serializable {

	// Fields

	private Integer accessoryId;
	private Document document;
	private User user;
	private String accessoryName;
	private String accessoryProperty;
	private String accessoryPath;
	private Timestamp accessoryCreateTime;
	private Boolean accessoryStatus;
	private String accessoryRemark;

	// Constructors

	/** default constructor */
	public Accessory() {
	}

	/** minimal constructor */
	public Accessory(Document document, String accessoryName,
			String accessoryProperty, String accessoryPath,
			Timestamp accessoryCreateTime, Boolean accessoryStatus) {
		this.document = document;
		this.accessoryName = accessoryName;
		this.accessoryProperty = accessoryProperty;
		this.accessoryPath = accessoryPath;
		this.accessoryCreateTime = accessoryCreateTime;
		this.accessoryStatus = accessoryStatus;
	}

	/** full constructor */
	public Accessory(Document document, User user, String accessoryName,
			String accessoryProperty, String accessoryPath,
			Timestamp accessoryCreateTime, Boolean accessoryStatus,
			String accessoryRemark) {
		this.document = document;
		this.user = user;
		this.accessoryName = accessoryName;
		this.accessoryProperty = accessoryProperty;
		this.accessoryPath = accessoryPath;
		this.accessoryCreateTime = accessoryCreateTime;
		this.accessoryStatus = accessoryStatus;
		this.accessoryRemark = accessoryRemark;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "accessory_id", unique = true, nullable = false)
	public Integer getAccessoryId() {
		return this.accessoryId;
	}

	public void setAccessoryId(Integer accessoryId) {
		this.accessoryId = accessoryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accessory_document_id", nullable = false)
	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "accessory_creater")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "accessory_name", nullable = false, length = 30)
	public String getAccessoryName() {
		return this.accessoryName;
	}

	public void setAccessoryName(String accessoryName) {
		this.accessoryName = accessoryName;
	}

	@Column(name = "accessory_property", nullable = false, length = 20)
	public String getAccessoryProperty() {
		return this.accessoryProperty;
	}

	public void setAccessoryProperty(String accessoryProperty) {
		this.accessoryProperty = accessoryProperty;
	}

	@Column(name = "accessory_path", nullable = false, length = 50)
	public String getAccessoryPath() {
		return this.accessoryPath;
	}

	public void setAccessoryPath(String accessoryPath) {
		this.accessoryPath = accessoryPath;
	}

	@Column(name = "accessory_create_time", nullable = false, length = 19)
	public Timestamp getAccessoryCreateTime() {
		return this.accessoryCreateTime;
	}

	public void setAccessoryCreateTime(Timestamp accessoryCreateTime) {
		this.accessoryCreateTime = accessoryCreateTime;
	}

	@Column(name = "accessory_status", nullable = false)
	public Boolean getAccessoryStatus() {
		return this.accessoryStatus;
	}

	public void setAccessoryStatus(Boolean accessoryStatus) {
		this.accessoryStatus = accessoryStatus;
	}

	@Column(name = "accessory_remark")
	public String getAccessoryRemark() {
		return this.accessoryRemark;
	}

	public void setAccessoryRemark(String accessoryRemark) {
		this.accessoryRemark = accessoryRemark;
	}

}