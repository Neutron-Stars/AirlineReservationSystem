package com.lti.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.entity.FareMaster;
import com.lti.repo.FareMasterInterface;

@Repository
public class FareMasterImpl implements FareMasterInterface{
	
	@PersistenceContext
	private EntityManager em;
		
	@Transactional
	public void addFareMaster(FareMasterInterface fare) {
		// TODO Auto-generated method stub
		em.persist(fare);
	}
}	
