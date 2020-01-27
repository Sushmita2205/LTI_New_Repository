package com.lti.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Admin;
import com.lti.model.CustomerApplication;
import com.lti.model.Register;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private Register reg;
	@Autowired
	private Admin admin;
	

	@Override
	@Transactional
	public int createCustomer( CustomerApplication customer) {                //CREATE ACCOUNT
		
		entityManager.persist(customer);
		return 1;
	}

	@Override
	@Transactional
	public int registerForWeb(Register register) {                    //REGISTER
	
		entityManager.persist(register);
		
		return 1;
	}
	
	@Override
	public Register validate(String customerUsername,String customerPassword) {           //LOGIN
	
		System.out.println("VALIDATE: "+customerUsername);
		String jpql = "from Register s where s.customerUsername=:customer_username";
		TypedQuery<Register> query=entityManager.createQuery(jpql,Register.class);
		query.setParameter("customer_username", customerUsername);
		System.out.println("-----------------REG>");
		reg=query.getSingleResult();
		System.out.println(customerUsername+ " :" + reg.getCustomerUsername());
		System.out.println(customerPassword +" :"+ reg.getCustomerPassword());
		
		if(customerUsername.equals(reg.getCustomerUsername()) && customerPassword.equals(reg.getCustomerPassword()) ){
			System.out.println("done");
			
		}
		else{
			System.out.println("Could not Login");
		}
		
		
		System.out.println("HELLO");
		return reg;
	}
	
	
	
	
	@Override
	public List<Register> getAllRegistrations() {
		String jpql = "From Register";
		TypedQuery<Register> typed = entityManager.createQuery(jpql, Register.class);

		return typed.getResultList();
	}
	
	
	
	@Override
	public List<CustomerApplication> getAllSavingAccount() {
		String jpql = "From CustomerApplication";
		TypedQuery<CustomerApplication> typed = entityManager.createQuery(jpql, CustomerApplication.class);
		List<CustomerApplication> li =(List<CustomerApplication>)typed.getResultList();
		return li;
	}

	@Override
	public Admin check(String adminId, String adminPassword) {
		
		System.out.println("VALIDATE: "+adminId);
		String jpql = "from Admin a where a.adminId=:adminId";
		TypedQuery<Admin> query=entityManager.createQuery(jpql,Admin.class);
		query.setParameter("adminId", adminId);
		System.out.println("-----------------REG>");
		admin=query.getSingleResult();
		System.out.println(adminId+ " :" + admin.getAdminId());
		System.out.println(adminPassword +" :"+ admin.getAdminPassword());
		
		if(adminId.equals(admin.getAdminId()) && adminPassword.equals(admin.getAdminPassword()) ){
			System.out.println("ADMIN LOGIN");
			
		}
		else{
			System.out.println("Could not Login Admin");
		}
		
		
		System.out.println("HELLO");
		return admin;
	}
	


	
	

}