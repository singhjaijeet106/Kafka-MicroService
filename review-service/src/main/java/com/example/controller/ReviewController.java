package com.example.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ApiResponse;
import com.example.model.ReviewResponse;

@RestController
public class ReviewController {

	@PostMapping("/reviews")
	public ResponseEntity<ApiResponse<ReviewResponse>> createNewReview(@RequestBody ReviewResponse response){
		return null;
	}
	
	@GetMapping("/reviews")
	public ResponseEntity<ApiResponse<List<ReviewResponse>>> getAllReviewList(){
		return null;
	}
	
	@GetMapping("/reviews/company/{id}")
	public ResponseEntity<ApiResponse<List<ReviewResponse>>> getAllReviewListByCompanyId(@PathVariable String companyId){
		return null;
	}
}
