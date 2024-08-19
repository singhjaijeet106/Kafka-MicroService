package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.ReviewResponse;

@Service
@Transactional
public class ReviewService {

	
	public ReviewResponse createNewReview(ReviewResponse response){
		return null;
	}
	
	public List<ReviewResponse> getAllReviewList(){
		return null;
	}

	public List<ReviewResponse> getAllReviewListByCompanyId(String companyId){
		return null;
	}
}
