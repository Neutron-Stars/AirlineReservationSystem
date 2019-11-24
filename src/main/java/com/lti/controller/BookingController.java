package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lti.model.Bookings;
import com.lti.model.FlightMaster;
import com.lti.model.Passengers;
import com.lti.model.Person;
import com.lti.service.AdminService;
import com.lti.service.BookingService;
import com.lti.service.FlightService;
import com.lti.service.PersonService;

@Controller
public class BookingController {

	@Autowired
	private AdminService aservice;
	
	@Autowired
	private PersonService pservice;
	
	@Autowired
	private FlightService fservice;
	
	@Autowired
	private BookingService bservice;
	
	/*@Autowired
	private BookingService bservice;*/
	
	List< Passengers> passengers =new ArrayList<Passengers>();
	Bookings book=new Bookings();
	
	@RequestMapping("/bookTicket")
	public void flight(HttpServletRequest req,HttpServletResponse res)
	{
		FlightMaster fligh=new FlightMaster();
		Passengers pass=new Passengers();
		Person per=new Person();
		
		per.setPersonId(1007);
		
		String flightid=req.getParameter("flightId");
		
		String classType=req.getParameter("classType");
		System.out.println(flightid);
		
		String s=req.getParameter("seat");
		int seat=Integer.parseInt(s);
		
		int flightId=Integer.parseInt(flightid);
		fligh.setFlightId(flightId);
		
		book.setBookingId(268943);
		book.setSeatClass(classType);
		book.setSeatsBooked(seat);
		book.setTravelDate(fligh.getFlightTravelDate());
		book.setBookingNumber("235454");
		
		int total=seat*fservice.getFare(flightId, classType);
		System.out.println(total);
		
		book.setTotalCost(total);
		book.setFlightMaster(fligh);
		for(int i=0;i<seat;i++)
		{
			String userName=req.getParameter("username"+i);
			String middleName=req.getParameter("middlename"+i);
			String lastName=req.getParameter("lastname"+i);
			String gender=req.getParameter("gender"+i);
			String mealPreferences=req.getParameter("meal"+i);
			String passengerType=req.getParameter("passengerType"+i);
			String age=req.getParameter("age"+i);
			String passportNumber=req.getParameter("passport"+i);
			
			pass.setPassengerId(6000+1);
			pass.setFirstName(userName);
			pass.setMiddleName(middleName);
			pass.setLastName(lastName);
			pass.setGender(gender);
			pass.setMealPreferences(mealPreferences);
			pass.setPassengerType(passengerType);
			pass.setPassportNumber(passportNumber);
			pass.setAge(Integer.parseInt(age));
			passengers.add(pass);
			
			try
			{
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("modeSelect");
			System.out.println(requestDispatcher);
			requestDispatcher.include(req, res);
			System.out.println(requestDispatcher);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
		
		@RequestMapping("modeSelect")
		public ModelAndView modeSelect(HttpServletRequest request,HttpServletResponse response)
		{
			System.out.println(request);
			return new ModelAndView("modeSelect");
		}
		
		@RequestMapping("payment")
		public ModelAndView pay(HttpServletRequest request,HttpServletResponse response)
		{
			return new ModelAndView("payment");
		}
		
		@RequestMapping("donePayment")
		public ModelAndView payed(HttpServletRequest request,HttpServletResponse response)
		{
			ModelAndView model=new ModelAndView("donePayment");
			System.out.println(model);
			model.addObject("passenger",passengers);
			model.addObject("booking",book);
			return model;
		}
		
		@RequestMapping("paymentFailure")
		public ModelAndView fail(HttpServletRequest request,HttpServletResponse response)
		{
			return new ModelAndView("modeSelect","msg","Payment Failed try again");
		}
		

		@RequestMapping("paymentPass")
		public ModelAndView succ(HttpServletRequest request,HttpServletResponse response)
		{

			if(bservice.bookTicket(book, passengers))
			{
				return new ModelAndView("successful","msg","from booking");
			}
			else
			{
				return new ModelAndView("unsuccessful");
			}
		}
		
	
}
