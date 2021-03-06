package com.lti.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.lti.model.FlightMaster;

public interface FlightService {

	public List<FlightMaster> getSearchDetails(int sourceId,int destinationId,LocalDate date);
	public FlightMaster getFlightForDisplay(int flightMasterId);
	public int getFare(int flightMasterId,String classType);
}
