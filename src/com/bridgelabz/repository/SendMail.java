package com.bridgelabz.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class SendMail {
	public static void send(String to, final String user, final String pass) {
		// Create an instance of properties of class
		MysqlDataSource dataSource = null;
		Properties properties = new Properties();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String query = "select password from login_register where email=?";
		String message = null;
		
		ConnectionPool connectionPool=new ConnectionPool();
		/**
		 * Specifies IP address of your default mail server for e.g. if you are using
		 * gmail server as an email server you will pass smtp.gmail.com as value of
		 * mail.smtp host.As shown here in the code.Change accordingly,if your email id
		 * is not a valid email id
		 */
		properties.put("mail.smtp.host","smtp.gmail.com");
		// below mentioned mail.smtp.port is optional
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		/**
		 * Pass Properties object(properties) and Authenticator object for
		 * authentication Session instance
		 */
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});
		try {
			/**
			 * create an instance of mime message,it accepts MIME types and headers
			 */
			dataSource = connectionPool.getConnection();
			con = dataSource.getConnection();
			pst = con.prepareStatement(query);
			pst.setString(1, to);
			rs = pst.executeQuery();
			while (rs.next()) {
				message = rs.getString("password");
			}
			MimeMessage mime = new MimeMessage(session);
			mime.setFrom(new InternetAddress(user));
			mime.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			mime.setText(message);
			/*
			 * Transport class is used to send message to the recipients
			 */
			Transport.send(mime);
			System.out.println("message sent successfully");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
