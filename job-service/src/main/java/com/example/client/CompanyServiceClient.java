package com.example.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.model.ApiResponse;
import com.example.model.CompanyResponse;

@FeignClient(name = "COMPANY-SERVICE", path = "/company-service/api/")
public interface CompanyServiceClient {
	
	@PostMapping("/companies")
	public ResponseEntity<ApiResponse<CompanyResponse>> createNewCompany(@RequestBody CompanyResponse company);

	@GetMapping("/companies")
	public ResponseEntity<ApiResponse<List<CompanyResponse>>> getAllCompanyList();

	@GetMapping("/companies/{id}")
	public ResponseEntity<ApiResponse<CompanyResponse>> getCompanyById(@PathVariable String id);

	@PutMapping("/companies/{id}")
	public ResponseEntity<ApiResponse<CompanyResponse>> updateExistingCompanyDetails(@PathVariable String id, @RequestBody CompanyResponse company);
}
