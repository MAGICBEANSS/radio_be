package com.example.repository;

import java.sql.SQLDataException;

import org.springframework.http.ResponseEntity;

import com.example.entity.ForgotPassword;
import com.example.entity.LoginResponse;
import com.example.entity.userDetails;

public interface RegistrationDAO {
	
	public ResponseEntity<userDetails> saveUserDetails(userDetails userDetails) throws SQLDataException;
	public ResponseEntity<LoginResponse> checkLogin(userDetails userDetails) throws SQLDataException;
	public ResponseEntity<Boolean> forgotpassword(ForgotPassword requestobj);

}
