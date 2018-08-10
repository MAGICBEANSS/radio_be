package com.example.controller;

import java.sql.SQLDataException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.userDetails;
import com.example.service.RegistrationService;

@RestController
public class Registration {
	
	@Autowired
	RegistrationService registrationService;
	
	@ResponseBody
	@RequestMapping(value="/user/registration", method= RequestMethod.POST, produces = "application/json")
	public userDetails userRegistration(@RequestBody userDetails userDetails) {
		System.out.println("User Registration");
		try {
			System.out.println("User Registration1");
			return this.registrationService.saveUserDetails(userDetails);
		} catch (SQLDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error");
			return null;
		}
	}
	
	@ResponseBody
	@RequestMapping(value="/login", method= RequestMethod.POST	,consumes="application/json")
	public ResponseEntity<String> checkLogin(@RequestBody userDetails userdetails) {
		try {
			return this.registrationService.checkLogin(userdetails);
		} catch (SQLDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
}
