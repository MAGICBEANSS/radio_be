package com.example.entity;


public class ForgotPassword {
String email;
String emailhex;
String link;
public String getEmail() {
	return email;
}
@Override
public String toString() {
	return "ForgotPassword [getEmail()=" + getEmail() + ", getEmailhex()=" + getEmailhex() + ", getLink()=" + getLink()
			+ "]";
}
public void setEmail(String email) {
	this.email = email;
}
public String getEmailhex() {
	return emailhex;
}
public void setEmailhex(String emailhex) {
	this.emailhex = emailhex;
}
public String getLink() {
	return link;
}
public void setLink(String link) {
	this.link = link;
}
}
