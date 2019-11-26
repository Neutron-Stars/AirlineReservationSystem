package com.lti.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author NeutronStars
 *
 */



@Entity
@Table(name="bookingTbl")
public class Bookings implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id 
	private int bookingId;

	private Timestamp bookingDate;

	private String bookingNumber;

	@Column(name="SeatClass")
	private String seatClass;

	@Column(name="SeatsBooked")
	private int seatsBooked;

	@Column(name="TotalCost")
	private int totalCost;

	
	@Column(name="TravelDate")
	private LocalDate  travelDate;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="BookingDoneBy")
	private Person person;

	
	@ManyToOne
	@JoinColumn(name="FlightMasterId")
	private FlightMaster flightMaster;

	/*bi-directional many-to-one association to Passenger*/
	@OneToMany(mappedBy="booking")
	private List<Passengers> passengers;
	
//	Getters and Setters
	public int getBookingId() {
		return bookingId;
	}


	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}


	public Timestamp getBookingDate() {
		return bookingDate;
	}


	public void setBookingDate(Timestamp bookingDate) {
		this.bookingDate = bookingDate;
	}


	public String getBookingNumber() {
		return bookingNumber;
	}


	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}


	public String getSeatClass() {
		return seatClass;
	}


	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}


	public int getSeatsBooked() {
		return seatsBooked;
	}


	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}


	public int getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}


	public LocalDate getTravelDate() {
		return travelDate;
	}


	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	public FlightMaster getFlightMaster() {
		return flightMaster;
	}


	public void setFlightMaster(FlightMaster flightMaster) {
		this.flightMaster = flightMaster;
	}
	
	public List<Passengers> getPassengers() {
		return passengers;
	}


	public void setPassengers(List<Passengers> passengers) {
		this.passengers = passengers;
	}


	
	
	


	public Passengers addPassenger(Passengers passenger) {
		/*getPassengers().add(passenger);*/
		getPassengers().add(passenger);
		passenger.setBooking(this);

		return passenger;
	}

	public Passengers removePassenger(Passengers passenger) {
		getPassengers().remove(passenger);
		passenger.setBooking(null);

		return passenger;
	}
	
	

}
