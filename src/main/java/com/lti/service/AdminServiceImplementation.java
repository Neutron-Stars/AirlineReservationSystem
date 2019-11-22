package com.lti.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.InitBinder;
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

	
	@InitBinder
	public boolean addFlight(FlightMaster flight){
		
			/*	System.out.println(a);*/
			/*Integer depId=Integer.parseInt(a1);
			Integer arrId=Integer.parseInt(req.getParameter("locationMaster2"));
			Integer fleId=Integer.parseInt(req.getParameter("fleetMaster"));
			Integer farId=Integer.parseInt(req.getParameter("fareMaster"));*/
			
		/*	LocationMaster depLoc=(LocationMaster)genericDao.Genericfetch(LocationMaster.class, a1);
			LocationMaster arrLoc=(LocationMaster)genericDao.Genericfetch(LocationMaster.class, b1);
			
			FleetMaster fleet=(FleetMaster)genericDao.Genericfetch(FleetMaster.class, c1);
			
			FareMaster fare=(FareMaster)genericDao.Genericfetch(FareMaster.class, d1);
			
			flight.setArrivalTime(date);
			flight.setDepartureTime(date1);
			flight.setFlightTravelDate(date2);
			flight.setLocationMaster1(arrLoc);
			flight.setLocationMaster2(depLoc);
			flight.setFleetMaster(fleet);
			flight.setFareMaster(fare);*/
		
	 return flightMasterDAO.newFlight(flight) ;
		
	}

	
	public boolean deleteFlight(FlightMaster flightMaster,int a) {
		flightMaster=(FlightMaster)genericDao.Genericfetch(FlightMaster.class,a);
		return flightMasterDAO.deleteFlight(flightMaster,a);
	}

	public List<FlightMaster> getAllFlightDetail() {
        return flightMasterDAO.getAll();
	}
	
}
