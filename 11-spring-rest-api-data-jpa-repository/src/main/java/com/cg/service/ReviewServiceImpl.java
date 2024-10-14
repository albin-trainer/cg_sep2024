package com.cg.service;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Product;
import com.cg.entity.Review;
import com.cg.exceptions.ApplicationException;
import com.cg.repository.ProductRepository;
import com.cg.repository.ReviewRepository;
import com.cg.request.dto.ReviewDto;
@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewRepository reviewRepo;
	@Autowired
	private ProductRepository productRepo;
	public Review addReview(ReviewDto reviewDto) {
		Product p=productRepo.findById(reviewDto.getProdId()).orElseThrow(()-> new ApplicationException("Incorrect pid"));
		Review r=new Review();
		BeanUtils.copyProperties(reviewDto, r);
		r.setProduct(p);
		r.setDateOfReview(LocalDate.now());
		reviewRepo.save(r);
		return r;
	}
}
