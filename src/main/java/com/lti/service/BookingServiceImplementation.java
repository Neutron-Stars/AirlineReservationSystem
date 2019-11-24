package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.BookingDao;
import com.lti.dao.FlightMasterDao;
import com.lti.dao.PassengerDao;
import com.lti.dao.Implementation.BookingImplementation;
import com.lti.dao.Implementation.FlightMasterImplementation;
import com.lti.dao.Implementation.PassengerImplementation;
import com.lti.model.Bookings;
import com.lti.model.FlightMaster;
import com.lti.model.Passengers;

@Service("bservice")
public class BookingServiceImplementation implements BookingService {
	
	@Autowired
	private FlightMasterDao fdao=new FlightMasterImplementation();
	
	@Autowired
	private BookingDao bdao=new BookingImplementation();
	
	@Autowired
	private PassengerDao pdao=new PassengerImplementation();

	public boolean bookTicket(Bookings booking,List<Passengers> passengers)
	{
		if(updateSeat(booking.getFlightMaster().getFlightId(), booking.getSeatsBooked(), booking.getSeatClass()))
		{
			for(Passengers p: passengers){
				if(!pdao.newPassenger(p))
					return false;
				}
			if(!bdao.newBooking(booking))
				return false;

			return true;
		}
		else
			return false;
	}
	
	public boolean updateSeat(int flightMasterId,int seat,String classType)
	{
		FlightMaster f = fdao.getFlight(flightMasterId);
		if(f != null) {
			//economy class
			if(classType.equals("Economy"))
				f.setRemainingEconomySeats(f.getRemainingEconomySeats() - seat);
			//business class
			if(classType.equals("Business"))
				f.setRemainingBusinessSeats(f.getRemainingBusinessSeats() - seat);
			//premium class
			if(classType.equals("Premium"))
				f.setRemainingPremiumSeats(f.getRemainingPremiumSeats() - seat);
			//update seats in flight
			fdao.updateRemainingSeats(f);
			return true;
		}
		//if null
		return false;
	
	}

}
