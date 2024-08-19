package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.entity.Company;
import com.example.dao.repo.CompanyJPARepository;
import com.example.dao.repo.CompanyRepositoryImpl;
import com.example.model.CompanyResponse;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CompanyService {
	
	@Autowired
	private CompanyRepositoryImpl companyRepository;
	
	public CompanyResponse createNewCompany(CompanyResponse companyResponse) {
		String companyId = UUID.randomUUID().toString();
		companyResponse.setId(companyId);
		Company company = convertCompanyFromCompanyResponse(companyResponse);
		company = companyRepository.createNewCompany(company);
		return companyResponse;
	}

	public List<CompanyResponse> getAllCompanyList() {
		List<CompanyResponse> companyResponse = companyRepository.getAllCompanyList().stream().map(this::convertCompanyResponseFromCompany).collect(Collectors.toList());
		return companyResponse;
	}

	public CompanyResponse getCompanyById(String companyId) {
		CompanyResponse companyResponse = null;
		Company company = companyRepository.getCompanyById(companyId);
		if(company!=null) {
			companyResponse = convertCompanyResponseFromCompany(company);
		}
		return companyResponse;
	}
	

	public CompanyResponse updateExistingCompanyDetails(CompanyResponse companyResponse, String companyId) {
		Company company = convertCompanyFromCompanyResponse(companyResponse);
		company = companyRepository.updateExistingCompanyDetails(company, companyId);
		companyResponse = convertCompanyResponseFromCompany(company);
		return companyResponse;
	}
	
	private Company convertCompanyFromCompanyResponse(CompanyResponse com) {
		Company company = Company.builder()
				.id(com.getId())
				.description(com.getDescription())
				.name(com.getName())
				.build();
				return company;
	}
	
	private CompanyResponse convertCompanyResponseFromCompany(Company com) {
		CompanyResponse company = CompanyResponse.builder()
				.id(com.getId())
				.description(com.getDescription())
				.name(com.getName())
				.build();
				return company;
	}
}
