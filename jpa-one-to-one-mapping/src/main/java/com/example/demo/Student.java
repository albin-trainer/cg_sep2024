package com.example.demo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Stud")
public class Student {
	@Id
private int id;
private String sname;
@OneToOne(mappedBy = "student",cascade = { CascadeType.PERSIST,CascadeType.REMOVE})
@JoinColumn(name="addrId")
private Address address;
public Student() {
	// TODO Auto-generated constructor stub
}
public Address getAddress() {
	return address;
}


public void setAddress(Address address) {
	this.address = address;
}


public Student(int id, String sname, Address address) {
	super();
	this.id = id;
	this.sname = sname;
	this.address = address;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}

}
