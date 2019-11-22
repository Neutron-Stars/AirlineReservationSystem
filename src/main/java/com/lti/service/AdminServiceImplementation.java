package com.lti.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.dao.FareMasterDao;
import com.lti.dao.FleetMasterDao;
import com.lti.dao.FlightMasterDao;
import com.lti.dao.GenericDao;
import com.lti.dao.LocationMasterDao;
import com.lti.dao.Implementation.FareMasterImplementation;
import com.lti.dao.Implementation.FleetMasterImplementation;
import com.lti.dao.Implementation.FlightMasterImplementation;
import com.lti.dao.Implementation.LocationMasterImplementation;
import com.lti.model.FareMaster;
import com.lti.model.FleetMaster;
import com.lti.model.FlightMaster;
import com.lti.model.LocationMaster;

@Service("aservice")
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private FlightMasterDao flightMasterDAO=new FlightMasterImplementation();
	@Autowired
	private FleetMasterDao fleetMasterDAO=new FleetMasterImplementation();
	@Autowired
	private FareMasterDao fareMasterDAO=new FareMasterImplementation();
	@Autowired
	private LocationMasterDao locationMasterDAO;

	@Autowired
	private GenericDao genericDao;
	
	public boolean addFleet(FleetMaster fleetMaster) {
		return fleetMasterDAO.createFleet(fleetMaster);
	}

	
	public boolean modifyFleet(FleetMaster fleetMaster) {
		return fleetMasterDAO.modifyFleet(fleetMaster);
	}

	
	public boolean deleteFleet(int fleetId) {
		return fleetMasterDAO.deleteFleet(fleetId);
	}

	
	public List<FleetMaster> getAllFleetDetail() {
		return fleetMasterDAO.getAllFleet();
	}

	
	public boolean addFare(FareMaster fareMaster) {	
		return fareMasterDAO.newFare(fareMaster);
	}

	
	public boolean modifyFare(FareMaster fareMaster) {	
		return fareMasterDAO.modifyFare(fareMaster);
	}

	
	public boolean deleteFare(int fareId) {
		return fareMasterDAO.deleteFare(fareId);
	}

	
	public List<FareMaster> getAllFareDetail(FareMaster fareMaster) {	
		return fareMasterDAO.getAllFareList();
	}

	
	public boolean addLocation(LocationMaster locationMaster) {
		return locationMasterDAO.createLocation(locationMaster);
	}

	
	public boolean modifyLocation(LocationMaster locationMaster) {
		return locationMasterDAO.updateLocation(locationMaster);
	}

	
	public boolean deleteLocation(int locationId) {
		return locationMasterDAO.deleteLocation(locationId);
	}

	
	public List<LocationMaster> getAllLocationDetail() {
		List<LocationMaster> list=locationMasterDAO.getAllLocation();
		return list;
	}

	
	public boolean addFlight(FlightMaster flight,String ar,
																				String dp,
																				String fdate,
																				Integer depId,
																				Integer arrId,
																				Integer fleId,
																				Integer farId){
		try 
		{
		SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH);
		LocalDateTime date=LocalDateTime.parse(ar, formatter);
		LocalDateTime date1=LocalDateTime.parse(dp, formatter);
		Date date2=formatter1.parse(fdate);
		
		LocationMaster loc=(LocationMaster)genericDao.Genericfetch(LocationMaster.class, depId);
		LocationMaster loc1=(LocationMaster)genericDao.Genericfetch(LocationMaster.class, arrId);
		
		FleetMaster  fle=(FleetMaster)genericDao.Genericfetch(FleetMaster.class, fleId);
		FareMaster  far=(FareMaster)genericDao.Genericfetch(FareMaster.class, farId);
		
		flight.setArrivalTime(date);
		flight.setDepartureTime(date1);
		flight.setFlightTravelDate(date2);
		
		flight.setLocationMaster1(loc);
		flight.setLocationMaster2(loc1);
		
		
	 return flightMasterDAO.newFlight(flight) ;
		}
		catch(ParseException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	
	public boolean deleteFlight(FlightMaster flightMaster) {
		return flightMasterDAO.updateRemainingSeats(flightMaster);
	}

	public List<FlightMaster> getAllFlightDetail() {
        return flightMasterDAO.getAll();
	}
	
}
