package com.oa.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "role", catalog = "office_automation")
public class Role implements java.io.Serializable {

	// Fields

	private Integer roleId;
	private String roleNo;
	private String roleName;
	private Integer roleAuthorityValue;
	private String roleAuthorityDescribe;
	private String roleRemark;
	private Set<Login> logins = new HashSet<Login>(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String roleNo, String roleName, Integer roleAuthorityValue,
			String roleAuthorityDescribe) {
		this.roleNo = roleNo;
		this.roleName = roleName;
		this.roleAuthorityValue = roleAuthorityValue;
		this.roleAuthorityDescribe = roleAuthorityDescribe;
	}

	/** full constructor */
	public Role(String roleNo, String roleName, Integer roleAuthorityValue,
			String roleAuthorityDescribe, String roleRemark, Set<Login> logins) {
		this.roleNo = roleNo;
		this.roleName = roleName;
		this.roleAuthorityValue = roleAuthorityValue;
		this.roleAuthorityDescribe = roleAuthorityDescribe;
		this.roleRemark = roleRemark;
		this.logins = logins;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "role_id", unique = true, nullable = false)
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "role_no", nullable = false, length = 15)
	public String getRoleNo() {
		return this.roleNo;
	}

	public void setRoleNo(String roleNo) {
		this.roleNo = roleNo;
	}

	@Column(name = "role_name", nullable = false, length = 30)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "role_authority_value", nullable = false)
	public Integer getRoleAuthorityValue() {
		return this.roleAuthorityValue;
	}

	public void setRoleAuthorityValue(Integer roleAuthorityValue) {
		this.roleAuthorityValue = roleAuthorityValue;
	}

	@Column(name = "role_authority_describe", nullable = false)
	public String getRoleAuthorityDescribe() {
		return this.roleAuthorityDescribe;
	}

	public void setRoleAuthorityDescribe(String roleAuthorityDescribe) {
		this.roleAuthorityDescribe = roleAuthorityDescribe;
	}

	@Column(name = "role_remark")
	public String getRoleRemark() {
		return this.roleRemark;
	}

	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
	public Set<Login> getLogins() {
		return this.logins;
	}

	public void setLogins(Set<Login> logins) {
		this.logins = logins;
	}

}