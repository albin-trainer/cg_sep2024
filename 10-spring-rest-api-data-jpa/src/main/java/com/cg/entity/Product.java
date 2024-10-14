package com.cg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
public class Product {
	@Id
private int productId;
private String productName;
private float price;

}
