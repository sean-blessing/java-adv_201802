package com.pma.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String code;
	private String description;
	@Column(name="ListPrice")
	private double price;
	
	public Product(int id, String code, String description, double price) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.price = price;
	}

	public Product() {
		super();
	}

	public Product(String code2, String description2, double price2) {
		code = code2;
		description = description2;
		price = price2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", description=" + description + ", price=" + price + "]";
	}
	
}
