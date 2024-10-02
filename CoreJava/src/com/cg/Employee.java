package com.cg;
import java.time.LocalDate;

public class Employee {
private int empId;
private String empName;
private float salary;
private int phoneNo;
private LocalDate dob;
private String address;
private String email;
private LocalDate doj;
private int deptId;
public Employee() {
}
public Employee(int empId, String empName, float salary, int phoneNo, LocalDate dob, String address, String email,
		LocalDate doj, int deptId) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.salary = salary;
	this.phoneNo = phoneNo;
	this.dob = dob;
	this.address = address;
	this.email = email;
	this.doj = doj;
	this.deptId = deptId;
}
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
public int getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(int phoneNo) {
	this.phoneNo = phoneNo;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public LocalDate getDoj() {
	return doj;
}
public void setDoj(LocalDate doj) {
	this.doj = doj;
}
public int getDeptId() {
	return deptId;
}
public void setDeptId(int deptId) {
	this.deptId = deptId;
}

}
