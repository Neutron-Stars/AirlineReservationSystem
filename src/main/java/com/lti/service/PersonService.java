package com.lti.service;

import java.util.List;

import com.lti.model.Admin;
import com.lti.model.Person;

public interface PersonService {

	public Person checkLogin(String email,String password);
	
	public Admin checkAdmin(String name,String password);
	public Person getPerson(String email);
}
