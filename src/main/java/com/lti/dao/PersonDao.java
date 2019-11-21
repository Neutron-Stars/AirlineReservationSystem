package com.lti.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.model.Person;


public interface PersonDao {

	public boolean addPerson(Person person);
	public boolean modifyPerson(Person person);
	public Person getUser(String email);
	public boolean deletePerson(String email);

	public Person checkLogin(String email,String password);
}
