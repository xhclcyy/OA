package com.oa.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.oa.model.Document;
import com.oa.service.DocumentService;

@Controller
public class DocumentAction {
	private DocumentService document;

	@Autowired
	public void setDocument(DocumentService document) {
		this.document = document;
	}

	public void test() {
		System.out.println("caonima");
		try {
			document.createDocument(new Document());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
