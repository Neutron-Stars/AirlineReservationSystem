package com.lti.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.dao.AddressDetailDao;
import com.lti.model.AddressDetail;
import com.lti.model.Person;

public class AddressDetailImplementationTest {

	
	private static ApplicationContext ctx;
	
	@BeforeClass
	public static void fact()
	{
		ctx=new ClassPathXmlApplicationContext("sp-config1.xml");
		System.out.println(ctx);
	}
	AddressDetailDao addressDetailsDAO=ctx.getBean(AddressDetailDao.class);
	
	@Test
	public void test() {
		
		AddressDetail addressDetail=new AddressDetail();
		addressDetail.setAddressId(1237);
		addressDetail.setLine1("Yoo2");
		addressDetail.setLine2("second line DOne2");
		addressDetail.setLine3("line 3.1");
		addressDetail.setType("office");
		addressDetail.setCountry("India");
		addressDetail.setPincode(400037);
		addressDetail.setCity("Mumbai");
		
		assertTrue(addressDetailsDAO.addNewAddress(addressDetail));
	}
	
	@Test
	public void testModifyAddress(){
		
		AddressDetail addressDetail=new AddressDetail();
		addressDetail.setAddressId(1237);
		addressDetail.setLine1("Yoo2");
		addressDetail.setLine2("second line DOne2");
		addressDetail.setLine3("line 3.1");
		addressDetail.setType("office");
		addressDetail.setCountry("India");
		addressDetail.setPincode(400037);
		addressDetail.setCity("Mumbai");
		
		 assertTrue(addressDetailsDAO.modifyAddress(addressDetail));
	}

	@Test
	public void testDeletePerson()
	{	    
	    assertTrue(addressDetailsDAO.deleteAddress(1236));
	}
	
	@Test
	public void testGetUser()
	{	   List<AddressDetail> ca=new ArrayList<AddressDetail>(); 
	ca=addressDetailsDAO.getAddressList(1236);
	
	for(AddressDetail addr:ca)
	{
		System.out.println(addr.getCity()+" "+addr.getCountry()+" "+addr.getType());
	}
	}

}
