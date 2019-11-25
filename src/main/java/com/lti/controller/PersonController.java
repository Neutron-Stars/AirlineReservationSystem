package com.lti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lti.model.LocationMaster;
import com.lti.model.Person;
import com.lti.service.PersonService;

@Controller
@SessionAttributes("person")
public class PersonController {
	
	@Autowired
	@Resource(name = "pservice")
	private PersonService pservice;

	@RequestMapping("/checkLogin")
	public String checkLogin(
							@RequestParam("email") String email, 
							@RequestParam("password") String password,
							Map model,HttpSession session) {

		System.out.println(password);
		try {
			Person per = pservice.checkLogin(email, password);
			Person per1 = pservice.checkLogin(email, password);
			model.put("person", per);
			// String fname;
			// List<Person> list=new ArrayList<Person>();
			// list=pservice.getPerson(email).get
			// String fname=pservice
			System.out.println("Session Saved..");
			String message1 = "Log in Success!!!";
			model.put("message", message1);
			session.setAttribute("person1", per1);
			return "homepage";

		} catch (RuntimeException e) {
			String message = "please enter correct credentials";
			model.put("message", message);
			return "unsuccessfulLogin";
		}
	}

	@RequestMapping("/homepage")
	public ModelAndView homepage() {
		List<LocationMaster> list = new ArrayList();
		for (LocationMaster aa : list) {
			String name = aa.getAirportName() + "(" + aa.getCode() + ")";
			int id = aa.getLocationMasterId();
			System.out.println(id + " " + name);
		}
		return new ModelAndView("homepage", "total", list);
	}
	
	@RequestMapping("/logout")
	public String logout(Map model,HttpServletRequest req)
	{
			System.out.println("logging out.....");
			HttpSession session=req.getSession();
			Person per=(Person)session.getAttribute("person1");
			System.out.println(per.getfName());
			
		
			
			String message="You have Succesfully logged out Mr./Ms.";
			model.put("msg", message);
			model.put("person1", per);
			session.invalidate();
			
			return "logout";
	}
}
