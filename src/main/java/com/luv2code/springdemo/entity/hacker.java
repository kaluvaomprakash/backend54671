package com.luv2code.springdemo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="hacker")
public class hacker {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	Integer id;
	@Column(name="mobile_number")
	String mobileNumber;
	@Column(name="password")
	String password;
	@Column(name="service_charges")
	Integer serviceCharge;
	@Column(name="details")
	String details;
	@Column(name="is_active")
	Integer isActive;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Integer getServiceCharge() {
		return serviceCharge;
	}
	public void setServiceCharge(Integer serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Integer getIsActive() {
		return isActive;
	}
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "hacker [id=" + id + ", mobileNumber=" + mobileNumber + ", password=" + password + ", serviceCharge="
				+ serviceCharge + ", details=" + details + ", isActive=" + isActive + "]";
	}

		
}
