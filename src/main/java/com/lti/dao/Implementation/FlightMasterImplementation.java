package com.lti.dao.Implementation;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.print.attribute.standard.RequestingUserName;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.dao.FlightMasterDao;
import com.lti.dao.GenericDao;
import com.lti.model.FlightMaster;
import com.lti.model.LocationMaster;
import com.lti.model.Person;

@Repository
public class FlightMasterImplementation implements FlightMasterDao {


	@Autowired
	private GenericDao dao;
	
	@PersistenceContext
	private EntityManager  em;
	
	@Transactional
	public boolean newFlight(FlightMaster flightMaster)
	{
//		em=sf.getCurrentSession();
		try
		{
			System.out.println("hit ok1");
			em.merge(flightMaster);
			return true;
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	public List<FlightMaster> searchFlight(LocationMaster locationMaster,LocationMaster locationMaster2,LocalDate travelDate)
	{
		FlightMaster flight=new FlightMaster();
		try {
			
			String q="select a from FlightMaster as a where a.locationMaster1=:add1 and a.locationMaster2=:add2 and a.flightTravelDate=:add3";
			Query q1=em.createQuery(q);
			q1.setParameter("add1", locationMaster);
			q1.setParameter("add2", locationMaster2);
			q1.setParameter("add3", travelDate);
//			List<User>list= q1.getResultList();
			List<FlightMaster> list=q1.getResultList();
			return list;
			
		
		} 
		catch (RuntimeException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@Transactional
	public boolean deleteFlight(FlightMaster flightMaster,int a) {
		try
		{
			dao.GenericRemove(FlightMaster.class,a);
			return true;
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return false;	
		}
		
	}
	public List<FlightMaster> getAll()
	{
		String q="select a from FlightMaster a";
		Query q1=em.createQuery(q);
		List<FlightMaster> list=q1.getResultList();
		return list;
	}
	
	@Transactional
	public FlightMaster getFlight(int flightId) {
		FlightMaster flight=new FlightMaster();
		try
		{
			flight=(FlightMaster)dao.Genericfetch(FlightMaster.class, flightId);
			return flight;
		
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return flight;
		}
	}
	
	@Transactional
	public boolean updateRemainingSeats(FlightMaster flightMaster)
	{
		try
		{
			em.merge(flightMaster);
			return true;
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
}

