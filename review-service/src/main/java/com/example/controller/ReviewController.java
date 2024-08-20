package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ApiResponse;
import com.example.model.ReviewResponse;
import com.example.service.ReviewService;

@RestController
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;

	@PostMapping("/reviews")
	public ResponseEntity<ApiResponse<ReviewResponse>> createNewReview(@RequestBody ReviewResponse review){
		review = reviewService.createNewReview(review);
		ApiResponse<ReviewResponse> response = new ApiResponse<>(true,review); 
		ResponseEntity<ApiResponse<ReviewResponse>> responseEntity = new ResponseEntity<ApiResponse<ReviewResponse>>(response, HttpStatus.CREATED);
		return responseEntity;
	}
	
	@GetMapping("/reviews")
	public ResponseEntity<ApiResponse<List<ReviewResponse>>> getAllReviewList(){
		List<ReviewResponse> reviewResponses = reviewService.getAllReviewList();
		ApiResponse<List<ReviewResponse>> response = new ApiResponse<>(true,reviewResponses);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/reviews/company/{id}")
	public ResponseEntity<ApiResponse<List<ReviewResponse>>> getAllReviewListByCompanyId(@PathVariable String companyId){
		List<ReviewResponse> reviewResponses = reviewService.getAllReviewListByCompanyId(companyId);
		ApiResponse<List<ReviewResponse>> response = new ApiResponse<>(true,reviewResponses);
		return ResponseEntity.ok(response);
	}
}
