package com.oa.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface InterfaceLogin {
	public Map<String, Object> checkVerificationCode(String verificationCode,
			HttpSession session);

	public void checkLogin(String loginUserNo, String loginPassword,
			String verificationCode, HttpServletRequest request,
			HttpServletResponse response, HttpSession session);

}
