package com.cg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
public static Connection getConnect() {
	Connection con=null;
	try {
	
		//FOR MYSQL
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3307/aug_2024";
		String uname="root";
		String pwd="root";
		 con=DriverManager.getConnection(url,uname,pwd);
		System.out.println("Connected with mysql");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return con;
}
}
