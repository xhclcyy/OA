package com.oa.test;

import org.junit.Test;

import com.oa.model.Document;
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
}
