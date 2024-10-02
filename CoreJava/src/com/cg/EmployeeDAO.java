package com.cg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmployeeDAO {
public static void main(String[] args) {
	Employee e=
			new Employee(111, "Vinish", 60000, 678904356, 
			LocalDate.of(2002, 10, 10), "Bangalore", "vinish@abc.com", LocalDate.of(2024, 8, 27), 10001);
	addNewEmployee(e);
}
static void addNewEmployee(Employee e) {
	Connection con=DBConnection.getConnect();
	String sql="insert into Employee values(?,?,?,?,?,?,?,?,?)";
	try {
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setInt(1, e.getEmpId());
		stmt.setString(2, e.getEmpName());
		stmt.setFloat(3, e.getSalary());
		stmt.setInt(4, e.getPhoneNo());
		//LocalDate --> into java.sql.DAte
		stmt.setDate(5, java.sql.Date.valueOf(e.getDob()));
		stmt.setString(6, e.getAddress());
		stmt.setString(7, e.getEmail());
		stmt.setDate(8,java.sql.Date.valueOf(e.getDoj()));
		stmt.setInt(9, e.getDeptId());
		int c=stmt.executeUpdate();
		System.out.println(c+" no of rows affected...");
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
}
