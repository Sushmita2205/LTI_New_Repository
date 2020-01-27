package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.CustomerDao;
import com.lti.model.Admin;
import com.lti.model.CustomerApplication;
import com.lti.model.Register;


@Service("service")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao dao;

	public CustomerDao getDao() {
		return dao;
	}

	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}

	@Override
	public boolean addCustomer(CustomerApplication customer) {            //CREATE ACCOUNT
		int result = dao.createCustomer(customer);
		if (result == 1)
			return true;
		else
			return false;
	}
	
	@Override
	public boolean doRegister(Register register) {                          //REGISTER
		
		int result=dao.registerForWeb(register);
		if(result==1)
			return true;
		else
			return false;
	}
	
	@Override
	public Register validate(String customerUsername, String customerPassword) {  //LOGIN
	
		
		Register reg=dao.validate(customerUsername, customerPassword);
		
		return reg;
	}
	
	public List<Register> getRegistrations() {

		return dao.getAllRegistrations();
	}

	@Override
	public List<CustomerApplication> getAllAccounts() {
		List <CustomerApplication> list= dao.getAllSavingAccount();
		return list;
	}

	@Override
	public Admin check(String adminId, String adminPassword) {
		// TODO Auto-generated method stub
Admin admin=dao.check(adminId, adminPassword);
		
		return admin;
		
		
	
	}

	
}