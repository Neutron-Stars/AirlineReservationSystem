package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.BookingDao;
import com.lti.dao.FleetMasterDao;
import com.lti.dao.FlightMasterDao;
import com.lti.dao.GenericDao;
import com.lti.dao.PassengerDao;
import com.lti.dao.Implementation.BookingImplementation;
import com.lti.dao.Implementation.FleetMasterImplementation;
import com.lti.dao.Implementation.FlightMasterImplementation;
import com.lti.dao.Implementation.PassengerImplementation;
import com.lti.model.Bookings;
import com.lti.model.FleetMaster;
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
	
	@Autowired
	private FleetMasterDao fldao=new FleetMasterImplementation();
	
	@Autowired
	private GenericDao dao;

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
		int a;
		FlightMaster f = fdao.getFlight(flightMasterId);
		
		FleetMaster fa=new FleetMaster();
		FleetMaster fa1=new FleetMaster();
		fa=f.getFleetMaster();
		
		fa1=fldao.getFleet(fa.getFleetMasterId());
		
		if(f != null) {
			//economy class
			if(classType.equals("Economy"))
			{
				f.setRemainingEconomySeats(fa1.getTotalEconomySeats() - seat);
				f.setArrivalTime(f.getArrivalTime());
				f.setDepartureTime(f.getDepartureTime());
				f.setFareMaster(f.getFareMaster());
				f.setFleetMaster(f.getFleetMaster());
				f.setFlightTravelDate(f.getFlightTravelDate());
				f.setLocationMaster1(f.getLocationMaster1());
				f.setLocationMaster2(f.getLocationMaster2());
				f.setFlightEndDate(f.getFlightEndDate());
			//business class
			}
			if(classType.equals("Business"))
			{
				f.setRemainingBusinessSeats(fa1.getTotalBusinessSeats() - seat);
			//premium class
			}
			if(classType.equals("Premium"))
			{
				f.setRemainingPremiumSeats(fa1.getTotalPremiumSeats() - seat);
			//update seats in flight
			}
			System.out.println("hit occured1");
			if(!fdao.updateRemainingSeats(f))
			{
				System.out.println("done booking");
			}
			return true;
		}
		//if null
		return false;
	
	}

	public List<Bookings> viewBookings(int bookingId){
		System.out.println("Booking Details Displayed");
		
		return bdao.getBookedDetails(bookingId);
	}
	
	public boolean deleteBooking(Bookings book,int a) {
		book=(Bookings)dao.Genericfetch(Bookings.class,a);
		return bdao.deleteBooking(book,a);
	}
}
