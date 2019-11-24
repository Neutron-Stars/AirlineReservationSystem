package com.lti.dao.Implementation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDao;
import com.lti.dao.PassengerDao;
import com.lti.model.Passengers;

@Repository
@Transactional
public class PassengerImplementation implements PassengerDao {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private GenericDao dao;
	
	public boolean newPassenger(Passengers passenger)
	{
		try
		{
			em.persist(passenger);
			return true;
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return false;
		}
	
	}
	public List<Passengers> getPassengers(int bookingId)
	{
		List<Passengers> pass=new ArrayList<Passengers>();
		try
		{
			String q="select a from Passengers a where a.booking=:boId";
			Query q1=em.createQuery(q);
			q1.setParameter("boId", bookingId);
			pass=q1.getResultList();
			return pass;
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return pass;
		}
		
	}
}
