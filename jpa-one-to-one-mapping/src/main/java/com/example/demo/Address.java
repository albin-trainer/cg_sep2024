package com.example.demo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity

public class Address {
	@Id
	private int addrid;
	private String place;
	@OneToOne
	private Student student;
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public Address(int addrid, String place, Student student) {
		super();
		this.addrid = addrid;
		this.place = place;
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getAddrid() {
		return addrid;
	}
	public void setAddrid(int addrid) {
		this.addrid = addrid;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
}
