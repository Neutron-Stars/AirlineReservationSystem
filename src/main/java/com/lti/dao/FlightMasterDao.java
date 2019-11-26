package com.lti.dao;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.lti.model.FlightMaster;
import com.lti.model.LocationMaster;

public interface FlightMasterDao {

	public boolean newFlight(FlightMaster flightMaster);
	public List<FlightMaster> searchFlight(LocationMaster locationMaster,LocationMaster locationMaster2,LocalDate travelDate);
	public boolean deleteFlight(FlightMaster flightMaster,int a);
	public List<FlightMaster> getAll();
	public FlightMaster getFlight(int flightId);
	public boolean updateRemainingSeats(FlightMaster flightMaster);
}
