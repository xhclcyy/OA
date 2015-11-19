package com.oa.model;

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
 * Login entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "login", catalog = "office_automation")
public class Login implements java.io.Serializable {

	// Fields

	private Integer loginId;
	private Role role;
	private Department department;
	private String loginUserNo;
	private String loginPassword;
	private String loginRecentlyIp;
	private Boolean loginStatus;
	private String loginRemark;
	private String loginUserName;
	private Set<Document> documents = new HashSet<Document>(0);
	private Set<Accessory> accessories = new HashSet<Accessory>(0);

	// Constructors

	/** default constructor */
	public Login() {
	}

	/** minimal constructor */
	public Login(String loginUserNo, String loginPassword,
			String loginRecentlyIp, Boolean loginStatus, String loginUserName) {
		this.loginUserNo = loginUserNo;
		this.loginPassword = loginPassword;
		this.loginRecentlyIp = loginRecentlyIp;
		this.loginStatus = loginStatus;
		this.loginUserName = loginUserName;
	}

	/** full constructor */
	public Login(Role role, Department department, String loginUserNo,
			String loginPassword, String loginRecentlyIp, Boolean loginStatus,
			String loginRemark, String loginUserName, Set<Document> documents,
			Set<Accessory> accessories) {
		this.role = role;
		this.department = department;
		this.loginUserNo = loginUserNo;
		this.loginPassword = loginPassword;
		this.loginRecentlyIp = loginRecentlyIp;
		this.loginStatus = loginStatus;
		this.loginRemark = loginRemark;
		this.loginUserName = loginUserName;
		this.documents = documents;
		this.accessories = accessories;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "login_id", unique = true, nullable = false)
	public Integer getLoginId() {
		return this.loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "login_role_id")
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "login_department_id")
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(name = "login_user_no", nullable = false, length = 15)
	public String getLoginUserNo() {
		return this.loginUserNo;
	}

	public void setLoginUserNo(String loginUserNo) {
		this.loginUserNo = loginUserNo;
	}

	@Column(name = "login_password", nullable = false, length = 20)
	public String getLoginPassword() {
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Column(name = "login_recently_ip", nullable = false, length = 30)
	public String getLoginRecentlyIp() {
		return this.loginRecentlyIp;
	}

	public void setLoginRecentlyIp(String loginRecentlyIp) {
		this.loginRecentlyIp = loginRecentlyIp;
	}

	@Column(name = "login_status", nullable = false)
	public Boolean getLoginStatus() {
		return this.loginStatus;
	}

	public void setLoginStatus(Boolean loginStatus) {
		this.loginStatus = loginStatus;
	}

	@Column(name = "login_remark")
	public String getLoginRemark() {
		return this.loginRemark;
	}

	public void setLoginRemark(String loginRemark) {
		this.loginRemark = loginRemark;
	}

	@Column(name = "login_user_name", nullable = false, length = 30)
	public String getLoginUserName() {
		return this.loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "login")
	public Set<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "login")
	public Set<Accessory> getAccessories() {
		return this.accessories;
	}

	public void setAccessories(Set<Accessory> accessories) {
		this.accessories = accessories;
	}

}