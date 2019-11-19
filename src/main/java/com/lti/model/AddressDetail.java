package com.lti.model;

import java.io.Serializable;

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
@Table(name="addressDetails")
public class AddressDetail implements Serializable{

	private static final long serialVersionUID=1L;
	@Id
	private int addressId;
	
	private String city;
	
	private String country;
	
	@Column(name="addressLine1")
	private String line1;
	
	@Column(name="addressLine2")
	private String line2;
	
	@Column(name="addressLine3")
	private String line3;
	
	private int pincode;
	
	private String type;
	
	@ManyToOne
	@JoinColumn(name="personDetails")
	private	Person person;
	
	public AddressDetail() {
		}

	
//	Getters and Setters
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLine3() {
		return line3;
	}

	public void setLine3(String line3) {
		this.line3 = line3;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
}
