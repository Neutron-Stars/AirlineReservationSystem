package com.lti.dao.Implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.dao.GenericDao;
import com.lti.dao.LocationMasterDao;
import com.lti.model.FlightMaster;
import com.lti.model.LocationMaster;


@Repository
public class LocationMasterImplementation implements LocationMasterDao {

//	@Autowired
//	private FlightMaster flight;
	
	@PersistenceContext
	private EntityManager entitymanager;
	
	@Autowired
	private GenericDao dao;
	
	@Transactional
	public boolean createLocation(LocationMaster locationMaster1)
	{
	
		
		try
		{
			System.out.println("Session Hit 2 !!!");
			entitymanager.merge(locationMaster1);
			return true;
		}
		
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean updateLocation(LocationMaster locationMaster)	{
		return false;
	}
	public boolean deleteLocation(int locationId)	{
		return false;
	}
	public LocationMaster getLocation(int locationMasterId)	{
		LocationMaster loc=new LocationMaster();
		try
		{
			loc=(LocationMaster)dao.Genericfetch(LocationMaster.class,locationMasterId);
		return loc;
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return loc;
		}
	}
	public List<LocationMaster> getAllLocation()	{
		String q="select a from LocationMaster a";
		Query q1=entitymanager.createQuery(q);
		List<LocationMaster> list=q1.getResultList();
		return list;
	}
}
