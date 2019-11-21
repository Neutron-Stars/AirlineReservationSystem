package com.lti.repo;

import com.lti.entity.DebitCardDetails;

public interface DebitCardDetailsInterface {
	
	public void addCardDetails(DebitCardDetails card);
	public void deletePayment(int PaymentId);
	public void showDetails(DebitCardDetails card);
	
}
