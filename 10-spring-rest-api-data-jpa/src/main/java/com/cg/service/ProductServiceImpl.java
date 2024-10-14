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
	
	@Override
	
	public Product addNewProductService(Product p) {
		return prodRep.addNewProduct(p);
	}

	@Override
	public List<Product> allProductsService() {
		return prodRep.allProducts();
	}

	@Override
	public Product updateProductService(Product p, int prodId) {
		// TODO Auto-generated method stub
		return prodRep.updateProduct(p, prodId);
	}

	@Override
	public Product searchByIdService(int prodId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(int prodId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> searchByPriceMoreThanService(float price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchByPriceLessThanService(float price) {
		// TODO Auto-generated method stub
		return null;
	}

}
