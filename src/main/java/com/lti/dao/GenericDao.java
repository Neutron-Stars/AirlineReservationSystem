package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



//global Dao class
public class GenericDao {
	
	
	public void Genericinsert(Object obj)
	{
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
	EntityManager em= emf.createEntityManager();
	EntityTransaction tx=em.getTransaction();
	tx.begin();
	
	
	//merge is a two in one  method for both insert and update
	em.merge(obj);
	
	tx.commit();
	em.close();
	emf.close();
	}
	
	public Object Genericfetch(Class clazz,Object pk)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em= emf.createEntityManager();
		
		Object obj=em.find(clazz,pk);
		em.close();
		emf.close();
		
		return obj;
		
	}
	
	public void GenericRemove(Class clazz,Object pk)
	{
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracleTest");
		EntityManager em= emf.createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		//Object obj;
		//return obj;
		Object obj1=em.find(clazz, pk);
		em.remove(obj1);
		tx.commit();
		em.close();
		emf.close();
		
	}


	
}
