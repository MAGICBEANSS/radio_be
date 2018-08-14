package com.example.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="USER_DETAILS")
@DiscriminatorValue("P")
//@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)


public class userDetails {
	@Column(unique=true)
	private String email;
	
	@Id 
	@GenericGenerator(name="seq_id_", strategy="com.example.StockCodeGenerator")
	@GeneratedValue(generator="seq_id_")
	@Column(name="userId")
	private String uid;
	private String password;
	private String firstName;
	private String lastName;
	private String token;
	private Date lastLogin;
	private String usertype;
	private String provider;
	
	private boolean isActive = true;
	
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "userDetails [isActive()=" + isActive() + ", getEmail()=" + getEmail() + ", getUsertype()="
				+ getUsertype() + ", getProvider()=" + getProvider() + ", getUid()=" + getUid() + ", getPassword()="
				+ getPassword() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getToken()=" + getToken() + ", getLastLogin()=" + getLastLogin() + "]";
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
}
