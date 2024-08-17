package com.example.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ApiResponse;
import com.example.model.CompanyResponse;

@RestController
public class CompanyController {

	@PostMapping("/companies")
	public ResponseEntity<ApiResponse<CompanyResponse>> createNewCompany() {
		return null;
	}

	@GetMapping("/companies")
	public ResponseEntity<ApiResponse<List<CompanyResponse>>> getAllCompanyList() {
		return null;
	}

	@GetMapping("/companies/{id}")
	public ResponseEntity<ApiResponse<CompanyResponse>> getCompanyById() {
		return null;
	}

	@PutMapping("/companies/{id}")
	public ResponseEntity<ApiResponse<CompanyResponse>> updateExistingCompanyDetails() {
		return null;
	}
}
