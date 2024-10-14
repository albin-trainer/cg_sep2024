package com.cg.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
import com.cg.entity.Product;
import com.cg.exceptions.ApplicationException;
@Service
public class ProductServiceImplementation  implements ProductService{
//ASSUME these data pulled from DB
	List<Product> plist= new ArrayList<>();
	{
		plist.add(new Product(1, "Laptop", 50000));
		plist.add(new Product(2, "T Shirt", 1000));
		plist.add(new Product(3, "Mobile", 15000));
		plist.add(new Product(4, "WaterBottle", 400));
		plist.add(new Product(5, "Shoes", 2000));
	}
	@Override
	public Product addNewProduct(Product p) {
		plist.add(p);
		return p;
	}

	@Override
	public List<Product> allProducts() {
		return plist;
	}

	@Override
	public Product updateProduct(Product p, int prodId) {
		int index=0;
		//logic to find the index of the prodId in the list
		plist.set(index, p);
		return null;
	}

	@Override
	public Product searchById(int prodId) {
		Predicate<Product> predicate=
				p->p.getProdId()==prodId;
		Optional<Product> optional=
				plist.stream().
				filter(predicate).findFirst();
		if(optional.isPresent())
			return optional.get();
		else
			throw new ApplicationException("Product id "+prodId+" not found");
	}

	@Override
	public void deleteProduct(int prodId) {
		// TODO Auto-generated method stub
		//plist.removeIf(null);
	}

	@Override
	public List<Product> searchByPriceMoreThan(float price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> searchByPriceLessThan(float price) {
		// TODO Auto-generated method stub
		return plist.stream().filter(p->p.getPrice()<=price).toList();
	}

}
