package com.lti.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.FareMasterDao;
import com.lti.dao.FleetMasterDao;
import com.lti.model.FleetMaster;

public class FleetMasterImplementationTest {

	private static ApplicationContext ctx;
	@BeforeClass
	public static void fact()
	{
		ctx=new ClassPathXmlApplicationContext("sp-config.xml");
		System.out.println(ctx);
	}
	FleetMasterDao fdao=ctx.getBean(FleetMasterDao.class);
	@Test
	public void test() {
		
		
		FleetMaster fleetMaster = new FleetMaster();
		fleetMaster.setFleetMasterId(6);
		fleetMaster.setCode("A1004");
		fleetMaster.setModel("Z1004");
		fleetMaster.setTotalBusinessSeats(80);
		fleetMaster.setTotalPremiumSeats(100);
		fleetMaster.setTotalEconomySeats(70);
		assertTrue(fdao.createFleet(fleetMaster));
	}

}
