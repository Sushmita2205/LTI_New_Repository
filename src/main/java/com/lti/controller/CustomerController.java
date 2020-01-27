package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.Admin;
import com.lti.model.CustomerApplication;
import com.lti.model.Register;
import com.lti.model.ResponseMessage;
import com.lti.service.CustomerService;



@RestController
@RequestMapping(path="customers")
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService service;
	@Autowired
	private Register reg;
	@Autowired
	private Admin admin;
	
	private ResponseEntity<ResponseMessage> response;

	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,path="saving")       //CREATE ACCOUNT
	public ResponseEntity<ResponseMessage> addCustomer(@RequestBody CustomerApplication customer) {
	
		System.out.println(customer);
		boolean result=service.addCustomer(customer);
		
		
		if(result)
		{
		response=new ResponseEntity<ResponseMessage>(new ResponseMessage("Customer is added"),HttpStatus.OK);	
		}
		else
		{
			response=new ResponseEntity<ResponseMessage>(new ResponseMessage("Customer is not added"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;

	}
	
	
	
	
	// http://localhost:9090/customers/register
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,path="register")  //REGISTER
	public void register(@RequestBody Register register) {
		System.out.println(register);
		service.doRegister(register);

	}
	
	
	
	
	// http://localhost:9090/customers/sujith/sujith                                             //LOGIN
	@RequestMapping(path="{customerUsername}/{customerPassword}",method=RequestMethod.GET) 
	public ResponseEntity<ResponseMessage> login(@PathVariable("customerUsername") String customerUsername,@PathVariable("customerPassword") String customerPassword){
		System.out.println(customerUsername +" "+ customerPassword);
		reg.setCustomerUserName(customerUsername);
		reg.setCustomerPassword(customerPassword);
		reg=service.validate(reg.getCustomerUsername(),reg.getCustomerPassword());
		System.out.print(reg);

		if(reg==null){
			response=new ResponseEntity<ResponseMessage>(new ResponseMessage("customer is not registered"),HttpStatus.NOT_FOUND);
		}
		else{
			response=new ResponseEntity<ResponseMessage>(new ResponseMessage("login successfull"),HttpStatus.OK);
		}
		return response;
	}
	
	
	
	
	@ExceptionHandler(Exception.class)
		public ResponseEntity<String> handleException(Exception ex){
		ResponseEntity<String> error=new ResponseEntity<String>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		return error;
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Register> findAllRegisters() {
		List<Register> register = service.getRegistrations();

		return register;
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE,path="accounts")
	public List<CustomerApplication> findAllAccounts() {
		List<CustomerApplication> register = service.getAllAccounts();

		return register;
	}
	
	
	

	// http://localhost:9090/customers                                             //ADMIN LOGIN
	@RequestMapping(path="admin/{adminid}/{adminpassword}",method=RequestMethod.GET) 
	public ResponseEntity<ResponseMessage> adminlogin(@PathVariable("adminid") String adminid,@PathVariable("adminpassword") String adminPassword){
		System.out.println(adminid+" "+ adminPassword);
		admin.setAdminId(adminid);
		admin.setAdminPassword(adminPassword);
		admin=service.check(admin.getAdminId(),admin.getAdminPassword());
		System.out.print(admin);

		if(admin==null){
			response=new ResponseEntity<ResponseMessage>(new ResponseMessage("admin is not login"),HttpStatus.NOT_FOUND);
		}
		else{
			response=new ResponseEntity<ResponseMessage>(new ResponseMessage("login successfull"),HttpStatus.OK);
		}
		return response;
	}
	
}
