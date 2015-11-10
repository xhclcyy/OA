package com.oa.test;

import org.junit.Test;

import com.oa.model.Document;
import com.oa.service.DocumentService;

public class TestDocumentService extends UnitTestBase {

	public TestDocumentService() {
		super("classpath:applicationContext.xml");
	}

	@Test
	public void testAdd() throws Exception {
		DocumentService document = getBean("documentServiceImpl");
		document.createDocument(new Document());
		System.out.println(document);
	}
}
