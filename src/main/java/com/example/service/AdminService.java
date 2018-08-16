package com.example.service;

import java.sql.SQLDataException;

import org.springframework.http.ResponseEntity;

import com.example.entity.admin_details;
import com.example.entity.userDetails;


public interface AdminService {
	public ResponseEntity<String> saveadminDetails(admin_details admin_details) throws SQLDataException;

}
