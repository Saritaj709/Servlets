package com.bridgelabz.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.model.User;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class UserRepository {
	ConnectionPool connectionPool = new ConnectionPool();

	public int saveObject(User user) {
		Connection con = null;
		PreparedStatement pst = null;
		MysqlDataSource dataSource = null;
		int flag = 0;
		String query1 = "insert into login_register values(?,?,?,?,?)";
		try {
			dataSource = connectionPool.getConnection();
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

	public boolean getUserByEmail(String email) throws SQLException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		MysqlDataSource dataSource = null;
		String query = "select email from login_register";
		dataSource = connectionPool.getConnection();
		con = dataSource.getConnection();
		pst = con.prepareStatement(query);
		rs = pst.executeQuery(query);
		while (rs.next()) {
			if (rs.getString(1).equals(email)) {
				System.out.println("The user exists");
				return true;
			}
		}
		return false;
	}

	public User validateUser(String email, String password) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection con = null;
		MysqlDataSource dataSource = null;
		ConnectionPool connectionPool = new ConnectionPool();
		User user = new User();

		String query = "select * from login_register where email=? and password=?";
		dataSource = connectionPool.getConnection();
		con = dataSource.getConnection();
		pst = con.prepareStatement(query);
		pst.setString(1, email);
		pst.setString(2, password);
		rs = pst.executeQuery();
		
		if(rs.next()) {
			System.out.println("user exists");
			user.setFirstname(rs.getString(1));
			user.setLastname(rs.getString(2));
			user.setEmail(rs.getString(3));
			user.setMobileNo(rs.getString(4));
			user.setPassword(rs.getString(5));
		
		System.out.println("user validated");
		
		}return user;
	}
	public ResultSet validate(String email, String password) throws SQLException {
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection con = null;
		MysqlDataSource dataSource = null;
		ConnectionPool connectionPool = new ConnectionPool();
		//User user = new User();

		String query = "select * from login_register where email=? and password=?";
		dataSource = connectionPool.getConnection();
		con = dataSource.getConnection();
		pst = con.prepareStatement(query);
		pst.setString(1, email);
		pst.setString(2, password);
		rs = pst.executeQuery();
		
		if(rs.next()) {
			
		System.out.println("user validated");
		
		}return rs;
	}
}
