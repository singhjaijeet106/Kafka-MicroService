package com.example.doa.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.dao.entity.Review;

public interface ReviewMongoRepository extends MongoRepository<Review, String>{

	@Query("{companyId:?0}")
	List<Review> getAllReviewsByCompanyId(String companyId);
}
