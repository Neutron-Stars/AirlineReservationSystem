package com.lti.dao.Implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.dao.FleetMasterDao;
import com.lti.dao.GenericDao;
/*import com.lti.model.FareMaster;*/
import com.lti.model.FleetMaster;

@Repository
public class FleetMasterImplementation implements FleetMasterDao {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private GenericDao dao;

	@Transactional
	public boolean createFleet(FleetMaster fleetMaster)
	{
//		em=sf.getCurrentSession();
		try
		{
			System.out.println("Session hit!!");
			em.persist(fleetMaster);
			System.out.println("inserted Succesfull");
			return true;
		}
		
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean modifyFleet(FleetMaster fleetMaster)
	{
		return false;
	}
	public boolean deleteFleet(int fleetId)
	{
		return false;
	}
	public FleetMaster getFleet(int fleetId)
	{
		FleetMaster fleetMaster = new FleetMaster();
		try
		{
		fleetMaster = (FleetMaster)dao.Genericfetch(FleetMaster.class, fleetId);
		return fleetMaster;
		}
		catch(RuntimeException e)
		{
			return fleetMaster;
		}
	}
	public List<FleetMaster> getAllFleet()
	{
		return null;
	}
}
