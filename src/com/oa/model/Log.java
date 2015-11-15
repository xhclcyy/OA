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
 * Log entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "log", catalog = "office_automation")
public class Log implements java.io.Serializable {

	// Fields

	private Integer logId;
	private User user;
	private Timestamp logTime;
	private String logIp;
	private String logContent;
	private String logRemark;

	// Constructors

	/** default constructor */
	public Log() {
	}

	/** minimal constructor */
	public Log(User user, Timestamp logTime, String logIp, String logContent) {
		this.user = user;
		this.logTime = logTime;
		this.logIp = logIp;
		this.logContent = logContent;
	}

	/** full constructor */
	public Log(User user, Timestamp logTime, String logIp, String logContent,
			String logRemark) {
		this.user = user;
		this.logTime = logTime;
		this.logIp = logIp;
		this.logContent = logContent;
		this.logRemark = logRemark;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "log_id", unique = true, nullable = false)
	public Integer getLogId() {
		return this.logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "log_user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "log_time", nullable = false, length = 19)
	public Timestamp getLogTime() {
		return this.logTime;
	}

	public void setLogTime(Timestamp logTime) {
		this.logTime = logTime;
	}

	@Column(name = "log_ip", nullable = false, length = 20)
	public String getLogIp() {
		return this.logIp;
	}

	public void setLogIp(String logIp) {
		this.logIp = logIp;
	}

	@Column(name = "log_content", nullable = false)
	public String getLogContent() {
		return this.logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	@Column(name = "log_remark")
	public String getLogRemark() {
		return this.logRemark;
	}

	public void setLogRemark(String logRemark) {
		this.logRemark = logRemark;
	}

}