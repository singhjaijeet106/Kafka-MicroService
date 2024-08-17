package com.example.repo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.JobResponse;
import com.example.repo.entity.Job;


@Repository
public class JobRepositoryLogic {

	@Autowired
	private JobRepository jobRepository;

//	@Autowired
//	EntityManager entityManager;

	public JobResponse getJobResponseByJobId(String id) {

		Job job = jobRepository.findById(id).get();
		JobResponse jobResponse = JobResponse.builder().id(job.getId()).title(job.getTitle())
				.description(job.getDescription()).maxSalary(job.getMaxSalary()).minSalary(job.getMinSalary())
				.location(job.getLocation()).build();

		return jobResponse;
	}
	
	public List<JobResponse> getAllJobResponse() {
		List<JobResponse> jobResponse = null;
		List<Job> jobList = jobRepository.findAll();
		jobResponse = jobList.stream().map(job->convertJobToJobResponse(job)).collect(Collectors.toList());
		
		return jobResponse;
	}

	public JobResponse saveJobDetails(JobResponse jobResponse) {
		String jobId = UUID.randomUUID().toString();
		Job job = Job.builder().id(jobId).title(jobResponse.getTitle())
				.description(jobResponse.getDescription()).maxSalary(jobResponse.getMaxSalary())
				.minSalary(jobResponse.getMinSalary()).location(jobResponse.getLocation()).build();
		job = jobRepository.save(job);
		jobResponse.setId(jobId);
		return jobResponse;
	}

	public JobResponse getJobResponseByJobTitle(String title) {
		JobResponse jobResponse = null;
//
//		CriteriaBuilder criteriaBuilder =  entityManager.getCriteriaBuilder();
//		CriteriaQuery<Job> criteriaQuery = criteriaBuilder.createQuery(Job.class);
//		Root<Job> root = criteriaQuery.from(Job.class);

		// Conditions

//		Predicate condition = criteriaBuilder.greaterThan(root.get(""))

		return jobResponse;
	}
	
	
	public boolean deleteJobdetailsFromDB(String id) {
		boolean response=false;
		jobRepository.deleteById(id);
		response = true;
		return response;
	}
	
	public boolean updateJobdetailsById(String id,JobResponse jobResponse) {
		boolean response=false;
		
		Optional<Job> jobOptional = jobRepository.findById(id);
		if(jobOptional.isPresent()) {
			Job job = jobOptional.get();
			job.setLocation(jobResponse.getLocation());
			job.setMaxSalary(jobResponse.getMaxSalary());
			job.setMinSalary(jobResponse.getMinSalary());
			job.setTitle(jobResponse.getTitle());
			job.setDescription(jobResponse.getDescription());
			jobRepository.save(job);
		}
		response = true;
		return response;
	}
	
	private JobResponse convertJobToJobResponse(Job job) {
		return JobResponse.builder().id(job.getId()).title(job.getTitle())
				.description(job.getDescription()).maxSalary(job.getMaxSalary()).minSalary(job.getMinSalary())
				.location(job.getLocation()).build();
	}
	
	private Job convertJobResponseToJob(JobResponse job) {
		return Job.builder().id(job.getId()).title(job.getTitle())
				.description(job.getDescription()).maxSalary(job.getMaxSalary()).minSalary(job.getMinSalary())
				.location(job.getLocation()).build();
	}
}
