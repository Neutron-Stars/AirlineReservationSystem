package com.lti.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.FareMasterDao;
import com.lti.model.FareMaster;

public class FareMasterImplementationTest {

	
	private static ApplicationContext ctx;
	
	
	@BeforeClass
	public static void fact()
	{
		ctx=new ClassPathXmlApplicationContext("sp-config.xml");
		System.out.println(ctx);
	}
	FareMasterDao faremas=ctx.getBean(FareMasterDao.class);
	@Test
	public void test() {
		FareMaster fare=new FareMaster();
		
		   fare.setFareMasterId(12);
	        fare.setEconomyClass(110);
	        fare.setBusinessClass(300);
	        fare.setPremiumClass(500);
	        
	        assertTrue(faremas.newFare(fare));
	}

}
