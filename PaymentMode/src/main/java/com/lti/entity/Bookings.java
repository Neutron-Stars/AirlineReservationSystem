package com.lti.entity;	
	import java.io.Serializable;
	import java.sql.Timestamp;
	import java.util.Date;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.ManyToOne;
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
	public class Bookings{

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

		@Temporal(TemporalType.DATE)
		@Column(name="TravelDate")
		private Date  travelDate;

		@ManyToOne
		private DebitCardDetails dbDetails;
		
//		Getters and Setters
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


		public Date getTravelDate() {
			return travelDate;
		}


		public void setTravelDate(Date travelDate) {
			this.travelDate = travelDate;
		}	
}
