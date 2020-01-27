package com.lti.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="transactions")
public class Transactions {
	
@Id
@Column(name="transaction_id")
private int transactionId ;
@Column(name="mode_of_payment")
private String modeOfPayment;
@Column(name="amount_credit_debit")
private int amountCreditDebit;
@Column(name="transaction_status")
private String transactionStatus;
@Column(name="beneficiary_ifsc")
private String beneficiaryIfsc;
@Column(name=" transaction_date")

private Date transactionDate;
@JoinColumn(name="beneficiary_account_no")
private int beneficiaryAccountNo ;
@JoinColumn(name=" account_no")
private int  accountNo;
@JoinColumn(name=" branch_ifsc")
private String branchIfsc;

public int getTransactionId() {
	return transactionId;
}
public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}
public String getModeOfPayment() {
	return modeOfPayment;
}
public void setModeOfPayment(String modeOfPayment) {
	this.modeOfPayment = modeOfPayment;
}
public int getAmountCreditDebit() {
	return amountCreditDebit;
}
public void setAmountCreditDebit(int amountCreditDebit) {
	this.amountCreditDebit = amountCreditDebit;
}
public String getTransactionStatus() {
	return transactionStatus;
}
public void setTransactionStatus(String transactionStatus) {
	this.transactionStatus = transactionStatus;
}
public String getBeneficiaryIfsc() {
	return beneficiaryIfsc;
}
public void setBeneficiaryIfsc(String beneficiaryIfsc) {
	this.beneficiaryIfsc = beneficiaryIfsc;
}
public Date getTransactionDate() {
	return transactionDate;
}
public void setTransactionDate(Date transactionDate) {
	this.transactionDate = transactionDate;
}
public int getBeneficiaryAccountNo() {
	return beneficiaryAccountNo;
}
public void setBeneficiaryAccountNo(int beneficiaryAccountNo) {
	this.beneficiaryAccountNo = beneficiaryAccountNo;
}
public int getAccountNo() {
	return accountNo;
}
public void setAccountNo(int accountNo) {
	this.accountNo = accountNo;
}
public String getBranchIfsc() {
	return branchIfsc;
}
public void setBranchIfsc(String branchIfsc) {
	this.branchIfsc = branchIfsc;
}
public Transactions(int transactionId, String modeOfPayment, int amountCreditDebit, String transactionStatus,
		String beneficiaryIfsc, Date transactionDate, int beneficiaryAccountNo, int accountNo, String branchIfsc) {
	super();
	this.transactionId = transactionId;
	this.modeOfPayment = modeOfPayment;
	this.amountCreditDebit = amountCreditDebit;
	this.transactionStatus = transactionStatus;
	this.beneficiaryIfsc = beneficiaryIfsc;
	this.transactionDate = transactionDate;
	this.beneficiaryAccountNo = beneficiaryAccountNo;
	this.accountNo = accountNo;
	this.branchIfsc = branchIfsc;
}
@Override
public String toString() {
	return "Transactions [transactionId=" + transactionId + ", modeOfPayment=" + modeOfPayment + ", amountCreditDebit="
			+ amountCreditDebit + ", transactionStatus=" + transactionStatus + ", beneficiaryIfsc=" + beneficiaryIfsc
			+ ", transactionDate=" + transactionDate + ", beneficiaryAccountNo=" + beneficiaryAccountNo + ", accountNo="
			+ accountNo + ", branchIfsc=" + branchIfsc + "]";
}
public Transactions() {
	super();
}


}
	