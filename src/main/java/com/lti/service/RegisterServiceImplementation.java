package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.PersonDao;
import com.lti.model.Person;

@Service("rservice")
public class RegisterServiceImplementation implements RegisterService{

	@Autowired
	private PersonDao pdao;
	
	public void insert(Person per)
	{
		System.out.println("hit");
		pdao.addPerson(per);
	}
}
