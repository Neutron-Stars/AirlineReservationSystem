package com.lti.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lti.model.FlightMaster;
import com.lti.model.LocationMaster;
import com.lti.service.AdminService;
import com.lti.service.FlightService;
import com.lti.service.FlightServiceImplementation;

@Controller
public class FlightController {

	@Autowired
	private AdminService aservice;
	
	@Autowired
	private FlightService fservice=new FlightServiceImplementation();
	
	@RequestMapping("/flightList")
	public ModelAndView flightlists(HttpServletRequest req)
	{
		try {
		String source=req.getParameter("source");
		String destination=req.getParameter("destination");
	/*	String date=req.getParameter("dateOfJourney");*/
		
		
		SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
		Date date2=formatter1.parse(req.getParameter("dateOfJourney"));
		
		int src=Integer.parseInt(source);
		int dest=Integer.parseInt(destination);
		/*Date dt=Date.valueOf(date);*/
		System.out.println(req.getRequestURI()+"?"+req.getQueryString());
		
		List<FlightMaster> list=fservice.getSearchDetails(src, dest, date2);
		
		for(FlightMaster f:list)
			System.out.println(f.getFlightId()+" "+f.getArrivalTime());
		
		if(list.size()>0)
			return new ModelAndView("flightList","lists",list);
		
		else
			return new ModelAndView("noResult");
		}
		catch(ParseException e)
		{
			e.printStackTrace();
			return new ModelAndView("noResult");
		}
		
	}
	
	
	@RequestMapping("/navigation")
	public ModelAndView flight(HttpServletRequest request)
	{
		ModelAndView model=new ModelAndView("navigation");
		List<LocationMaster> list=new ArrayList<LocationMaster>();
		list=aservice.getAllLocationDetail();
		System.out.println(request.getContextPath());
		System.out.println(request.getRequestURI());
		for(LocationMaster aa:list)
		{
			String name=aa.getAirportName()+"("+aa.getCode()+")";
			int id=aa.getLocationMasterId();
			System.out.println(id+" "+name);
		}

		return new ModelAndView("navigation","total",list);
	}
	
	@RequestMapping("/bookflight")
	 public ModelAndView bookTicket(HttpServletRequest req)
	 {
		 String flightId=req.getParameter("flightId");
		 int id=Integer.parseInt(flightId);
		 
		 FlightMaster f=fservice.getFlightForDisplay(id);
		 
		 System.out.println(req.getRequestURI());
		 return new ModelAndView("ticketForm","flight",f);
	 }
}
