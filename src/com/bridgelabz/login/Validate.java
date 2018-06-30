package com.bridgelabz.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate {
	public static boolean checkUser(String email, String password) {
		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql//localhost:3306/JDBC?user=root&password=root");
			PreparedStatement pst = con.prepareStatement("select * from login_register where email=? and password=?");
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			status = rs.next();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
