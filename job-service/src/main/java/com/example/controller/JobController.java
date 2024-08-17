package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ApiResponse;
import com.example.model.JobResponse;
import com.example.service.JobService;

@RestController
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	@GetMapping("/jobs")
	public ResponseEntity<ApiResponse<List<JobResponse>>> getAllJobsList(){
		List<JobResponse> jobResponse = jobService.getAllJobsList();
		ApiResponse<List<JobResponse>> response = new ApiResponse<List<JobResponse>>(true, jobResponse);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/jobs/{id}")
	public ResponseEntity<ApiResponse<JobResponse>> getJobsById(@PathVariable("id") String jobId){
		JobResponse jobResponse = jobService.getJobsById(jobId);
		ApiResponse<JobResponse> response = new ApiResponse<>(true, jobResponse);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/jobs")
	public ResponseEntity<ApiResponse<JobResponse>> creatingNewJob(@RequestBody JobResponse job){
		JobResponse jobResponse = jobService.creatingNewJob(job);
		ApiResponse<JobResponse> response = new ApiResponse<>(true, jobResponse);
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/jobs/{id}")
	public ResponseEntity<ApiResponse<String>> deleteJobByJobId(@PathVariable("id") String jobId){
		String jobResponse = jobService.deleteJobByJobId(jobId);
		ApiResponse<String> response = new ApiResponse<>(true, jobResponse);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/jobs/{id}")
	public ResponseEntity<ApiResponse<JobResponse>> updateJobWithNewDetails(@PathVariable String id,@RequestBody JobResponse job){
		boolean result = jobService.updateJobDetails(id, job); 
		ApiResponse<JobResponse> response = new ApiResponse<>(true, job);
		return ResponseEntity.ok(response);
	}
}
