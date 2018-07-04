package com.bridgelabz.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bridgelabz.model.User;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ServiceLogic {
	static Connection con = null;
	ResultSet rs = null;
	static PreparedStatement pst = null;
	static MysqlDataSource dataSource = null;
  
	public static int saveObject(User user) {
		int flag = 0;
		String query1 = "insert into login_register values(?,?,?,?,?)";
		try {
			dataSource = Connect.getConnection();
			con = dataSource.getConnection();
			pst = con.prepareStatement(query1);

			pst.setString(1, user.getFirstname());
			pst.setString(2, user.getLastname());
			pst.setString(3, user.getEmail());
			pst.setString(4, user.getMobileNo());
			pst.setString(5, user.getPassword());
           
			flag = pst.executeUpdate();
			System.out.println("details received");
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}
}

