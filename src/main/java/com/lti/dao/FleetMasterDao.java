package com.lti.dao;

import java.util.List;

import com.lti.model.FleetMaster;

public interface FleetMasterDao {

	public boolean createFleet(FleetMaster fleetMaster);
	public boolean modifyFleet(FleetMaster fleetMaster);
	public boolean deleteFleet(int fleetId);
	public FleetMaster getFleet(int fleetId);
	public List<FleetMaster> getAllFleet();
}
