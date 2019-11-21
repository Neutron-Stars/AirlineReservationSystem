package com.lti.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.AdminDao;
import com.lti.model.Admin;

public class AdminImplementationTest {

	private static ApplicationContext ctx;
	
	@BeforeClass
	public static void fact()
	{
		ctx=new ClassPathXmlApplicationContext("sp-config1.xml");
		System.out.println(ctx);
	}
	
	AdminDao adao=ctx.getBean(AdminDao.class);
	
	
	@Test
	public void adminAddTest() {
		Admin admin=new Admin();
		admin.setAdminName("Admin");
		admin.setAdminPassword("root");
		
		assertTrue(adao.addAdmin(admin));
		
	}

}
