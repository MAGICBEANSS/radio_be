package com.example.service.Impl;

import java.sql.SQLDataException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entity.ForgotPassword;
import com.example.entity.LoginResponse;
import com.example.entity.userDetails;
import com.example.repository.RegistrationRepository;
import com.example.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService{
	
	@Autowired
	RegistrationRepository registrationRepository;

	public ResponseEntity<userDetails> saveUserDetails(userDetails userDetails) throws SQLDataException {
		return this.registrationRepository.saveUserDetails(userDetails);		
	}

	public ResponseEntity<LoginResponse> checkLogin(userDetails userdetails) throws SQLDataException {
		return this.registrationRepository.checkLogin(userdetails);
		
	}
	
	public ResponseEntity<Boolean> forgotpassword(ForgotPassword  requestobj) throws SQLDataException {
		return this.registrationRepository.forgotpassword(requestobj);
		
	}

}
