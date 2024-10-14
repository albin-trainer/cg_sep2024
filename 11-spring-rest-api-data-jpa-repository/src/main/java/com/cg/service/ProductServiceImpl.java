package com.cg.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Product;
import com.cg.repository.ProductRepository;

import jakarta.transaction.Transactional;
@Service //Equivalent to @Component
@Transactional
public class ProductServiceImpl implements ProductService {
   @Autowired
	private ProductRepository prodRep;
	public Product addNewProductService(Product p) {
		return prodRep.save(p);
	}
	public List<Product> allProductsService() {
		 List<Product> products=prodRep.findAll();
		return products;
	}
	public Product updateProductService(Product p, int prodId) {
		if(prodRep.findById(prodId).isPresent()) {
			return prodRep.save(p);
		}
		throw new RuntimeException("Prod id not found");
	}
	@Override
	public Product searchByIdService(int prodId) {
		return prodRep.findById(prodId).orElseThrow(() -> new RuntimeException("Prod id not found"));
	}
	@Override
	public void deleteProduct(int prodId) {
		prodRep.deleteById(prodId);
	}
	@Override
	public List<Product> searchByPriceMoreThanService(float price) {
		return prodRep.findByPriceGreaterThanEqual(price);
	}
	@Override
	public List<Product> searchByPriceLessThanService(float price) {
		// TODO Auto-generated method stub
		return prodRep.findByPriceLessThanEqual(price) ;
	}

}
