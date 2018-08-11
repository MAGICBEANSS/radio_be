package com.example.repository;

import java.sql.SQLDataException;

import org.springframework.http.ResponseEntity;

import com.example.entity.userDetails;

public interface RegistrationDAO {
	
	public userDetails saveUserDetails(userDetails userDetails) throws SQLDataException;
	public ResponseEntity<String> checkLogin(userDetails userDetails) throws SQLDataException;

}
