package com.lti.dao;

import java.util.List;

import com.lti.model.Bookings;


public interface BookingDao {

	public boolean newBooking(Bookings booking);
	public List<Bookings> getBookedDetails(int bookingId);
	public boolean deleteBooking(Bookings book,int bookingId);
	public Bookings getBooking(int personId);
}
