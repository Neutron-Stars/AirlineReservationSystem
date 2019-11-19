package com.lti.dao;

import java.util.List;

import com.lti.model.AddressDetail;

public interface AddressDetailDao {

	
	public boolean modifyAddress(AddressDetail addressDetail);
	public boolean addNewAddress(AddressDetail addressDetail);
	public List<AddressDetail> getAddressList(int personId);
	public boolean deleteAddress(int addressId);
}
