package com.example.service.Impl;

import java.sql.SQLDataException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.entity.admin_details;
import com.example.repository.AdminRepo;
import com.example.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService, AdminRepo {

	@Autowired
	AdminRepo adminrepo;
	
	public ResponseEntity<String> saveadminDetails(admin_details admin_details) throws SQLDataException {
		// TODO Auto-generated method stub
		return this.adminrepo.saveadminDetails(admin_details);
	}

}
