package com.lti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lti.dao.GenericDao;
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
	
	@Autowired
	private GenericDao dao;
	
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
		
		int id=per.getPersonId();
		per=(Person)dao.Genericfetch(Person.class, id);
		
		String flightid=req.getParameter("flightId");
		
		String classType=req.getParameter("classType");
		System.out.println(flightid);
		
		String s=req.getParameter("seat");
		int seat=Integer.parseInt(s);
		
		int flightId=Integer.parseInt(flightid);
		fligh.setFlightId(flightId);
		
		
		book.setBookingId(1003);
	/*	book=(Bookings)dao.Genericfetch(Bookings.class, book.getBookingId());*/
		book.setSeatClass(classType);
		book.setSeatsBooked(seat);
		book.setTravelDate(fligh.getFlightTravelDate());
		book.setBookingNumber("1113");
		
		
		int total=seat*fservice.getFare(flightId, classType);
		System.out.println(total);
		
		book.setTotalCost(total);
		book.setFlightMaster(fligh);
		for(int i=0;i<seat;i++)
		{
			String userName=req.getParameter("username"+i);
			System.out.println(userName);
			String middleName=req.getParameter("middlename"+i);
			System.out.println(middleName);
			String lastName=req.getParameter("lastname"+i);
			String gender=req.getParameter("gender"+i);
			String mealPreferences=req.getParameter("meal"+i);
			String passengerType=req.getParameter("passengerType"+i);
			String age=req.getParameter("age"+i);
			String passportNumber=req.getParameter("passport"+i);
			
			pass.setPassengerId(6000+10);
			pass.setFirstName(userName);
			pass.setMiddleName(middleName);
			pass.setLastName(lastName);
			pass.setGender(gender);
			pass.setMealPreferences(mealPreferences);
			pass.setPassengerType(passengerType);
			pass.setPassportNumber(passportNumber);
			pass.setAge(Integer.parseInt(age));
			
			/*pass.setBooking(book);*/
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
		public String modeSelect(Map model,HttpServletRequest request,HttpServletResponse response)
		{
			System.out.println(request);
			String message="Please select the mode of payement";
			model.put("msg", message);
			return  "modeSelect";
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
			System.out.println(model);
			model.addObject("booking",book);
			System.out.println(model);
			return model;
		}
		
		@RequestMapping("/paymentFailure")
		public String fail(Map model,HttpServletRequest request,HttpServletResponse response)
		{
			String msg="payement failed try again";
			model.put("msg", msg);
			return "modeSelect";
		}
		

		@RequestMapping("/paymentPass")
		public String succ(Map model,HttpServletRequest request,HttpServletResponse response)
		{

			if(bservice.bookTicket(book, passengers))
			{
				String msg="Booking done succesfully";
				model.put("msg", msg);
				return "successful";
			}
			else
			{
				return "unsuccessful";
			}
		}
		
	
}
