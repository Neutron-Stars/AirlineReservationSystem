package com.lti.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Neutron Stars
 * persistence class for Person database table
 *
 */




@Entity
@Table(name="personTbl")
//@NamedQuery
public class Person implements Serializable {
	
	private static final long serialVersionUID=1L;
	
	@Id
	private int personId;
	
	@Temporal(TemporalType.DATE)
	private Date DOB;
	
	@Column(name="emailAdrress")
	private String email;
	
	private String fName;
	
	private String lName;
	
	private String mName;
	
	private String gender;
	
	private String passportNumber;
	
	private String password;
	
	private long mobileNumber;
	
	private String title;
	
	@OneToMany(mappedBy="person")
	private List<AddressDetail> addr;
	
	@OneToMany(mappedBy="person")
	private List<Bookings> book;
	
	public Person()
	{
		
	}

	
//	Getters and Setters
	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public String getEmail() {
		return email;
	}

	public List<AddressDetail> getAddr() {
		return addr;
	}

	public void setAddr(List<AddressDetail> addr) {
		this.addr = addr;
	}


	public List<Bookings> getBook() {
		return book;
	}


	public void setBook(List<Bookings> book) {
		this.book = book;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
public AddressDetail addAddressDetail(AddressDetail addressDetail) {
/*	getAddressDetails().add(addressDetail);*/
	getAddr().add(addressDetail);
	addressDetail.setPerson(this);

	return addressDetail;
}

public AddressDetail removeAddressDetail(AddressDetail addressDetail) {
	/*getAddressDetails().remove(addressDetail);*/
	getAddr().remove(addressDetail);
	addressDetail.setPerson(null);

	return addressDetail;
}
	

public Bookings addBooking(Bookings booking) {
/*getBookings().add(booking);*/
	getBook().add(booking);
booking.setPerson(this);

return booking;
}

public Bookings removeBooking(Bookings booking) {
/*getBookings().remove(booking);*/
	getBook().remove(booking);
booking.setPerson(null);

return booking;
}

}
