package com.servlets;
import java.sql.Connection;
import java.sql.DriverManager;
public class Dbconnection {
 public static Connection connect() throws Exception {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/serveletsdemo","root","System123@");
	 return con;
 }
}

