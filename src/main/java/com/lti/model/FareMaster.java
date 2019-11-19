package com.lti.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FaremasterTbl")
public class FareMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="FareMasterId")
	private int fareMasterId;

	@Column(name="BuisnessClass")
	private int businessClass;

	@Column(name="EconomyClass")
	private int economyClass;

	@Column(name="PremiumClass")
	private int premiumClass;

	//bi-directional many-to-one association to FlightMaster
	@OneToMany(mappedBy="fareMaster")
	private List<FlightMaster> flightMasters;

	public FareMaster() {
	}

//	Getters and Setters
	public int getFareMasterId() {
		return fareMasterId;
	}

	public void setFareMasterId(int fareMasterId) {
		this.fareMasterId = fareMasterId;
	}

	public int getBusinessClass() {
		return businessClass;
	}

	public void setBusinessClass(int businessClass) {
		this.businessClass = businessClass;
	}

	public int getEconomyClass() {
		return economyClass;
	}

	public void setEconomyClass(int economyClass) {
		this.economyClass = economyClass;
	}

	public int getPremiumClass() {
		return premiumClass;
	}

	public void setPremiumClass(int premiumClass) {
		this.premiumClass = premiumClass;
	}

	public List<FlightMaster> getFlightMasters() {
		return flightMasters;
	}

	public void setFlightMasters(List<FlightMaster> flightMasters) {
		this.flightMasters = flightMasters;
	}
	
	public FlightMaster addFlightMaster(FlightMaster flightMaster) {
		getFlightMasters().add(flightMaster);
		flightMaster.setFareMaster(this);

		return flightMaster;
	}

	public FlightMaster removeFlightMaster(FlightMaster flightMaster) {
		getFlightMasters().remove(flightMaster);
		flightMaster.setFareMaster(null);

		return flightMaster;
	}
	
}
