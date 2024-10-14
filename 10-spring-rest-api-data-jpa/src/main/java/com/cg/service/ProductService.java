package com.cg.service;

import java.util.List;

import com.cg.entity.Product;

public interface ProductService {
Product addNewProductService(Product p);
List<Product> allProductsService();
Product updateProductService(Product p,int prodId);
Product searchByIdService(int prodId);
void deleteProduct(int prodId);
List<Product> searchByPriceMoreThanService(float price);
List<Product> searchByPriceLessThanService(float price);

}
