package com.lti.dao.Implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.BookingDao;
import com.lti.model.Bookings;

@Repository
public class BookingImplementation  implements BookingDao{

	@PersistenceContext
	private EntityManager em;
	
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
	
	public List<Bookings> getBookedDetails(int personId)
	{
		return null;
	}
	public boolean deleteBooking(int bookingId)
	{
		return false;
	}
	public Bookings getBooking(int bookingId)
	{
		return null;
	}
}
