package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaymentController {
	
	@Autowired
	@Resource(name="pservice")
	private PersonService pservice;
	@RequestMapping("/debitcredit")
	public ModelAndView checkLogin(HttpServletRequest req,HttpServletResponse res)
	{
		int CardNumber =req.getParameter(CardNo);
		String CardHolderName=req.getParameter("cardHolderName");
		String ExpiryDate=req.getParameter("ExpDate");
		int Cvc =req.getParameter(cvcNo);
		System.out.println(password);
		
		 isUser=pservice.checkLogin(emailId, password);
		if(isUser)
		{
//			String fname;
//			List<Person> list=new ArrayList<Person>();
//			list=pservice.getPerson(email).get
//			String fname=pservice
			req.getSession().setAttribute("email", emailId);
			System.out.println("Session Saved..");
			String message1="Log in Success!!!";
			return new ModelAndView("homepage","message",message1);
		}
		else
		{
			String message="please enter correct credentials";
			return new ModelAndView("unsuccessfulLogin","message",message);
		}
	}

	@RequestMapping("/homepage")  
	public ModelAndView homepage() {   
	 List<LocationMaster> list=new ArrayList();
	 for(LocationMaster aa:list)
		{
			String name=aa.getAirportName()+"("+aa.getCode()+")";
			int id=aa.getLocationMasterId();
			System.out.println(id+" "+name);
		}
	    return new ModelAndView("homepage","total",list);  
	} 

}
