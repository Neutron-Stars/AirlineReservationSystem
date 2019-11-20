package com.lti.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.model.Person;

@Repository
public interface PersonDao {

	public boolean addPerson(Person person);
	public boolean modifyPerson(Person person);
	public List<Person> getUser(String email);
	public boolean deletePerson(String email);

	public boolean checkLogin(String email,String password);
}
