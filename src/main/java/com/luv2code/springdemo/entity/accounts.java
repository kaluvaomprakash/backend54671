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
@Table(name="accounts")
public class accounts {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="hacker_id")//[{"customerId":210,"paymentType":"cash","amount":0,"paymentDate":"2020-04-21","isActive":1,"productId":28,"customerProductId":123,"year":2020}]
	private int hackerId;
	@Column(name="customer_id")
	private int customerId;
	@Column(name="customer_product_id")
	private int customerProductId;
	@Column(name="product_id")
	private int productId;
	@Column(name="month")
	private String month;
	@Column(name="year")
	private int year;
	@Column(name="payment_type")
	private String paymentType;
	@Column(name="amount")
	private int amount;
	@Column(name="payment_date")
	private String paymentDate;
	@CreationTimestamp
	@Column(name = "created_date",nullable = false, updatable = false)
	private LocalDate created_date;
	@Column(name="is_active")
	private int isActive;
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
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCustomerProductId() {
		return customerProductId;
	}
	public void setCustomerProductId(int customerProductId) {
		this.customerProductId = customerProductId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public LocalDate getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "accounts [id=" + id + ", hackerId=" + hackerId + ", customerId=" + customerId + ", customerProductId="
				+ customerProductId + ", productId=" + productId + ", month=" + month + ", year=" + year
				+ ", paymentType=" + paymentType + ", amount=" + amount + ", paymentDate=" + paymentDate
				+ ", created_date=" + created_date + ", isActive=" + isActive + "]";
	}
	
	
	
	
}
