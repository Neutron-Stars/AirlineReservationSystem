package com.lti.dao.Implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.dao.AdminDao;
import com.lti.model.Admin;

@Repository
public class AdminImplementation implements AdminDao {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public boolean addAdmin(Admin admin)
	{
		try
		{
			System.out.println("hit occured");
			em.persist(admin);
			return true;
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public boolean checkAdmin(String name,String password)
	{
		boolean userFound=false;
		String query="select o from Admin as o where o.adminName=:mai and o.adminPassword=:pas";
		Query q1=em.createQuery(query);
		q1.setParameter("mai", name);
		q1.setParameter("pas", password);
		List list=q1.getResultList();

		if((list!=null)&&(list.size()>0))
		{
			System.out.println(list.size());
			userFound=true;
		}
		
		return userFound;
	}
}
