package com.cg.entity;

import lombok.Data;

@Data
public class Order {
private int productId;
private String productName;
private float price;
private String portNo;
private int quantity;
}
