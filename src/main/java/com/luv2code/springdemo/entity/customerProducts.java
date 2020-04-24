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
@Table(name = "customer_products")
public class customerProducts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "hacker_id")
	private int hackerId;
	@Column(name = "customer_id")
	private int customerId;
	@Column(name = "product_id")
	private int productId;
	@Column(name = "month")
	private String pMonth;
	@Column(name = "year")
	private int year;
	@Column(name = "month_days")
	private int monthDays;
	@Column(name = "month_week_days")
	private int monthWeekDate;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_monthly_price")
	private double productMonthlyPrice;
	@Column(name = "product_addational_charges")
	private int productAddationalCharges;
	@Column(name = "product_type")
	private String productType;
	@Column(name = "product_start_date")
	private String productStartDate;
	@Column(name = "product_end_date")
	private String productEndDate;
	@Column(name = "paid")
	private int paid;
	@Column(name = "is_recursive")
	private String isRecursive;
	@Column(name = "is_active")
	private int isActive;
	@Column(name = "hold_is_acitve")
	private int holdIsActive;
	@CreationTimestamp
	@Column(name = "created_date")
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

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getpMonth() {
		return pMonth;
	}

	public void setpMonth(String pMonth) {
		this.pMonth = pMonth;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonthDays() {
		return monthDays;
	}

	public void setMonthDays(int monthDays) {
		this.monthDays = monthDays;
	}

	public int getMonthWeekDate() {
		return monthWeekDate;
	}

	public void setMonthWeekDate(int monthWeekDate) {
		this.monthWeekDate = monthWeekDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductMonthlyPrice() {
		return productMonthlyPrice;
	}

	public void setProductMonthlyPrice(double productMonthlyPrice) {
		this.productMonthlyPrice = productMonthlyPrice;
	}

	public int getProductAddationalCharges() {
		return productAddationalCharges;
	}

	public void setProductAddationalCharges(int productAddationalCharges) {
		this.productAddationalCharges = productAddationalCharges;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductStartDate() {
		return productStartDate;
	}

	public void setProductStartDate(String productStartDate) {
		this.productStartDate = productStartDate;
	}

	public String getProductEndDate() {
		return productEndDate;
	}

	public void setProductEndDate(String productEndDate) {
		this.productEndDate = productEndDate;
	}

	public int getPaid() {
		return paid;
	}

	public void setPaid(int paid) {
		this.paid = paid;
	}

	public String getIsRecursive() {
		return isRecursive;
	}

	public void setIsRecursive(String isRecursive) {
		this.isRecursive = isRecursive;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getHoldIsActive() {
		return holdIsActive;
	}

	public void setHoldIsActive(int holdIsActive) {
		this.holdIsActive = holdIsActive;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "customerProducts [id=" + id + ", hackerId=" + hackerId + ", customerId=" + customerId + ", productId="
				+ productId + ", pMonth=" + pMonth + ", year=" + year + ", monthDays=" + monthDays + ", monthWeekDate="
				+ monthWeekDate + ", productName=" + productName + ", productMonthlyPrice=" + productMonthlyPrice
				+ ", productAddationalCharges=" + productAddationalCharges + ", productType=" + productType
				+ ", productStartDate=" + productStartDate + ", productEndDate=" + productEndDate + ", paid=" + paid
				+ ", isRecursive=" + isRecursive + ", isActive=" + isActive + ", holdIsActive=" + holdIsActive
				+ ", createdDate=" + createdDate + "]";
	}

}
