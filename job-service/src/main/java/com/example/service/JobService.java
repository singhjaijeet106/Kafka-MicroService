package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.client.CompanyServiceClient;
import com.example.model.ApiResponse;
import com.example.model.CompanyResponse;
import com.example.model.JobResponse;
import com.example.repo.JobRepositoryLogic;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class JobService {
	
	@Autowired
	private JobRepositoryLogic jobRepository;
	
	@Autowired
	private CompanyServiceClient companyClient;
	
	public List<JobResponse> getAllJobsList(){
		List<JobResponse> jobResponse = jobRepository.getAllJobResponse();
		return jobResponse;
	}
	
	public JobResponse getJobsById(String jobId){
		JobResponse jobResponse = jobRepository.getJobResponseByJobId(jobId);
		CompanyResponse companyResponse = getCompanyDetailByCompanyId(jobResponse.getCompany().getId());
		jobResponse.setCompany(companyResponse);
		return jobResponse;
	}
	
	public JobResponse creatingNewJob(JobResponse job){
		JobResponse jobResponse = jobRepository.saveJobDetails(job);
		return jobResponse;
	}
	
	public String deleteJobByJobId(String jobId){
		boolean res = jobRepository.deleteJobdetailsFromDB(jobId);
		String jobResponse = res?"Successfully removed from DB":"Not Done";
		return jobResponse;
	}
	
	public boolean updateJobDetails(String id,JobResponse jobResponse){
		boolean response = jobRepository.updateJobdetailsById(id, jobResponse);
		return response;
	}
	
	private CompanyResponse getCompanyDetailByCompanyId(String companyId) {
		CompanyResponse companyResponse=null;
		ApiResponse<CompanyResponse> apiResponse = companyClient.getCompanyById(companyId).getBody();
		companyResponse = apiResponse.getResponseInfo();
		return companyResponse;
	}
	
}
