package com.lti.dao.Implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.BookingDao;
import com.lti.dao.GenericDao;
import com.lti.model.Bookings;
import com.lti.model.FlightMaster;

@Repository
public class BookingImplementation  implements BookingDao{

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private GenericDao dao;
	
	@Transactional
	public boolean newBooking(Bookings booking)
	{
			try
			{
				System.out.println("hit occured");
				em.persist(booking);
				return true;
			}
			catch(RuntimeException e)
			{
				e.printStackTrace();
				return false;
			}
	}
	
	@Transactional
	public List<Bookings> getBookedDetails(int bookingId)
	{

		Query q1=em.createQuery("select b from Bookings b  where b.bookingId=:bid");
		
			q1.setParameter("bid",bookingId);
			
			
	
			List<Bookings> bk=q1.getResultList();
			System.out.println("repo "+bk.size());
			System.out.println("Success");
	
			return bk;	
	}
	public boolean deleteBooking(Bookings book,int bookingId)
	{
		try
		{
			dao.GenericRemove(Bookings.class,bookingId);
			return true;
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return false;	
		}
	}
	public Bookings getBooking(int personId)
	{
		return null;
	}
}
