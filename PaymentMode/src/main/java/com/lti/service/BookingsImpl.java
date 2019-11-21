package com.lti.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.entity.Bookings;
import com.lti.repo.BookingInterface;

@Repository
public  class BookingsImpl implements BookingInterface {

	@PersistenceContext
	private EntityManager em;
	
	public void addBooking(Bookings book) {
		// TODO Auto-generated method stub
		em.persist(book);
	}

}
