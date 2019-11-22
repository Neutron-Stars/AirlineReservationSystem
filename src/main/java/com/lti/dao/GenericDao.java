package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
//global Dao class
public class GenericDao {

	@PersistenceContext
	private EntityManager entityManager;

	
	public void Genericinsert(Object obj)
	{
	entityManager.merge(obj);
	}
	
	public Object Genericfetch(Class clazz,Object pk)
	{
		Object obj=entityManager.find(clazz,pk);
		return obj;		
	}
	
	public void GenericRemove(Class clazz,Object pk)
	{
		Object obj1=entityManager.find(clazz, pk);
		entityManager.remove(obj1);		
	}


	
}
