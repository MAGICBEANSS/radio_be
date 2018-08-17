package com.example.controller;

import java.sql.SQLDataException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.admin_details;
import com.example.entity.userDetails;
import com.example.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
@Autowired
AdminService adminservice;
	
	@RequestMapping("/details")
		ResponseEntity<String> saveadmindetails(@RequestBody admin_details admin_details) {
		System.out.println("Admin Details");
		try {
		
			 ResponseEntity<String> rt = new  ResponseEntity<String>(HttpStatus.CHECKPOINT);
			rt = this.adminservice.saveadminDetails(admin_details);
			System.out.println("return from controller "+rt.getBody());
			return rt;
		} catch (SQLDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error");
			return null;
		}
	}
}
