package com.lti.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.BookingDao;
import com.lti.model.Bookings;

public class BookingImplementationTest {

	private static ApplicationContext ctx;
	
	@BeforeClass
	public static void fact()
	{
		ctx=new ClassPathXmlApplicationContext("sp-config1.xml");
		System.out.println(ctx);
	}
	
	BookingDao bdao=ctx.getBean(BookingDao.class);
	@Test
	public void test() {
		Bookings book=new Bookings();
//		book.setBookingDate("2019-12-02 18:48:05.123");
		//Booking booking=new Booking();
		book.setBookingId(3009);
		book.setBookingNumber("AZ12");
		book.setTotalCost(7000);
		
		assertTrue(bdao.newBooking(book));
	}

}
