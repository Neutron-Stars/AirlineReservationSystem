package com.lti.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_DebitCardDetails")
public class DebitCardDetails {
	
	@Id
	@Column(name="PaymentId")
	private int PaymentId;
	@Column(name="CardNumber")
	private int CardNumber;
	@Column(name="NameOnCard")
	private String NameOnCard;
	@Column(name="ExpiryDate")
	private String ExpiryDate;
	@Column(name="cvcNumber")
	private int cvcNumber;
	
	@OneToMany
	@JoinColumn(name="FareMasterId")
	private List<FareMaster> faremaster;
	
	@OneToMany
	@JoinColumn(name=" bookingId")
	private List<Bookings> booking;
	
	public int getCardNumber() {
		return CardNumber;
	}
	public void setCardNumber(int cardNumber) {
		CardNumber = cardNumber;
	}
	public String getNameOnCard() {
		return NameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		NameOnCard = nameOnCard;
	}
	public String getExpiryDate() {
		return ExpiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		ExpiryDate = expiryDate;
	}
	public int getCvcNumber() {
		return cvcNumber;
	}
	public void setCvcNumber(int cvcNumber) {
		this.cvcNumber = cvcNumber;
	}
}
