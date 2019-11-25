package com.lti.test;

import static org.junit.Assert.*;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.Dao1;
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

	/*@Autowired
	private GenericDao dao;*/
	
	
	@BeforeClass
	public static void fact()
	{
		ctx=new ClassPathXmlApplicationContext("sp-config1.xml");
		System.out.println(ctx);
	}
	
	FlightMasterDao fdao=ctx.getBean(FlightMasterDao.class);
	
	
	@Test
	public void test() {
		
Dao1 dao=new Dao1();
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
		flightMaster.setFlightEndDate(java.sql.Date.valueOf("2019-11-19"));
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
		Dao1 dao=new Dao1();
		 LocationMaster loc=(LocationMaster)dao.Genericfetch(LocationMaster.class, 1239);
		 System.out.println(loc);
		
		 LocationMaster loc1=(LocationMaster)dao.Genericfetch(LocationMaster.class, 1240);
		 
		 FlightMaster flight=(FlightMaster)dao.Genericfetch(FlightMaster.class, 4020);
		 
		 
		 
		List<FlightMaster> list=new ArrayList<FlightMaster>();
		list=fdao.searchFlight(loc, loc1, (java.sql.Date)flight.getFlightTravelDate());
		
		for(FlightMaster add:list)
		{
			System.out.println(add.getFlightId()+" "+add.getArrivalTime()+" "+add.getDepartureTime());
		}
	}
	
	@Test
	public void getAllFlight()
	{
		List<FlightMaster> list1=fdao.getAll();
		for(FlightMaster a:list1)
		{
			System.out.println(a.getFlightId()+" "+a.getArrivalTime()+" "+a.getFareMaster().getEconomyClass());
		}
	}
	
	@Test
	public void displayDatesTest()
	{
		FlightMaster flight=new FlightMaster();
		String s1="2014-05-01";
		String s2="2014-05-30";
		
		LocalDate startdate=LocalDate.parse(s1);
		LocalDate enddate1=LocalDate.parse(s2);
		
		List<LocalDate> totdates=new ArrayList<LocalDate>();
		while(!startdate.isAfter(enddate1))
		{
			totdates.add(startdate);
			startdate=startdate.plusDays(1);
			System.out.println(startdate);
		}
	}
		
		@Test
		public void displayDatesInTest()
		{
			FlightMaster flight=new FlightMaster();
			String s1="2014-05-01";
			String s2="2014-05-30";
			
			try
			{
			SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
			Date stdate=formatter1.parse(s1);
			Date enddate=formatter1.parse(s2);
			
			List<Date> dates=new ArrayList<Date>();
			Calendar calendar=new GregorianCalendar();
			calendar.setTime(stdate);
			
			while(calendar.getTime().before(enddate))
			{
				Date result=calendar.getTime();
				dates.add(result);
				calendar.add(Calendar.DATE,1 );
			}
			
			System.out.println(dates);

			}
			
			catch(ParseException e)
			{
				e.printStackTrace();
			}
		
	}
		
		@Test
		public void testDatesBetween()
		{
			List<Date> dates = new ArrayList<Date>();

			String str_date ="12/10/2010";
			String end_date ="16/10/2010";

			try
			{
			SimpleDateFormat formatter ; 

			formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date  startDate = (Date)formatter.parse(str_date); 
			Date  endDate = (Date)formatter.parse(end_date);
			long interval = 24*1000 * 60 * 60; // 1 hour in millis
			long endTime =endDate.getTime() ; // create your endtime here, possibly using Calendar or Date
			long curTime = startDate.getTime();
			while (curTime <= endTime) {
			    dates.add(new Date(curTime));
			    curTime += interval;
			}
			for(int i=0;i<dates.size();i++){
			    Date lDate =(Date)dates.get(i);
			    String ds = formatter.format(lDate);    
			    System.out.println(" Date is ..." + ds);
			}
			}
			
			catch(ParseException e)
			{
				e.printStackTrace();
			}
		}

}
