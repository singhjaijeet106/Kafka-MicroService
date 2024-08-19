package com.example.dao.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dao.entity.Company;

public interface CompanyJPARepository extends JpaRepository<Company, String> {

}
