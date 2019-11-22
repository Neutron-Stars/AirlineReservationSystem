package com.lti.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lti.model.FareMaster;
import com.lti.model.FleetMaster;
import com.lti.model.FlightMaster;
import com.lti.model.LocationMaster;

public interface AdminService {

	//service related to FleetMaster
		public boolean addFleet(FleetMaster fleetMaster);
		public boolean modifyFleet(FleetMaster fleetMaster);
		public boolean deleteFleet(int fleetId);
		public List<FleetMaster> getAllFleetDetail();

		//service related to FareMaster
		public boolean addFare(FareMaster fareMaster);
		public boolean modifyFare(FareMaster fareMaster);
		public boolean deleteFare(int fareId);
		public List<FareMaster> getAllFareDetail(FareMaster fareMaster);
		
		//service related to LocationMaster
		public boolean addLocation(LocationMaster locationMaster);
		public boolean modifyLocation(LocationMaster locationMaster);
		public boolean deleteLocation(int locationId);
		public List<LocationMaster> getAllLocationDetail();
		
		//service related to FlightMaster
		public boolean addFlight(FlightMaster flightMaster);
		public boolean deleteFlight(FlightMaster flightMaster,int a);
		public List<FlightMaster> getAllFlightDetail();
}
