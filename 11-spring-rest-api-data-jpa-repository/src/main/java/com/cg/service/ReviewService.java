package com.cg.service;
import com.cg.entity.Review;
import com.cg.request.dto.ReviewDto;
public interface ReviewService {
Review addReview(ReviewDto reviewDto);
}
