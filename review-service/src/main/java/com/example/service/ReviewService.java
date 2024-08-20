package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.entity.Review;
import com.example.doa.repo.ReviewRepositoryImpl;
import com.example.model.ReviewResponse;

@Service
@Transactional
public class ReviewService {

	@Autowired
	private ReviewRepositoryImpl reviewRepository;

	public ReviewResponse createNewReview(ReviewResponse response) {
		Review review = convertReviewFromReviewResponse(response);
		review = reviewRepository.createNewReview(review);
		response.setId(review.getId());
		return response;
	}

	public List<ReviewResponse> getAllReviewList() {
		return reviewRepository.getAllReviewsList().stream().map(this::convertReviewResponseFromReview).collect(Collectors.toList());
	}

	public List<ReviewResponse> getAllReviewListByCompanyId(String companyId) {
		return reviewRepository.getReviewsListByCompanyId(companyId).stream().map(this::convertReviewResponseFromReview).collect(Collectors.toList());
	}

	private Review convertReviewFromReviewResponse(ReviewResponse rev) {
		Review review = Review.builder().id(rev.getId()).title(rev.getTitle()).companyId(rev.getCompanyId())
				.rating(rev.getRating()).description(rev.getDescription()).build();
		return review;
	}

	private ReviewResponse convertReviewResponseFromReview(Review rev) {
		ReviewResponse review = ReviewResponse.builder().id(rev.getId()).title(rev.getTitle())
				.companyId(rev.getCompanyId()).rating(rev.getRating()).description(rev.getDescription()).build();
		return review;
	}

}
