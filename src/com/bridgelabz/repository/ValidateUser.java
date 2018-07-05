package com.bridgelabz.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ValidateUser {
   public String validateUser(String email,String password) throws SQLException {
	PreparedStatement pst = null;
	ResultSet rs = null;
	Connection con = null;
   MysqlDataSource dataSource=null;
  ConnectionPool connectionPool=new ConnectionPool();

	String query = "select * from register where email=? and password=?";

	pst = con.prepareStatement(query);
	pst.setString(1, email);
	pst.setString(2, password);
	rs = pst.executeQuery();
	return email;
}
}
