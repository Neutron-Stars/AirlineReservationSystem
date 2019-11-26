package com.lti.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lti.model.Person;
import com.lti.service.RegisterService;

@Controller
public class RegisterController {

	@Autowired
	public RegisterService rservice;
	
	@RequestMapping("/register")
	public String registerinsert(Person per,Map model){
		rservice.insert(per);
		model.put("message", "Registration Successful");
		return "register";
	}
}
