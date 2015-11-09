package com.oa.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Document entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "document", catalog = "office_automation")
public class Document implements java.io.Serializable {

	// Fields

	private Integer documentId;
	private Document document;
	private User user;
	private Department department;
	private String documentProperty;
	private String documentName;
	private Timestamp documentCreateTime;
	private String documentPath;
	private Boolean documentStatus;
	private String documentRemark;
	private Set<Document> documents = new HashSet<Document>(0);
	private Set<Accessory> accessories = new HashSet<Accessory>(0);

	// Constructors

	/** default constructor */
	public Document() {
	}

	/** minimal constructor */
	public Document(String documentProperty, String documentName,
			Timestamp documentCreateTime, String documentPath,
			Boolean documentStatus) {
		this.documentProperty = documentProperty;
		this.documentName = documentName;
		this.documentCreateTime = documentCreateTime;
		this.documentPath = documentPath;
		this.documentStatus = documentStatus;
	}

	/** full constructor */
	public Document(Document document, User user, Department department,
			String documentProperty, String documentName,
			Timestamp documentCreateTime, String documentPath,
			Boolean documentStatus, String documentRemark,
			Set<Document> documents, Set<Accessory> accessories) {
		this.document = document;
		this.user = user;
		this.department = department;
		this.documentProperty = documentProperty;
		this.documentName = documentName;
		this.documentCreateTime = documentCreateTime;
		this.documentPath = documentPath;
		this.documentStatus = documentStatus;
		this.documentRemark = documentRemark;
		this.documents = documents;
		this.accessories = accessories;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "document_id", unique = true, nullable = false)
	public Integer getDocumentId() {
		return this.documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "document_parent")
	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "document_creater")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "document_department")
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(name = "document_property", nullable = false, length = 20)
	public String getDocumentProperty() {
		return this.documentProperty;
	}

	public void setDocumentProperty(String documentProperty) {
		this.documentProperty = documentProperty;
	}

	@Column(name = "document_name", nullable = false, length = 20)
	public String getDocumentName() {
		return this.documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	@Column(name = "document_create_time", nullable = false, length = 19)
	public Timestamp getDocumentCreateTime() {
		return this.documentCreateTime;
	}

	public void setDocumentCreateTime(Timestamp documentCreateTime) {
		this.documentCreateTime = documentCreateTime;
	}

	@Column(name = "document_path", nullable = false, length = 50)
	public String getDocumentPath() {
		return this.documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

	@Column(name = "document_status", nullable = false)
	public Boolean getDocumentStatus() {
		return this.documentStatus;
	}

	public void setDocumentStatus(Boolean documentStatus) {
		this.documentStatus = documentStatus;
	}

	@Column(name = "document_remark")
	public String getDocumentRemark() {
		return this.documentRemark;
	}

	public void setDocumentRemark(String documentRemark) {
		this.documentRemark = documentRemark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "document")
	public Set<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "document")
	public Set<Accessory> getAccessories() {
		return this.accessories;
	}

	public void setAccessories(Set<Accessory> accessories) {
		this.accessories = accessories;
	}

}