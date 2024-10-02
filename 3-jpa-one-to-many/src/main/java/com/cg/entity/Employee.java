package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
	@Id
private int empId;
private String empName;
private float salary;
@ManyToOne //mandatory
//in defalt the colname
//is dept_deptId
//@JoinColumn only for FKs
@JoinColumn(name="deptId")//optional
private Department dept;


public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}
public Department getDept() {
	return dept;
}
public void setDept(Department dept) {
	this.dept = dept;
}

}
