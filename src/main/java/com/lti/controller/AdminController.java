package com.lti.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lti.service.PersonService;

@Controller
public class AdminController {
	@Autowired
	@Resource(name="pservice")
	private PersonService pservice;

	@RequestMapping("/checkAdmin")
	public ModelAndView chechAdmin(HttpServletRequest req,HttpServletRequest res)
	{
		String name=req.getParameter("adminName");
		String password=req.getParameter("adminPassword");
		
		System.out.println(password);
		
		boolean isAdmin=pservice.checkAdmin(name, password);
		if(isAdmin)
		{
			req.getSession().setAttribute("adminName", name);
			System.out.println("saved Session");
			String message="Welcome back sir :)";
			return new ModelAndView("adminPage","message",message);
		}
		
		else
		{
			String message1="Please Enter Correct Credentials";
			return new ModelAndView("failedLogin","message",message1);
		}
	}
}
