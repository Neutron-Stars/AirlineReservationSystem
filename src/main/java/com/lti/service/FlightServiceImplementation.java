package com.lti.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.FareMasterDao;
import com.lti.dao.FlightMasterDao;
import com.lti.dao.LocationMasterDao;
import com.lti.dao.Implementation.FareMasterImplementation;
import com.lti.dao.Implementation.FlightMasterImplementation;
import com.lti.dao.Implementation.LocationMasterImplementation;
import com.lti.model.FlightMaster;
import com.lti.model.LocationMaster;

@Service("flightservice")
public class FlightServiceImplementation implements FlightService {
	
	@Autowired
	private FlightMasterDao fdao=new FlightMasterImplementation();
	
	@Autowired
	private LocationMasterDao ldao=new LocationMasterImplementation();
	
	@Autowired
	private FareMasterDao fadao=new FareMasterImplementation();
	
	public List<FlightMaster> getSearchDetails(int sourceId,int destinationId,Date date)
	{
		LocationMaster source=ldao.getLocation(sourceId);
		System.out.println(source);
		LocationMaster destination=ldao.getLocation(destinationId);
		
		List<FlightMaster> flights=fdao.searchFlight(source, destination, date);
		return flights;
//		return null;
	}
	
	public FlightMaster getFlightForDisplay(int flightMasterId)
	{
		return fdao.getFlight(flightMasterId);
	}
	
	public int getFare(int flightMasterId,String classType)
	{
		FlightMaster flightMaster=fdao.getFlight(flightMasterId);
		if(classType.equalsIgnoreCase("economy"))
			return flightMaster.getFareMaster().getEconomyClass();
		else if(classType.equalsIgnoreCase("premium"))
			return flightMaster.getFareMaster().getPremiumClass();
		else
			return flightMaster.getFareMaster().getBusinessClass();
	}
}
