package com.lti.dao;

import java.util.List;

import com.lti.model.FareMaster;

public interface FareMasterDao {

	public boolean newFare(FareMaster fareMaster);
	public boolean modifyFare(FareMaster fareMaster);
	public boolean deleteFare(int fareId);
	public FareMaster getFare(int fareMasterId);
	public List<FareMaster> getAllFareList();
}
