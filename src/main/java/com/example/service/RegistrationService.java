package com.example.service;

import java.sql.SQLDataException;

import org.springframework.http.ResponseEntity;

import com.example.entity.userDetails;

public interface RegistrationService {

	public userDetails saveUserDetails(userDetails userDetails) throws SQLDataException;
	public ResponseEntity<String> checkLogin(userDetails userdetails) throws SQLDataException;
}
