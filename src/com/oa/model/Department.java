package com.oa.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "department", catalog = "office_automation")
public class Department implements java.io.Serializable {

	// Fields

	private Integer departmentId;
	private User user;
	private String departmentNo;
	private Integer departmentPopulation;
	private String departmentName;
	private Date departmentCreatTime;
	private String departmentRemark;
	private Set<Login> logins = new HashSet<Login>(0);
	private Set<Document> documents = new HashSet<Document>(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(String departmentNo, Integer departmentPopulation,
			String departmentName, Date departmentCreatTime) {
		this.departmentNo = departmentNo;
		this.departmentPopulation = departmentPopulation;
		this.departmentName = departmentName;
		this.departmentCreatTime = departmentCreatTime;
	}

	/** full constructor */
	public Department(User user, String departmentNo,
			Integer departmentPopulation, String departmentName,
			Date departmentCreatTime, String departmentRemark,
			Set<Login> logins, Set<Document> documents) {
		this.user = user;
		this.departmentNo = departmentNo;
		this.departmentPopulation = departmentPopulation;
		this.departmentName = departmentName;
		this.departmentCreatTime = departmentCreatTime;
		this.departmentRemark = departmentRemark;
		this.logins = logins;
		this.documents = documents;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "department_id", unique = true, nullable = false)
	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_manager")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "department_no", nullable = false, length = 15)
	public String getDepartmentNo() {
		return this.departmentNo;
	}

	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}

	@Column(name = "department_population", nullable = false)
	public Integer getDepartmentPopulation() {
		return this.departmentPopulation;
	}

	public void setDepartmentPopulation(Integer departmentPopulation) {
		this.departmentPopulation = departmentPopulation;
	}

	@Column(name = "department_name", nullable = false, length = 30)
	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "department_creat_time", nullable = false, length = 10)
	public Date getDepartmentCreatTime() {
		return this.departmentCreatTime;
	}

	public void setDepartmentCreatTime(Date departmentCreatTime) {
		this.departmentCreatTime = departmentCreatTime;
	}

	@Column(name = "department_remark")
	public String getDepartmentRemark() {
		return this.departmentRemark;
	}

	public void setDepartmentRemark(String departmentRemark) {
		this.departmentRemark = departmentRemark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Login> getLogins() {
		return this.logins;
	}

	public void setLogins(Set<Login> logins) {
		this.logins = logins;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

}