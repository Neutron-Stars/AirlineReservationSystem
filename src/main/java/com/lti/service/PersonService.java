package com.lti.service;

import java.util.List;

import com.lti.model.Person;

public interface PersonService {

	public boolean checkLogin(String email,String password);
	public List<Person> getPerson(String email);
}
