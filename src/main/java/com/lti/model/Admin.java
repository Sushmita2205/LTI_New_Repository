package com.lti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(scopeName="prototype")
@Entity
@Table(name="admin1")
public class Admin {
@Id
@Column(name="admin_id")
private String adminId;
@Column(name="admin_password")
private String adminPassword;

public Admin() {
	super();

}
public Admin(String adminId, String adminPassword) {
	super();
	this.adminId = adminId;
	this.adminPassword = adminPassword;
}
@Override
public String toString() {
	return "Admin [adminId=" + adminId + ", adminPassword=" + adminPassword + "]";
}
public String getAdminId() {
	return adminId;
}
public void setAdminId(String adminId) {
	this.adminId = adminId;
}
public String getAdminPassword() {
	return adminPassword;
}
public void setAdminPassword(String adminPassword) {
	this.adminPassword = adminPassword;
}


	
}
