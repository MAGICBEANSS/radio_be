package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "admin_details")
public class admin_details  {
	
	@Id
	@GenericGenerator(name="seq_id", strategy="com.example.DynamicAdminId")
	@GeneratedValue(generator="seq_id")
	@Column(name="adminid")
	private String adminid;
	private String userId; 
	private String playlist;
	public String getPlaylist() {
		return playlist;
	}

	public void setPlaylist(String playlist) {
		this.playlist = playlist;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
}
