package com.lti.dao;

import java.util.List;

import com.lti.model.LocationMaster;

public interface LocationMasterDao {

	public boolean createLocation(LocationMaster locationMaster);
	public boolean updateLocation(LocationMaster locationMaster);
	public boolean deleteLocation(int locationId);
	public LocationMaster getLocation(int locationMasterId);
	public List<LocationMaster> getAllLocation();
}
