package com.lti.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 
 * @author NeutronStars
 *
 */
@Entity
@Table(name="passTbl")
public class Passengers implements Serializable {

	@Id
	@Column(name="PassengerId")
	private int passengerId;

	private int age;

	@Column(name="FirstName")
	private String firstName;

	private String gender;

	@Column(name="LastName")
	private String lastName;

	@Column(name="MealPreferences")
	private String mealPreferences;

	@Column(name="MiddleName")
	private String middleName;

	@Column(name="PassengerType")
	private String passengerType;

	@Column(name="PassportNumber")
	private String passportNumber;

	//bi-directional many-to-one association to Booking
	@ManyToOne
	@JoinColumn(name="BookingId")
	private Bookings booking;

	public Passengers() {
		
	}

	
//	Getters and Setters
	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMealPreferences() {
		return mealPreferences;
	}

	public void setMealPreferences(String mealPreferences) {
		this.mealPreferences = mealPreferences;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Bookings getBooking() {
		return booking;
	}

	public void setBooking(Bookings booking) {
		this.booking = booking;
	}
	
	
	
}
