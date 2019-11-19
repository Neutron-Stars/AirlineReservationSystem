package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.PersonDao;
import com.lti.dao.Implementation.PersonImplementation;
import com.lti.model.Person;

@Service("pservice")
public class PersonServiceImplementation implements PersonService {

	@Autowired
	private PersonDao pdao=new PersonImplementation();
	

	public boolean checkLogin(String email,String password)
	{
		Person person=new Person();
		if(person!=null)
		{
			String emailPers=person.getEmail();
			String userPass=person.getPassword();
			if(userPass.equals(password))
				return true;
			else
				return false;
		}
		else
		return false;
	}
	
	public List<Person> getPerson(String email)
	{
		
		return pdao.getUser(email);
	}
}
