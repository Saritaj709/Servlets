package com.bridgelabz.model;

public class User {
private String firstname;
private String lastname;
private String email;
private String password;
private String mobileNo;
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastName) {
	this.lastname = lastName;
}
public String getEmail() {
	return email;
}
public String setEmail(String email) {
	return this.email = email;
}
public String getPassword() {
	return password;
}
public String setPassword(String password) {
	return this.password = password;
}
public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}
@Override
public String toString() {
	return "User [firstname=" + firstname + ", lastName=" + lastname + ", email=" + email + ", password=" + password
			+ ", mobileNo=" + mobileNo + "]";
}

}
