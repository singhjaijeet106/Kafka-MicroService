package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.repo.entity.Job;

public interface JobRepository extends JpaRepository<Job, String> {

}
