package com.cg.api;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.Product;
import com.cg.service.ProductService;
@RestController// ==> @Controller + @ResponseBody
//@Controller
@RequestMapping("/products")
public class ProductsCatalougeApi {
	@Autowired
	private ProductService prodService;
	@GetMapping("/test")
	public String test() {
		return "TEST";
	}
	@GetMapping("/testproduct")
	//@ResponseBody
	public Product testProduct() {
		Product p=new Product(101, "T Shirt",1000);
		return p;
	}
	@PostMapping
	public   ResponseEntity<Product> addNewProduct(@RequestBody Product p) {
		return new ResponseEntity<Product>(prodService.addNewProduct(p),HttpStatus.CREATED );
	}
	@GetMapping
	public List<Product> getAllProducts(){
		return prodService.allProducts();
	}
	@GetMapping("/{prodId}") //client > http://localhost:8080/products/1
	public Product searchProductById(@PathVariable("prodId") int id) {
		return prodService.searchById(id);
	}
	@PutMapping("/{pid}")
	public Product updateProduct(@RequestBody Product p, @PathVariable  int pid) {
		return null;
	}
	@DeleteMapping("/{pid}")
	public ResponseEntity<Void> removeProduct(@PathVariable  int pid) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//http://localhost:8080/products/searchPricelessthan?price=1000
	@GetMapping("/searchPricelessthan")
	public    ResponseEntity<List<Product>>searchPriceLessThan(@RequestParam("price") float price){
		List<Product> products= prodService.searchByPriceLessThan(price);
		if(products.size()==0) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		 return new ResponseEntity<>(products,HttpStatus.OK);
	}
	
}
