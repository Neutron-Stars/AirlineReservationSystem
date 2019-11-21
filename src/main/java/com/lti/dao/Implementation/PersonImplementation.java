package com.lti.dao.Implementation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

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
	public Person getUser(String emailAddress) {
			String q="select a from Person as a where a.email=:mail";
			Query q1=entityManager.createQuery(q);
			q1.setParameter("mail", emailAddress);
//			List<User>list= q1.getResultList();
			Person p=(Person) q1.getSingleResult();
			return p;
	
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
	
	public Person checkLogin(String email,String password)
	{
		String query="select o from Person as o where o.email=:mai and o.password=:pas";
		Query q1=entityManager.createQuery(query);
		q1.setParameter("mai", email);
		q1.setParameter("pas", password);
		Person p = (Person) q1.getSingleResult();
		return p;
	}
	

}
