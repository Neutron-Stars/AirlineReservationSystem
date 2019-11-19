package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lti.model.LocationMaster;
import com.lti.model.Person;
import com.lti.service.PersonService;

@Controller
public class PersonController {
@Autowired
@Resource(name="pservice")
private PersonService pservice;

@RequestMapping(path="/checkLogin")
public ModelAndView checkLogin(HttpServletRequest req,HttpServletResponse res)
{
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	Boolean isUser=pservice.checkLogin(email, password);
	if(isUser)
	{
//		String fname;
//		List<Person> list=new ArrayList<Person>();
//		list=pservice.getPerson(email).get
//		String fname=pservice
		req.getSession().setAttribute("email", email);
		System.out.println("Session Saved..");
		return new ModelAndView("homepage","message","Log in Success!!");
	}
	else
	{
		String message="please enter correct credentials";
		return new ModelAndView("unsuccesfulLogin","message",message);
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
