package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ApiResponse;
import com.example.model.CompanyResponse;
import com.example.service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

	@PostMapping("/companies")
	public ResponseEntity<ApiResponse<CompanyResponse>> createNewCompany(@RequestBody CompanyResponse company) {
		company = companyService.createNewCompany(company);
		ApiResponse<CompanyResponse> companyResponse = new ApiResponse<>(true,company);
		ResponseEntity<ApiResponse<CompanyResponse>> responseEntity = new ResponseEntity<ApiResponse<CompanyResponse>>(companyResponse, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/companies")
	public ResponseEntity<ApiResponse<List<CompanyResponse>>> getAllCompanyList() {
		List<CompanyResponse> companyResponses = companyService.getAllCompanyList();
		ApiResponse<List<CompanyResponse>> companyResponse = new ApiResponse<>(true,companyResponses);
		return ResponseEntity.ok(companyResponse);
	}

	@GetMapping("/companies/{id}")
	public ResponseEntity<ApiResponse<CompanyResponse>> getCompanyById(@PathVariable String id) {
		CompanyResponse company = companyService.getCompanyById(id);
		ApiResponse<CompanyResponse> companyResponse = new ApiResponse<>(true,company);
		return ResponseEntity.ok(companyResponse);
	}

	@PutMapping("/companies/{id}")
	public ResponseEntity<ApiResponse<CompanyResponse>> updateExistingCompanyDetails(@PathVariable String id, @RequestBody CompanyResponse company) {
		company = companyService.updateExistingCompanyDetails(company, id);
		ApiResponse<CompanyResponse> companyResponse = new ApiResponse<>(true,company);
		return ResponseEntity.ok(companyResponse);
	}
}
