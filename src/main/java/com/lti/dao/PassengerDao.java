package com.lti.dao;

import java.util.List;

import com.lti.model.Passengers;

public interface PassengerDao {

	public boolean newPassenger(Passengers passenger);
	public List<Passengers> getPassengers(int bookingId);
}
