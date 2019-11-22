package com.lti.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;


/**
 * 
 * @author NeutronStars
 *
 */
@Entity 
@Table (name="locationTbl")
public class LocationMaster implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="LocationMasterId")
	private int locationMasterId;

	@Column(name="AirportName")
	private String airportName;

	private String code;

	private String country;

	private String name;

	//bi-directional many-to-one association to FlightMaster
/*	@OneToMany(mappedBy="locationMaster1")
	private List<FlightMaster> flightMasters1;

	//bi-directional many-to-one association to FlightMaster
	@OneToMany(mappedBy="locationMaster2")
	private List<FlightMaster> flightMasters2;*/

	@Autowired
	public LocationMaster() {
	}

//	Getters and Setters
	public int getLocationMasterId() {
		return locationMasterId;
	}

	public void setLocationMasterId(int locationMasterId) {
		this.locationMasterId = locationMasterId;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public List<FlightMaster> getFlightMasters1() {
		return flightMasters1;
	}

	public void setFlightMasters1(List<FlightMaster> flightMasters1) {
		this.flightMasters1 = flightMasters1;
	}

	public List<FlightMaster> getFlightMasters2() {
		return flightMasters2;
	}

	public void setFlightMasters2(List<FlightMaster> flightMasters2) {
		this.flightMasters2 = flightMasters2;
	}
	*/
	/*public FlightMaster addFlightMasters1(FlightMaster flightMasters1) {
		getFlightMasters1().add(flightMasters1);
		flightMasters1.setLocationMaster1(this);

		return flightMasters1;
	}

	public FlightMaster removeFlightMasters1(FlightMaster flightMasters1) {
		getFlightMasters1().remove(flightMasters1);
		flightMasters1.setLocationMaster1(null);

		return flightMasters1;
	}
	
	public FlightMaster addFlightMasters2(FlightMaster flightMasters2) {
		getFlightMasters2().add(flightMasters2);
		flightMasters2.setLocationMaster2(this);

		return flightMasters2;
	}

	public FlightMaster removeFlightMasters2(FlightMaster flightMasters2) {
		getFlightMasters2().remove(flightMasters2);
		flightMasters2.setLocationMaster2(null);

		return flightMasters2;
	}*/
	
}
