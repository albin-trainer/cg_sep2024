package com.cg.repository;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.cg.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository//equivalent to @Component
public class ProductRepositoryImpl  implements ProductRepository{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	
	public Product addNewProduct(Product p) {
		em.persist(p);
		return p;
	}
	public List<Product> allProducts() {
		String jpql="select p from Product p";
		Query q=em.createQuery(jpql);
		List<Product> products=  q.getResultList();
		return products;
	}
	public List<Product> searchByPriceMoreThan(float price) {
		String jpql="select p from Product p where p.price >= :pr";
		Query q=em.createQuery(jpql);
		return q.getResultList();
	}
	
	public Product updateProduct(Product p, int prodId) {
		Product p1=em.find(Product.class, prodId); //Managed state.....
//		p1.setProductName(p.getProductName());
//		p1.setPrice(p.getPrice());
		BeanUtils.copyProperties(p, p1);
		return p1;
	}
	public Product searchById(int prodId) {
		return em.find(Product.class, prodId);
	}
	public void deleteProduct(int prodId) {
	Product p= em.find(Product.class, prodId);
	if(p!=null) em.remove(p);
	}
	

	@Override
	public List<Product> searchByPriceLessThan(float price) {
		// TODO Auto-generated method stub
		return null;
	}

}
