package com.oa.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.oa.model.Department;
import com.oa.model.Login;
import com.oa.service.AccountService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller
public class LoginAction extends ActionSupport implements ModelDriven<Login> {
	private static final long serialVersionUID = 1L;
	private Login login;
	private String userAccount;
	private String password;
	private AccountService accountService;
	private String departmentNo;
	private int roleAuthorityValue;
	private String hint;
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
	public String login(){
		login=accountService.login(userAccount, password);
		if(login!=null){
		Department department=login.getDepartment();
		departmentNo=null;
		if(department!=null)
			departmentNo=department.getDepartmentNo();
			roleAuthorityValue=login.getRole().getRoleAuthorityValue();
			updateLogin(login);
			if(login.getLoginStatus()==false){
		return SUCCESS;
		}else{
			hint="1";
		}
		}else{
			hint="账号或密码错误，请重新输入";
		}
		return INPUT;
	}
	public String reLogin(){
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		return SUCCESS;
	}
	private void updateLogin(Login login){
		String ip=ServletActionContext.getRequest().getRemoteAddr();
		System.out.println(ip);
		login.setLoginRecentlyIp(ip);
		login.setLoginStatus(true);
		try{
			System.out.println(login);
		accountService.update(login); 
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("update");
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
}
