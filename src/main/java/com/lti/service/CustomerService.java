package com.lti.service;

import java.util.List;

import com.lti.model.Admin;
import com.lti.model.CustomerApplication;
import com.lti.model.Register;

public interface CustomerService {
	
	public boolean addCustomer(CustomerApplication customer);          //CREATE ACCOUNT

	public boolean doRegister(Register register);                      //REGISTER
	
	public Register validate(String CustomerUsername,String customerPassword);  //LOGIN

	public List<Register> getRegistrations();
	
	public List<CustomerApplication> getAllAccounts();
	
	public Admin check(String adminId,String adminPassword);
	
	
}
