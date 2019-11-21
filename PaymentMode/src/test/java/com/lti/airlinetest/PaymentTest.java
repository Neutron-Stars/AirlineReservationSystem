package com.lti.airlinetest;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.entity.DebitCardDetails;
import com.lti.repo.DebitCardDetailsInterface;

public class PaymentTest {

private static ApplicationContext ctx;
	
	@BeforeClass
	public static void fact()
	{
		ctx=new ClassPathXmlApplicationContext("app-config.xml");
		System.out.println(ctx);
	}
	@Test
	public void addDebitCardDetails() {
		
			DebitCardDetails db=new DebitCardDetails();
			db.setCardNumber(23424);
			db.setNameOnCard("Mallesh");
			db.setExpiryDate("22/12");
			db.setCvcNumber(123);
			DebitCardDetailsInterface gx=(DebitCardDetailsInterface) ctx.getBean(DebitCardDetailsInterface.class);	
			gx.addCardDetails(db);			
	}

}
