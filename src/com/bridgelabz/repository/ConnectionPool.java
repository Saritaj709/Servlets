package com.bridgelabz.repository;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnectionPool {
	static MysqlDataSource dataSource=null;
	public MysqlDataSource getConnection() {
		
		try {
			 dataSource=new MysqlDataSource();
			String JDBC_DB_URL = "jdbc:mysql://localhost:3306/JDBC";

			String JDBC_USER = "root";
			String JDBC_PASS = "root";
			dataSource.setUrl(JDBC_DB_URL);
			dataSource.setUser(JDBC_USER);
			dataSource.setPassword(JDBC_PASS);
			System.out.println("Connection established");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return dataSource;
	}
}
