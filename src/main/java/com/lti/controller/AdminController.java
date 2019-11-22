package com.lti.controller;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Map;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.dao.GenericDao;
import com.lti.model.Admin;
import com.lti.model.FareMaster;
import com.lti.model.FleetMaster;
import com.lti.model.FlightMaster;
import com.lti.model.LocationMaster;
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
	
	@RequestMapping("/checkAdmin")
	public String chechAdmin(@RequestParam("adminName") String adname,@RequestParam("adminPassword") String adpass,Map model)
	{
		try
		{
			Admin ad=pservice.checkAdmin(adname, adpass);
			model.put("admin",ad );
			
			System.out.println("saved Session");
			String message="Hello Sir :)";
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
			loc.setLocationMasterId(1643);
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
	private String addL(FlightMaster flight,Map model,@RequestParam("arrivalTime") String ar,
			@RequestParam("departureTime")String dp,
			@RequestParam("flightTravelDate")String fdate,
			@RequestParam("locationMasterId")Integer depId,
			@RequestParam("locationMasterId")Integer arrId,
			@RequestParam("fleetMasterId")Integer fleId,
			@RequestParam("fareMasterId")Integer farId)
	{
		try
		{
			/*String str=req.getParameter("arrivalTime");
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH);
		LocalDateTime date=LocalDateTime.parse(str, formatter);
		
		String str1=req.getParameter("departureTime");
		LocalDateTime date1=LocalDateTime.parse(str1, formatter);
		
	SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
		Date date2=formatter1.parse(req.getParameter("flightTravelDate"));
		
		
		Integer depId=Integer.parseInt(req.getParameter("locationMaster1"));
		Integer arrId=Integer.parseInt(req.getParameter("locationMaster2"));
		Integer fleId=Integer.parseInt(req.getParameter("fleetMaster"));
		Integer farId=Integer.parseInt(req.getParameter("fareMaster"));
		
		LocationMaster depLoc=(LocationMaster)dao.Genericfetch(LocationMaster.class, depId);
		LocationMaster arrLoc=(LocationMaster)dao.Genericfetch(LocationMaster.class, arrId);
		
		FleetMaster fleet=(FleetMaster)dao.Genericfetch(FleetMaster.class, fleId);
		
		FareMaster fare=(FareMaster)dao.Genericfetch(FareMaster.class, farId);*/

		

		/*flight.setArrivalTime(date);
		flight.setDepartureTime(date1);
		flight.setFlightTravelDate(date2);
		flight.setLocationMaster1(arrLoc);
		flight.setLocationMaster2(depLoc);
		flight.setFleetMaster(fleet);
		flight.setFareMaster(fare);*/
			
		
		if(aservice.addFlight(flight,ar,dp,fdate,depId,arrId,fleId,farId))
		{
			System.out.println("done");
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


}
	

