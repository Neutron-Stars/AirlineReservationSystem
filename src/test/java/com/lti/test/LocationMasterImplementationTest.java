package com.lti.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.LocationMasterDao;
import com.lti.model.LocationMaster;

public class LocationMasterImplementationTest {

private static ApplicationContext ctx;
	
	@BeforeClass
	public static void fact()
	{
		ctx=new ClassPathXmlApplicationContext("sp-config1.xml");
		System.out.println(ctx);
	}
	
	LocationMasterDao locationMasterDAO =ctx.getBean(LocationMasterDao.class);
	
	@Test
	public void test() {
		
		LocationMaster locationMaster=new LocationMaster();
		locationMaster.setLocationMasterId(1250);
		locationMaster.setName("Delhi");
		locationMaster.setCode("In");
		locationMaster.setCountry("India");
		locationMaster.setAirportName("DIA");
		assertTrue(locationMasterDAO.createLocation(locationMaster));
		System.out.println(locationMasterDAO);
	}

}
