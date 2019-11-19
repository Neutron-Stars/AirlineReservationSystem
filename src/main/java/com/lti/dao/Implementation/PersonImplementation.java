package com.lti.dao.Implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


import com.lti.dao.PersonDao;
import com.lti.model.Person;





@Repository
public class PersonImplementation implements PersonDao  {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public boolean addPerson(Person person)
	{
		try
		{
			System.out.println("Session occured!!");
			System.out.println("Seesion hit success!!");
		 entityManager.persist(person);
		return true;
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@Transactional
	public boolean modifyPerson(Person person) {
	
		try {
			System.out.println("Hit");
			entityManager.merge(person);
			return true;
		}
		catch (RuntimeException e) 
		{
			e.printStackTrace();
			return false;
		}
		
	}

	@Transactional	
	public List<Person > getUser(String emailAddress) {
	
		
		Person person = new Person();
		try {
			
			String q="select a from Person as a where a.email=:mail";
			Query q1=entityManager.createQuery(q);
			q1.setParameter("mail", emailAddress);
//			List<User>list= q1.getResultList();
			List<Person> list=q1.getResultList();
			return list;
			
		
		} 
		catch (RuntimeException e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Transactional
	public boolean deletePerson(String emailAddress) {
		
		try {
			String q="delete from Person where emailAdrress=:mail";

			Query q1=entityManager.createQuery(q);
			q1.setParameter("mail", emailAddress);
			q1.executeUpdate();
//			Query delete_query = session
//					.createQuery("delete from Person where emailAddress=:id");
//			delete_query.setParameter("id", emailAddress);
//			delete_query.executeUpdate();

			return true;
		} catch (RuntimeException e) {
			return false;
		}
	
	}
	

}
