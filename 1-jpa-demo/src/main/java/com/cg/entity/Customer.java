package com.cg.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity//mandatory
@Table(name="CUST_INFO")//optional
public class Customer {
	@Id//mandatory
	@Column(name="cid")//optional
private int custId;
	@Column(name="cname",length = 20)
private String custName;
	@Column(unique = true)
private String email;
//in default , it takes from 0,1,2,3...
@Enumerated(EnumType.STRING)
private Gender gender;
@Embedded
private Address address;
@Transient
private  String nameEmail;

public String getNameEmail() {
	return nameEmail;
}
public void setNameEmail(String nameEmail) {
	this.nameEmail = nameEmail;
}
public Gender getGender() {
	return gender;
}
public void setGender(Gender gender) {
	this.gender = gender;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}
