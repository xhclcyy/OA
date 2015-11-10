package com.oa.test;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UnitTestBase {

	private ClassPathXmlApplicationContext context;

	private String springXmlpath;

	public UnitTestBase() {
		System.out.println("空的构造方法，不传染配置文件名");
	}

	public UnitTestBase(String springXmlpath) {
		System.out.println("非空构造方法，传入配置文件名");
		this.springXmlpath = springXmlpath;
	}

	@Before
	public void before() {
		System.out.println("before");
		if (springXmlpath == null || springXmlpath.isEmpty()) {
			springXmlpath = "classpath*:application*.xml";
		}
		try {
			context = new ClassPathXmlApplicationContext(
					springXmlpath.split("[,\\s]+"));
			context.start();
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

	@After
	public void after() {
		System.out.println("after");
		context.destroy();
	}

	@SuppressWarnings("unchecked")
	protected <T extends Object> T getBean(String beanId) {
		System.out.println("getBean(String beanId)");
		try {
			return (T) context.getBean(beanId);
		} catch (BeansException e) {
			e.printStackTrace();
			return null;
		}
	}

	protected <T extends Object> T getBean(Class<T> clazz) {
		System.out.println("getBean(Class<T> clazz)");
		try {
			return context.getBean(clazz);
		} catch (BeansException e) {
			e.printStackTrace();
			return null;
		}
	}

}
