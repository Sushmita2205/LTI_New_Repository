package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope(scopeName="prototype")
@Table(name="register2")
public class Register {
 
	@Id
	@Column(name="CUSTOMER_USERNAME")
	private String customerUsername;
	
	@Column(name="CUSTOMER_PASSWORD")
	private String customerPassword;
	
	@Column(name="TRANSACTION_PASSWORD")
	private String transactionPassword;
	
	@Column(name="ACCOUNT_NO")
	private long account_no;
	
	public Register() {
		super();
		
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUserName(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}


	public String getTransactionPassword() {
		return transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

	public long getAccount_no() {
		return account_no;
	}

	public void setAccount_no(long account_no) {
		this.account_no = account_no;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public Register(String customerUsername, String customerPassword) {
		super();
		this.customerUsername = customerUsername;
		this.customerPassword = customerPassword;
	
	}

	

	public Register(String customerUsername, String customerPassword, String transactionPassword, long account_no) {
		super();
		this.customerUsername = customerUsername;
		this.customerPassword = customerPassword;
		this.transactionPassword = transactionPassword;
		this.account_no = account_no;
	}

	@Override
	public String toString() {
		return "Register [customerUsername=" + customerUsername + ", customerPassword=" + customerPassword
				+ ", transactionPassword=" + transactionPassword + ", account_no=" + account_no + "]";
	}
	
	
}
