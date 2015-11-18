package com.oa.test;

import java.sql.Timestamp;

import org.junit.Test;

import com.oa.model.Accessory;
import com.oa.model.Document;
import com.oa.model.User;
import com.oa.service.AccessoryService;

public class TestAccessoryService extends UnitTestBase {
	AccessoryService service;
	public TestAccessoryService(){
		super("classpath:applicationContext.xml");
		
	}
	@Test
	public void testUploadAccessory(){
		service=getBean("accessoryServiceImpl");
		Accessory accessory=new Accessory();
		accessory.setAccessoryName("常量");
		accessory.setAccessoryProperty("文本文档");
		accessory.setAccessoryPath("file/accessory/a2");
		User user=new User();
		user.setUserId(1);
		accessory.setUser(user);
		accessory.setAccessoryStatus(true);
		accessory.setAccessoryCreateTime(new Timestamp(System.currentTimeMillis()));
		Document document=new Document();
		document.setDocumentId(1);
		accessory.setDocument(document);
		try{
		service.uploadAccessory(accessory);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void testDeleteAccessory(){
		service=getBean("accessoryServiceImpl");
		try{
		service.deleteAccessory("1");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
