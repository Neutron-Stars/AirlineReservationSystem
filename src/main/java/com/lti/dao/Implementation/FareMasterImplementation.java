package com.lti.dao.Implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.dao.FareMasterDao;
import com.lti.model.FareMaster;

@Repository
public class FareMasterImplementation implements FareMasterDao {

	@PersistenceContext
	private EntityManager em;
	
	
	
	@Transactional
	public boolean newFare(FareMaster fareMaster)
	{
//		em=sf.getCurrentSession();
		try
		{
			System.out.println("Session hit!!");
			em.persist(fareMaster);
			return true;
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean modifyFare(FareMaster fareMaster){
		return false;
	}
	public boolean deleteFare(int fareId){
		return false;
	}
	public FareMaster getFare(int fareMasterId){
		return null;
	}
	public List<FareMaster> getAllFareList(){
		return null;
	}
}
