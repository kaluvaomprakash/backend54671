package com.luv2code.springdemo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="customer_n")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="h_id")
    private int hackerId;
	@Column(name="line_id")
    private int lineId;
	@Column(name="mobile_number")
    private String mobileNumber;
	@Column(name="password")
    private String password;
	@Column(name="name")
	private String name;
	@Column(name="details")
    private String details;
	@Column(name="additional_charges")
	private int addationalCharges;
	@Column(name="total_amount")
    private double totalAmount;
	@Column(name="is_paid")
    private int customerPaid;
	@CreationTimestamp
	@Column(name = "created_date",nullable = false, updatable = false)
	private LocalDate createdDate;
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
	public int getLineId() {
		return lineId;
	}
	public void setLineId(int lineId) {
		this.lineId = lineId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getAddationalCharges() {
		return addationalCharges;
	}
	public void setAddationalCharges(int addationalCharges) {
		this.addationalCharges = addationalCharges;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getCustomerPaid() {
		return customerPaid;
	}
	public void setCustomerPaid(int customerPaid) {
		this.customerPaid = customerPaid;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", hackerId=" + hackerId + ", lineId=" + lineId + ", mobileNumber=" + mobileNumber
				+ ", password=" + password + ", name=" + name + ", details=" + details + ", addationalCharges="
				+ addationalCharges + ", totalAmount=" + totalAmount + ", customerPaid=" + customerPaid
				+ ", createdDate=" + createdDate + ", isActive=" + isActive + "]";
	}
	
	
	
	
}	





