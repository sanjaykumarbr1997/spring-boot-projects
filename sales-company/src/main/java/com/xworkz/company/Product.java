package com.xworkz.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Long id;
	@Column(name="product_name")
	private String name;
	@Column(name="product_brand")
	private String brand;
	@Column(name="product_made_in")
	private String madeIn;
	@Column(name="product_price")
	private float price;
	
	

}
