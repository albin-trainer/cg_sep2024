package com.cg.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.entity.Review;
public interface ReviewRepository extends JpaRepository<Review, Integer>{
		//@Query(value = "select r from Review r where r.product.productId =:pid ")
	@Query(value = "select * from Review where pid = :pid", nativeQuery = true)
	  List<Review> getAllReviews(@Param("pid")  int productId);
}
