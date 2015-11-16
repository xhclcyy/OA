package com.oa.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.oa.model.Department;
import com.oa.model.Login;
import com.oa.service.AccountService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
public class LoginAction extends ActionSupport implements ModelDriven<Login> {
	private static final long serialVersionUID = 1L;
	private Login login;
	private String userAccount;
	private String password;
	private String checkCode;
	private AccountService accountService;
	private String departmentNo;
	private int roleAuthorityValue;
	private String hint;
	private Map<String,Object> session;  
	@Override
	public Login getModel() {
		if (login == null)
			login = new Login();
		return login;
	}

	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public String login() {
		session = ActionContext.getContext().getSession();
		String kaptchaExpected = (String)session.get(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);  
		session.remove(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);  
		if(!kaptchaExpected.equals(checkCode)){
			hint="验证码输入错误";
			return INPUT;
		}
		login = accountService.login(userAccount, password);
		if (login != null) {
			Department department = login.getDepartment();
			departmentNo = null;
			if (department != null)
				departmentNo = department.getDepartmentNo();
			roleAuthorityValue = login.getRole().getRoleAuthorityValue();
			session.put("account", login.getLoginUserNo());
			session.put("departmentNo", departmentNo);
			session.put("roleAuthorityValue", roleAuthorityValue);
			if (login.getLoginStatus() == false) {
				updateLogin(login);
				return SUCCESS;
			} else if(login.getLoginRecentlyIp().equals( ServletActionContext.getRequest().getRemoteAddr())){
				hint="2";
			}else{
				hint = "1";
			}
		} else {
			hint = "账号或密码错误，请重新输入";
		}
		return INPUT;
	}
	private void updateLogin(Login login) {
		String ip = ServletActionContext.getRequest().getRemoteAddr();
		login.setLoginRecentlyIp(ip);
		login.setLoginStatus(true);
		accountService.update(login);
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartmentNo() {
		return departmentNo;
	}

	public int getRoleAuthorityValue() {
		return roleAuthorityValue;
	}

	public String getHint() {
		return hint;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
}
