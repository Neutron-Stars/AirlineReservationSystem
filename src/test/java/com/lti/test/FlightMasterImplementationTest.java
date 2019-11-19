package com.lti.test;

import static org.junit.Assert.*;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.FlightMasterDao;
import com.lti.dao.GenericDao;
import com.lti.dao.Implementation.FlightMasterImplementation;
import com.lti.model.AddressDetail;
import com.lti.model.FareMaster;
import com.lti.model.FleetMaster;
import com.lti.model.FlightMaster;
import com.lti.model.LocationMaster;
import com.lti.model.Person;

public class FlightMasterImplementationTest {

	private static ApplicationContext ctx;
	
	@PersistenceContext
	private EntityManager em;

	
	
	
	@BeforeClass
	public static void fact()
	{
		ctx=new ClassPathXmlApplicationContext("sp-config1.xml");
		System.out.println(ctx);
	}
	
	FlightMasterDao fdao=ctx.getBean(FlightMasterDao.class);
	
	
	@Test
	public void test() {
		
	GenericDao dao=new GenericDao();
		 LocationMaster loc=(LocationMaster)dao.Genericfetch(LocationMaster.class, 1239);
//	 LocationMaster loc=em.find(LocationMaster.class,1252);
		System.out.println(loc);
	System.out.println("Hit occured");
	//LocationMaster loc=null;
	System.out.println("Hit2");
	
	
		
	
		
		 LocationMaster loc1=(LocationMaster)dao.Genericfetch(LocationMaster.class, 1240);
		System.out.println(loc1);
//		LocationMaster lm=(LocationMaster) sf.getCurrentSession().get(LocationMaster.class, 1239);
//		
//		LocationMaster locationMaster2=(LocationMaster) sf.getCurrentSession().get(LocationMaster.class, 1240);
//		System.out.println(locationMaster2);
		FareMaster fareMaster=(FareMaster)dao.Genericfetch(FareMaster.class, 12);
		System.out.println(fareMaster); 
		
		FleetMaster fleetMaster=(FleetMaster) dao.Genericfetch(FleetMaster.class, 6);
		System.out.println(fleetMaster);
		
		FlightMaster flightMaster = new FlightMaster();
		
		flightMaster.setLocationMaster1(loc);
		flightMaster.setLocationMaster2(loc1);
		flightMaster.setFleetMaster(fleetMaster);
		System.out.println(Time.valueOf("10:65:00"));
		flightMaster.setFlightTravelDate(java.sql.Date.valueOf("2019-11-19"));
//		flightMaster.setArrivalTime(java.sql.Time.valueOf("11:50:00"));
		flightMaster.setArrivalTime(LocalDateTime.of(2019, 11, 19, 11, 30));
		flightMaster.setDepartureTime(LocalDateTime.of(2019, 11, 19, 2, 00));
		flightMaster.setFareMaster(fareMaster);
		
		System.out.println("Hit 3");
		assertTrue(fdao.newFlight(flightMaster));
		
		
	}
	
	@Test
	public void searchFlight()
	{
		GenericDao dao=new GenericDao();
		 LocationMaster loc=(LocationMaster)dao.Genericfetch(LocationMaster.class, 1239);
		
		 LocationMaster loc1=(LocationMaster)dao.Genericfetch(LocationMaster.class, 1240);
		 
		 FlightMaster flight=(FlightMaster)dao.Genericfetch(FlightMaster.class, 4020);
		 
		 
		 
		List<FlightMaster> list=new ArrayList<FlightMaster>();
		list=fdao.searchFlight(loc, loc1, flight.getFlightTravelDate());
		
		for(FlightMaster add:list)
		{
			System.out.println(add.getFlightId()+" "+add.getArrivalTime()+" "+add.getDepartureTime());
		}
	}

}
