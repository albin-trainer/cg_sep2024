package com.cg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
private int productId;
private String productName;
private float price;
private String portNo;

}
