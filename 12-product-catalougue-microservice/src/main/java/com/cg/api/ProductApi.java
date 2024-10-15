package com.cg.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Product;
import com.cg.service.ProductService;
@RestController
public class ProductApi {
	@Autowired
	private ProductService service;
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable int id){
		// code to check for authentication ....
		
		Product product=service.allProducts().stream().
				filter(p->p.getProductId()==id).findFirst().get();
		return new ResponseEntity<Product>(product,HttpStatus.OK);
		
	}
}
