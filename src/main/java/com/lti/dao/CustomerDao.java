package com.lti.dao;

import java.util.List;

import com.lti.model.Admin;
import com.lti.model.CustomerApplication;
import com.lti.model.Register;;

public interface CustomerDao {
	public int createCustomer(CustomerApplication customer);                      //CREATE ACCOUNT
	
	public int registerForWeb(Register register);                                 //REGISTER
	
	public Register validate(String customerUsername,String customerPassword);    //LOGIN
	
	public List<Register> getAllRegistrations();
	
	public List<CustomerApplication> getAllSavingAccount();
	
	public Admin check(String adminId,String adminPassword);                    //ADMIN LOGIN
	
}