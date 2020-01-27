package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class RTGS {
	@Id
	@Column(name="rtgs_id")
	private int  rtgsId;
	@Column(name="no_of_transactions")
	private int noOfTransactions;
	@Column(name="maturity_instructions")
	private String maturityInstructions;
	@JoinColumn(name="account_no")
	private int accountNo ;
	@JoinColumn(name=" beneficiary_account_no")
	private int beneficiaryAccountNo;
	@JoinColumn(name="transaction_id")
	private int transactionId;
	public RTGS() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RTGS(int rtgsId, int noOfTransactions, String maturityInstructions, int accountNo, int beneficiaryAccountNo,
			int transactionId) {
		super();
		this.rtgsId = rtgsId;
		this.noOfTransactions = noOfTransactions;
		this.maturityInstructions = maturityInstructions;
		this.accountNo = accountNo;
		this.beneficiaryAccountNo = beneficiaryAccountNo;
		this.transactionId = transactionId;
	}
	public int getRtgsId() {
		return rtgsId;
	}
	public void setRtgsId(int rtgsId) {
		this.rtgsId = rtgsId;
	}
	public int getNoOfTransactions() {
		return noOfTransactions;
	}
	public void setNoOfTransactions(int noOfTransactions) {
		this.noOfTransactions = noOfTransactions;
	}
	public String getMaturityInstructions() {
		return maturityInstructions;
	}
	public void setMaturityInstructions(String maturityInstructions) {
		this.maturityInstructions = maturityInstructions;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getBeneficiaryAccountNo() {
		return beneficiaryAccountNo;
	}
	public void setBeneficiaryAccountNo(int beneficiaryAccountNo) {
		this.beneficiaryAccountNo = beneficiaryAccountNo;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	@Override
	public String toString() {
		return "RTGS [rtgsId=" + rtgsId + ", noOfTransactions=" + noOfTransactions + ", maturityInstructions="
				+ maturityInstructions + ", accountNo=" + accountNo + ", beneficiaryAccountNo=" + beneficiaryAccountNo
				+ ", transactionId=" + transactionId + "]";
	}
	
	
}
