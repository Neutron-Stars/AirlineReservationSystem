package com.lti.model;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author vshadmin
 *
 */

@Entity
@Table(name="flightTable")
public class FlightMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_generator")
	@SequenceGenerator(name="flight_generator", sequenceName = "seq_flighttable", initialValue=4000, allocationSize=1)
	@Column(name="FlightId")
	private int flightId;

	@Column(name="ArrivalTime")
	private LocalTime arrivalTime;

	@Column(name="DepartureTime")
	private LocalTime departureTime;

	
		@Column(name="FlightTravelDate")
	private LocalDate flightTravelDate;
	
	

	@Column()
	private LocalDate flightEndDate;
	
	
	
	

	public LocalDate getFlightEndDate() {
		return flightEndDate;
	}

	@Column(name="RemBuisSeat")
	private int remainingBusinessSeats;

	@Column(name="RemEcoSeat")
	private int remainingEconomySeats;

	@Column(name="RemPremSeat")
	private int remainingPremiumSeats;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="flightMaster")
	private List<Bookings> bookings;

	//bi-directional many-to-one association to LocationMaster
	@ManyToOne
	@JoinColumn(name="DepartureLoc")
	private LocationMaster locationMaster1;

	//bi-directional many-to-one association to LocationMaster
	@ManyToOne
	@JoinColumn(name="ArrivalLoc")
	private LocationMaster locationMaster2;

	//bi-directional many-to-one association to FleetMaster
	@ManyToOne
	@JoinColumn(name="Fleet")
	private FleetMaster fleetMaster;

	//bi-directional many-to-one association to FareMaster
	@ManyToOne
	@JoinColumn(name="Fare")
	private FareMaster fareMaster;

	
//	Getters and Setters
	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public void setFlightEndDate(LocalDate flightEndDate) {
		this.flightEndDate = flightEndDate;
	}


	
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public LocalDate getFlightTravelDate() {
		return flightTravelDate;
	}

	public void setFlightTravelDate(LocalDate flightTravelDate) {
		this.flightTravelDate = flightTravelDate;
	}

	public int getRemainingBusinessSeats() {
		return remainingBusinessSeats;
	}

	public void setRemainingBusinessSeats(int remainingBusinessSeats) {
		this.remainingBusinessSeats = remainingBusinessSeats;
	}

	public int getRemainingEconomySeats() {
		return remainingEconomySeats;
	}

	public void setRemainingEconomySeats(int remainingEconomySeats) {
		this.remainingEconomySeats = remainingEconomySeats;
	}

	public int getRemainingPremiumSeats() {
		return remainingPremiumSeats;
	}

	public void setRemainingPremiumSeats(int remainingPremiumSeats) {
		this.remainingPremiumSeats = remainingPremiumSeats;
	}

	public List<Bookings> getBookings() {
		return bookings;
	}

	public void setBookings(List<Bookings> bookings) {
		this.bookings = bookings;
	}

	public LocationMaster getLocationMaster1() {
		return locationMaster1;
	}

	public void setLocationMaster1(LocationMaster locationMaster1) {
		this.locationMaster1 = locationMaster1;
	}

	public LocationMaster getLocationMaster2() {
		return locationMaster2;
	}

	public void setLocationMaster2(LocationMaster locationMaster2) {
		this.locationMaster2 = locationMaster2;
	}

	public FleetMaster getFleetMaster() {
		return fleetMaster;
	}

	public void setFleetMaster(FleetMaster fleetMaster) {
		this.fleetMaster = fleetMaster;
	}

	public FareMaster getFareMaster() {
		return fareMaster;
	}

	public void setFareMaster(FareMaster fareMaster) {
		this.fareMaster = fareMaster;
	}

	
	public Bookings addBooking(Bookings booking) {
		getBookings().add(booking);
		booking.setFlightMaster(this);

		return booking;
	}

	public Bookings removeBooking(Bookings booking) {
		getBookings().remove(booking);
		booking.setFlightMaster(null);

		return booking;
	}
	
}
