package com.lti.dao;

import com.lti.model.Admin;

public interface AdminDao {

	public boolean addAdmin(Admin ad);
	
	public Admin checkAdmin(String name,String password);
}
