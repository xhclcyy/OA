package com.oa.tool;

import java.util.Date;

public class SessionContainer {
	private int loginId;
	private String loginUserNo;
	private String loginPassword;
	private String loginRecentlyIp;
	private String loginRemark;
	private Date loginDate;

	public String getLoginRemark() {
		return loginRemark;
	}

	public void setLoginRemark(String loginRemark) {
		this.loginRemark = loginRemark;
	}

	/**
	 * @return the loginId
	 */
	public int getLoginId() {
		return loginId;
	}

	/**
	 * @param loginId
	 *            the loginId to set
	 */
	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	/**
	 * @return the loginUserNo
	 */
	public String getLoginUserNo() {
		return loginUserNo;
	}

	/**
	 * @param loginUserNo
	 *            the loginUserNo to set
	 */
	public void setLoginUserNo(String loginUserNo) {
		this.loginUserNo = loginUserNo;
	}

	/**
	 * @return the loginPassword
	 */
	public String getLoginPassword() {
		return loginPassword;
	}

	/**
	 * @param loginPassword
	 *            the loginPassword to set
	 */
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	/**
	 * @return the loginRecentlyIp
	 */
	public String getLoginRecentlyIp() {
		return loginRecentlyIp;
	}

	/**
	 * @param loginRecentlyIp
	 *            the loginRecentlyIp to set
	 */
	public void setLoginRecentlyIp(String loginRecentlyIp) {
		this.loginRecentlyIp = loginRecentlyIp;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
}
