package com.cg.service;
import java.util.List;
import com.cg.entity.Product;
public interface ProductService {
Product addNewProduct(Product p);
List<Product> allProducts();
Product updateProduct(Product p,int prodId);
Product searchById(int prodId);
void deleteProduct(int prodId);
List<Product> searchByPriceMoreThan(float price);
List<Product> searchByPriceLessThan(float price);
}
