package com.lti.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;

import com.lti.dao.PersonDao;
import com.lti.model.Person;
import com.lti.service.PersonService;

public class PersonImplementationTest {

	private static ApplicationContext ctx;
	
	@BeforeClass
	public static void fact()
	{
		ctx=new ClassPathXmlApplicationContext("sp-config1.xml");
		System.out.println(ctx);
	}
	
	PersonDao pDao=ctx.getBean(PersonDao.class);
	
	@Autowired
	private PersonService pservice;
	
	@Test
	public void testPerson() {
		
		Person per = new Person();
		per.setPersonId(1007);
		per.setPassword("asa");
		per.setEmail("some@gmail.com");
	    per.setfName("shreya");
	    per.setmName("singh");
	    per.setlName("dfg");
	    per.setGender("M");
	    per.setTitle("Mr.");
	    per.setDOB(null);
	    per.setPassportNumber("jkl23455");
		per.setMobileNumber(8652373976l);
	    
		
		assertTrue(pDao.addPerson(per));
	}
	
	@Test
	public void testModifyPerson(){
		
		Person per=new Person();
		per.setPersonId(1005);
		per.setPassword("abc1");
		per.setEmail("abc1@gmail.com");
	    per.setfName("sunil1");
	    per.setmName("singh1");
	    per.setlName("abc1");
	    per.setGender("M");
	    per.setTitle("Mr.");
	    per.setDOB(null);
	    per.setPassportNumber("jkl12345");
		per.setMobileNumber(8652373976l);
		
	    assertTrue(pDao.modifyPerson(per));
	}

	@Test
	public void testDeletePerson()
	{	    
	    assertTrue(pDao.deletePerson("pqr@gmail.com"));
	}
	
	@Test
	public void testGetUser()
	{	  Person ca=new Person(); 
	ca=pDao.getUser("pqr@gmail.com");
	for(Person per:ca)
	{
		System.out.println(per.getfName()+" "+per.getGender()+" "+per.getMobileNumber());
	}
	}
	
	@Test
	public void getPerson()
	{
		
		
		
		
	}
}
