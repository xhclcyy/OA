package com.oa.test;

import org.junit.Test;

import com.oa.model.Document;
import com.oa.model.Login;
import com.oa.service.AccountService;
import com.oa.service.DocumentService;

public class TestAccountService extends UnitTestBase {
	public TestAccountService() {
		super("classpath:applicationContext.xml");
	}

	@Test
	public void testLogin() throws Exception {
		AccountService document = getBean("accountServiceImpl");
		System.out.println(document.login("admin", "123456"));
	}

	public void testGetLogin() {
		try {
			AccountService document = getBean("accountServiceImpl");

			Login login = document.getLogin("admin");
			System.out.println(login.getLoginPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
