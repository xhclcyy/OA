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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "office_automation")
public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userNo;
	private String userName;
	private String userPicture;
	private Integer userAge;
	private Boolean userSex;
	private String userAddress;
	private String userEmail;
	private String userPhone;
	private String userTelphone;
	private Date userHiredate;
	private String userOfficeAddress;
	private String userOfficePhone;
	private String userNation;
	private String userNativePlace;
	private Date userBirthday;
	private String userPoliticsStatus;
	private String userMaritalStatus;
	private String userRemark;
	private Set<Login> logins = new HashSet<Login>(0);
	private Set<Department> departments = new HashSet<Department>(0);
	private Set<Document> documents = new HashSet<Document>(0);
	private Set<Log> logs = new HashSet<Log>(0);
	private Set<Accessory> accessories = new HashSet<Accessory>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userNo, String userName, String userPicture,
			Integer userAge, Boolean userSex, String userAddress,
			String userEmail, String userPhone, Date userHiredate,
			String userOfficeAddress, String userOfficePhone,
			String userNation, String userNativePlace, Date userBirthday,
			String userPoliticsStatus, String userMaritalStatus) {
		this.userNo = userNo;
		this.userName = userName;
		this.userPicture = userPicture;
		this.userAge = userAge;
		this.userSex = userSex;
		this.userAddress = userAddress;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userHiredate = userHiredate;
		this.userOfficeAddress = userOfficeAddress;
		this.userOfficePhone = userOfficePhone;
		this.userNation = userNation;
		this.userNativePlace = userNativePlace;
		this.userBirthday = userBirthday;
		this.userPoliticsStatus = userPoliticsStatus;
		this.userMaritalStatus = userMaritalStatus;
	}

	/** full constructor */
	public User(String userNo, String userName, String userPicture,
			Integer userAge, Boolean userSex, String userAddress,
			String userEmail, String userPhone, String userTelphone,
			Date userHiredate, String userOfficeAddress,
			String userOfficePhone, String userNation, String userNativePlace,
			Date userBirthday, String userPoliticsStatus,
			String userMaritalStatus, String userRemark, Set<Login> logins,
			Set<Department> departments, Set<Document> documents,
			Set<Log> logs, Set<Accessory> accessories) {
		this.userNo = userNo;
		this.userName = userName;
		this.userPicture = userPicture;
		this.userAge = userAge;
		this.userSex = userSex;
		this.userAddress = userAddress;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userTelphone = userTelphone;
		this.userHiredate = userHiredate;
		this.userOfficeAddress = userOfficeAddress;
		this.userOfficePhone = userOfficePhone;
		this.userNation = userNation;
		this.userNativePlace = userNativePlace;
		this.userBirthday = userBirthday;
		this.userPoliticsStatus = userPoliticsStatus;
		this.userMaritalStatus = userMaritalStatus;
		this.userRemark = userRemark;
		this.logins = logins;
		this.departments = departments;
		this.documents = documents;
		this.logs = logs;
		this.accessories = accessories;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "user_no", nullable = false, length = 15)
	public String getUserNo() {
		return this.userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	@Column(name = "user_name", nullable = false, length = 30)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_picture", nullable = false, length = 50)
	public String getUserPicture() {
		return this.userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
	}

	@Column(name = "user_age", nullable = false)
	public Integer getUserAge() {
		return this.userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	@Column(name = "user_sex", nullable = false)
	public Boolean getUserSex() {
		return this.userSex;
	}

	public void setUserSex(Boolean userSex) {
		this.userSex = userSex;
	}

	@Column(name = "user_address", nullable = false, length = 50)
	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	@Column(name = "user_email", nullable = false, length = 30)
	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Column(name = "user_phone", nullable = false, length = 15)
	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Column(name = "user_telphone", length = 15)
	public String getUserTelphone() {
		return this.userTelphone;
	}

	public void setUserTelphone(String userTelphone) {
		this.userTelphone = userTelphone;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "user_hiredate", nullable = false, length = 10)
	public Date getUserHiredate() {
		return this.userHiredate;
	}

	public void setUserHiredate(Date userHiredate) {
		this.userHiredate = userHiredate;
	}

	@Column(name = "user_office_address", nullable = false, length = 30)
	public String getUserOfficeAddress() {
		return this.userOfficeAddress;
	}

	public void setUserOfficeAddress(String userOfficeAddress) {
		this.userOfficeAddress = userOfficeAddress;
	}

	@Column(name = "user_office_phone", nullable = false, length = 15)
	public String getUserOfficePhone() {
		return this.userOfficePhone;
	}

	public void setUserOfficePhone(String userOfficePhone) {
		this.userOfficePhone = userOfficePhone;
	}

	@Column(name = "user_nation", nullable = false, length = 20)
	public String getUserNation() {
		return this.userNation;
	}

	public void setUserNation(String userNation) {
		this.userNation = userNation;
	}

	@Column(name = "user_native_place", nullable = false, length = 20)
	public String getUserNativePlace() {
		return this.userNativePlace;
	}

	public void setUserNativePlace(String userNativePlace) {
		this.userNativePlace = userNativePlace;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "user_birthday", nullable = false, length = 10)
	public Date getUserBirthday() {
		return this.userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	@Column(name = "user_politics_status", nullable = false, length = 20)
	public String getUserPoliticsStatus() {
		return this.userPoliticsStatus;
	}

	public void setUserPoliticsStatus(String userPoliticsStatus) {
		this.userPoliticsStatus = userPoliticsStatus;
	}

	@Column(name = "user_marital_status", nullable = false, length = 10)
	public String getUserMaritalStatus() {
		return this.userMaritalStatus;
	}

	public void setUserMaritalStatus(String userMaritalStatus) {
		this.userMaritalStatus = userMaritalStatus;
	}

	@Column(name = "user_remark")
	public String getUserRemark() {
		return this.userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Login> getLogins() {
		return this.logins;
	}

	public void setLogins(Set<Login> logins) {
		this.logins = logins;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Department> getDepartments() {
		return this.departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Log> getLogs() {
		return this.logs;
	}

	public void setLogs(Set<Log> logs) {
		this.logs = logs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Accessory> getAccessories() {
		return this.accessories;
	}

	public void setAccessories(Set<Accessory> accessories) {
		this.accessories = accessories;
	}

}