package com.lti.service;

import java.util.List;

import com.lti.model.Bookings;
import com.lti.model.Passengers;

public interface BookingService {

	public boolean bookTicket(Bookings booking,List<Passengers> passengers);
	public boolean updateSeat(int flightMasterId,int seat,String classType);
	public List<Bookings> viewBookings(int bookingId);
	public boolean deleteBooking(Bookings book,int a);

}
