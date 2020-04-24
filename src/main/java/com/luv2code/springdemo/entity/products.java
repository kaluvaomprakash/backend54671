package com.luv2code.springdemo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "products")
public class products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "hacker_id")
	private int hackerId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_price")
	private String productPrice;
	@Column(name = "product_type")
	private String productType;
	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDate createdDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHackerId() {
		return hackerId;
	}

	public void setHackerId(int hackerId) {
		this.hackerId = hackerId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "products [id=" + id + ", hackerId=" + hackerId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", productType=" + productType + ", createdDate=" + createdDate + "]";
	}

}
