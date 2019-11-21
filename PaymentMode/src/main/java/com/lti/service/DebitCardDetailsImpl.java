package com.lti.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.entity.Bookings;
import com.lti.entity.DebitCardDetails;
import com.lti.repo.DebitCardDetailsInterface;

@Repository
public class DebitCardDetailsImpl implements DebitCardDetailsInterface{

	@PersistenceContext
	private EntityManager em;
		
	@Transactional
	public void addCardDetails(DebitCardDetails card) {
		// TODO Auto-generated method stub
		em.persist(card);
	}
	public void deletePayment(int PaymentId) {
		// TODO Auto-generated method stub
	}

	public void showDetails(DebitCardDetails card) {
		// TODO Auto-generated method stub
		
	}
	

}
