package com.cg.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.entity.Product;
public interface ProductRepository  extends JpaRepository<Product, Integer>{
	//query methods...
	List<Product> findByPriceGreaterThanEqual(float price);
	List<Product> findByPriceLessThanEqual(float price);
}