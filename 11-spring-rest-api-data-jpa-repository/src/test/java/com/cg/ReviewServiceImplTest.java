package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.entity.Product;
import com.cg.entity.Review;
import com.cg.exceptions.ApplicationException;
import com.cg.repository.ProductRepository;
import com.cg.repository.ReviewRepository;
import com.cg.request.dto.ReviewDto;
import com.cg.service.ReviewServiceImpl;

public class ReviewServiceImplTest {
	@Mock //creates dummy object
	private ProductRepository productRepo;
	@Mock
	private ReviewRepository reviewRepo;
	@InjectMocks
	private ReviewServiceImpl reviewService;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);  //all these mock created & initialize
	}
	ReviewDto dto=new ReviewDto();
	@Test
	public void addReviewTest() {
		Product p=new Product();
		p.setProductId(1);
		p.setPrice(100);
		p.setProductName("WaterBottle");
		
		ReviewDto dto=new ReviewDto();
		dto.setProdId(1);
		dto.setRatings(4);
		dto.setReview("Good");
		dto.setReviewerName("Mohan");
		//PRE-CONDITION
		when(productRepo.findById(1)).thenReturn(Optional.of(p));
	    Review r=reviewService.addReview(dto);
	   assertEquals(r.getReview(), dto.getReview());
	   assertEquals(r.getRatings(), dto.getRatings());
	   verify(reviewRepo,times(1)).save(r); //to verify save called or not ????
	}
	@Test
	public void addReviewTestNegative() {
		when(productRepo.findById(1)).thenReturn(Optional.empty());
		ApplicationException e=
			assertThrows(ApplicationException.class, ()->reviewService.addReview(dto));
		assertEquals(e.getMessage(), "Incorrect pid");
	}
}
