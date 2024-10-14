package com.cg.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Review;
import com.cg.request.dto.ReviewDto;
import com.cg.service.ReviewService;

@RestController
@RequestMapping("/products/reviews")
public class ReviewApi {
	@Autowired
	private ReviewService reviewService;
	@PostMapping
public  ResponseEntity<Review> addNewReview(@RequestBody ReviewDto reviewDto) {
	 return new ResponseEntity<Review>(reviewService.addReview(reviewDto),HttpStatus.CREATED);
}
}
