package com.lti.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AdminDao;
import com.lti.dao.PersonDao;
import com.lti.dao.Implementation.PersonImplementation;
import com.lti.model.Person;

@Service("pservice")
@Transactional
public class PersonServiceImplementation implements PersonService {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PersonDao pdao;
	
	@Autowired
	private AdminDao adao;
	
	public void setLoginDao(PersonDao pdao)
	{
		this.pdao=pdao;
	}
	

	public Person checkLogin(String email,String password)
	{
		System.out.println("In service Class...Check Login");
		return pdao.checkLogin(email, password);
	}
	
	public Person getPerson(String email)
	{
		
		return pdao.getUser(email);
	}
	
	public boolean checkAdmin(String name,String password)
	{
		System.out.println("You are in Service Class...checking Login!!!");
		return adao.checkAdmin(name, password);
	}
}
