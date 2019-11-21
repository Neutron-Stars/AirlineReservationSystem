package com.lti.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FaremasterTbl")
public class FareMaster {

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

	@ManyToOne
	private DebitCardDetails dbDetails;
	
	
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
}



