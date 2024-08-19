package com.example.dao.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.entity.Company;


@Repository
public class CompanyRepositoryImpl {
	
	@Autowired
	private CompanyJPARepository companyRepository;

	public Company createNewCompany(Company company) {
		company = companyRepository.save(company);
		return company;
	}

	public List<Company> getAllCompanyList() {
		List<Company> company = companyRepository.findAll();
		return company;
	}

	public Company getCompanyById(String companyId) {
		Company company = companyRepository.findById(companyId).orElse(null);
		return company;
	}

	public Company updateExistingCompanyDetails(Company company, String companyId) {
		Optional<Company> companyOptional = companyRepository.findById(companyId);
		if(companyOptional.isPresent()) {
			companyRepository.save(company);
		}
		return company;
	}
}
