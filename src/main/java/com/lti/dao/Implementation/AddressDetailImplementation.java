package com.lti.dao.Implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.lti.dao.AddressDetailDao;
import com.lti.model.AddressDetail;
import com.lti.model.Person;

@Repository
public class AddressDetailImplementation implements AddressDetailDao {

	@PersistenceContext
	private EntityManager em;
	
	
	
	@Transactional
	public boolean addNewAddress(AddressDetail addressDetail)
	{
//		em=sf.getCurrentSession();
		try
		{
			System.out.println("Hit occured!!");
			em.persist(addressDetail);
			return true;
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean  modifyAddress(AddressDetail addressDetail)
	{
		try {
			System.out.println("Hit");
			em.merge(addressDetail);
			return true;
		}
		catch (RuntimeException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	public List<AddressDetail> getAddressList(int personId)
	{

		Person person = new Person();
		try {
			
			String q="select a from AddressDetail as a where a.addressId=:id";
			Query q1=em.createQuery(q);
			q1.setParameter("id",personId);
//			List<User>list= q1.getResultList();
			List<AddressDetail> list=q1.getResultList();
			return list;
			
		
		} 
		catch (RuntimeException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public boolean deleteAddress(int addressId) {
		try {
			String q="delete from AddressDetail where addressId=:id";

			Query q1=em.createQuery(q);
			q1.setParameter("id",addressId);
			q1.executeUpdate();
			return true;
			
		} 
		catch (RuntimeException e) 
		{
			return false;
		}
	}
	
}
