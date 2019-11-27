package com.lti.controller;

import static org.junit.Assert.assertTrue;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.dao.GenericDao;
import com.lti.model.Admin;
import com.lti.model.FareMaster;
import com.lti.model.FleetMaster;
import com.lti.model.FlightMaster;
import com.lti.model.LocationMaster;
import com.lti.model.Person;
import com.lti.service.AdminService;
import com.lti.service.PersonService;

@Controller
@SessionAttributes("admin")
public class AdminController {

	@Autowired
	@Resource(name="pservice")
	private PersonService pservice;
	
	@Autowired
	@Resource(name="aservice")
	private AdminService aservice;
	
	@Autowired
	private GenericDao dao;
	
	@RequestMapping("/checkAdmin")
	public String chechAdmin(@RequestParam("adminName") String adname,@RequestParam("adminPassword") String adpass,Map model,HttpSession session)
	{
		try
		{
			Admin ad=pservice.checkAdmin(adname, adpass);
			Admin ad1=pservice.checkAdmin(adname, adpass);
			model.put("admin",ad );
			
			System.out.println("saved Session");
			String message="Hello Sir :)";
			session.setAttribute("admin1", ad1);
			model.put("message", message);
			
			return "adminPage";
		}
		
	catch(RuntimeException e)
		{
			String message1="Please Enter Correct Credentials";
		 return "failedLogin";
		}
	}
	
	@RequestMapping("/admin_locationMaster")
	public String add(HttpServletRequest req,Map model)
	{
		
		String city_name=req.getParameter("cityName").trim();
		String code=req.getParameter("code").trim();
		String airportName=req.getParameter("airportName").trim();
		System.out.println(airportName);
		String country=req.getParameter("country").trim();
		System.out.println(country);
		try
		{
		/*if(validate(city_name,code,airportName,country))*/
			LocationMaster loc=new LocationMaster();
	
			System.out.println("hit 3");
			loc.setLocationMasterId(1840);
			loc.setCode(code);
			loc.setAirportName(airportName);
			loc.setCountry(country);
			loc.setName(city_name);
			if(aservice.addLocation(loc))
			{
				System.out.println("done");
			}
		
			String message="Location added Succesfully!!!";
			model.put("message", message);
			return "locSuccess";
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			String message="Location Addition Failure :(";
			model.put("message", message);
			return "locFailure";
		}
	}
	
	private boolean validate(String ...values ) {
		for(String data:values)
		{
			System.out.println("data: "+data);
			System.out.println(data.trim());
			if(data.trim().length()<4) {
				System.out.println("hit ok1");
				return false;
			}
		
		}
		System.out.println("hit ok2");
		return true;

	}
	
	@RequestMapping("/admin_flightMaster")
	private String addL(HttpServletRequest req,Map model)
	{
	
		try
		{
			List<Date> dates=new ArrayList<Date>();
			
			
			
			String str=req.getParameter("arrivalTime");
			LocalTime date=LocalTime.parse(str, DateTimeFormatter.ofPattern("HH:mm:ss"));
		
		
		String str1=req.getParameter("departureTime");
	LocalTime	date1= LocalTime.parse(str1, DateTimeFormatter.ofPattern("HH:mm:ss"));
		
//		SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
	
		/*Date date2=formatter1.parse(req.getParameter("flightTravelDate"));
		System.out.println(date2);
		Date date3=formatter1.parse(req.getParameter("flightEndDate"));
		System.out.println(date3);*/
		
		
		Integer depId=Integer.parseInt(req.getParameter("locationMaster1"));
		Integer arrId=Integer.parseInt(req.getParameter("locationMaster2"));
		Integer fleId=Integer.parseInt(req.getParameter("fleetMaster"));
		Integer farId=Integer.parseInt(req.getParameter("fareMaster"));
		LocationMaster depLoc=(LocationMaster)dao.Genericfetch(LocationMaster.class, depId);
		LocationMaster arrLoc=(LocationMaster)dao.Genericfetch(LocationMaster.class, arrId);
		FleetMaster fleet=(FleetMaster)dao.Genericfetch(FleetMaster.class, fleId);
		FareMaster fare=(FareMaster)dao.Genericfetch(FareMaster.class, farId);
		
		long interval = 24*1000 * 60 * 60;
	/*	long endTime =date3.getTime(); // create your endtime here, possibly using Calendar or Date
		long curTime = date2.getTime();*/
		
		/*System.out.println(endTime);
		System.out.println(curTime);
		
		while (curTime <= endTime) {
		    dates.add(new Date(curTime));
		    curTime += interval;
		}*/
	
		LocalDate stdate=LocalDate.parse(req.getParameter("flightTravelDate"));
		LocalDate enddate=LocalDate.parse(req.getParameter("flightEndDate"));
		
		List<LocalDate> localist=new ArrayList<LocalDate>();
		
		ZoneId def=ZoneId.systemDefault();
		
		FlightMaster flight=new FlightMaster();
	List<FlightMaster> list=new ArrayList<FlightMaster>();
	
	while(!stdate.isAfter(enddate))
	{
		localist.add(stdate);
		
		stdate=stdate.plusDays(1);
     	System.out.println(stdate);
		  
//		Date date3=Date.from(stdate.atStartOfDay(def).toInstant());
		
		flight.setArrivalTime(date);
		flight.setDepartureTime(date1);
		
	
		flight.setFlightTravelDate(stdate);

		flight.setFlightEndDate(enddate);
	
		
		flight.setLocationMaster1(arrLoc);
		flight.setLocationMaster2(depLoc);
		flight.setFleetMaster(fleet);
		flight.setFareMaster(fare);
		
		if(aservice.addFlight(flight))
			System.out.println("done");
		//list.add(flight);
		//System.out.println(list.size());
	}	
	
	
		
		String message="Flight added Succesfully!!!";
		model.put("message", message);
		return "fliSuccess";
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			String message="Flight addittion failure :(";
			model.put("message", message);
			return "fliFailure";
		}
	}

	@RequestMapping("/admin_flightDelete")
	private String deleteF(FlightMaster flight,Map model,@RequestParam("flightId")int flid)
	{
		try
		{
			if(aservice.deleteFlight(flight,flid))
			{
				System.out.println("done!!");
			}
			
			String message="Flight deleted Succesfully!!!";
			model.put("message", message);
			return "fdSuccess";
			
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			String message="Flight deletion failure:(";
			model.put("message", message);
			return "fdFailure";
		}
	}

	
	@RequestMapping("/adminFlightView")
	private String viewFlight(Map model,Model model1 )
	{
		String message="Here are the list of available flights";
		model.put("message", message);
		
		List<FlightMaster> get=aservice.getAllFlightDetail();
		model1.addAttribute("getlist", get);

		return "lookPage";
	}
	
	@RequestMapping("/logout1")
	public String logout(Map model,HttpServletRequest req)
	{
			System.out.println("logging out.....");
			HttpSession session=req.getSession();
			Admin admin=(Admin)session.getAttribute("admin1");
			System.out.println(admin.getAdminName());
			
		
			
			String message="You have Succesfully logged out Sir.";
			model.put("msg", message);
			model.put("admin1", admin);
			session.invalidate();
			
			return "adminLogin";
	}
}
	

