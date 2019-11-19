package com.lti.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="fleetTbl")
public class FleetMaster implements Serializable {


	@Id
	@Column(name="FleetMasterId")
	private int fleetMasterId;

	private String code;

	private String model;

	@Column(name="TotalBuisnessSeats")
	private int totalBusinessSeats;

	@Column(name="TotalEcoSeats")
	private int totalEconomySeats;

	@Column(name="TotalPremSeats")
	private int totalPremiumSeats;

	//bi-directional many-to-one association to FlightMaster
	@OneToMany(mappedBy="fleetMaster")
	private List<FlightMaster> flightMasters;

	public FleetMaster() {
	}

	
//	Getters and Setters
	public int getFleetMasterId() {
		return fleetMasterId;
	}

	public void setFleetMasterId(int fleetMasterId) {
		this.fleetMasterId = fleetMasterId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getTotalBusinessSeats() {
		return totalBusinessSeats;
	}

	public void setTotalBusinessSeats(int totalBusinessSeats) {
		this.totalBusinessSeats = totalBusinessSeats;
	}

	public int getTotalEconomySeats() {
		return totalEconomySeats;
	}

	public void setTotalEconomySeats(int totalEconomySeats) {
		this.totalEconomySeats = totalEconomySeats;
	}

	public int getTotalPremiumSeats() {
		return totalPremiumSeats;
	}

	public void setTotalPremiumSeats(int totalPremiumSeats) {
		this.totalPremiumSeats = totalPremiumSeats;
	}

	public List<FlightMaster> getFlightMasters() {
		return flightMasters;
	}

	public void setFlightMasters(List<FlightMaster> flightMasters) {
		this.flightMasters = flightMasters;
	}

	public FlightMaster addFlightMaster(FlightMaster flightMaster) {
		getFlightMasters().add(flightMaster);
		flightMaster.setFleetMaster(this);

		return flightMaster;
	}

	public FlightMaster removeFlightMaster(FlightMaster flightMaster) {
		getFlightMasters().remove(flightMaster);
		flightMaster.setFleetMaster(null);

		return flightMaster;
	}

	
}
