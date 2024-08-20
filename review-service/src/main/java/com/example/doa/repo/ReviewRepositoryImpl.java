package com.example.doa.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dao.entity.Review;

@Repository
public class ReviewRepositoryImpl {
	@Autowired
	private ReviewMongoRepository repository;
	
	public Review createNewReview(Review review) {
		return repository.save(review);
	}
	
	public Review getReviewByReviewId(String reviewId) {
		Review review = repository.findById(reviewId).orElse(null);
		return review;
	}
	
	public List<Review> getAllReviewsList(){
		return repository.findAll();
	}
	
	
	public List<Review> getReviewsListByCompanyId(String companyId) {
		return repository.getAllReviewsByCompanyId(companyId);
	}
}
