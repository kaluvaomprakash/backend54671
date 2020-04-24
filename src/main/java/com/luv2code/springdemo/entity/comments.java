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
@Table(name="comments")
public class comments {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="hacker_id")
	private int hackerId;
	@Column(name="customer_id")
	private int customerId;
	@Column(name="message_from")
	private String messageFrom;
	@Column(name="comment")
	private String comment;
	@CreationTimestamp
	@Column(name = "created_date",nullable = false, updatable = false)
	private LocalDate created_date;
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
	public String getMessageFrom() {
		return messageFrom;
	}
	public void setMessageFrom(String messageFrom) {
		this.messageFrom = messageFrom;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public LocalDate getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDate created_date) {
		this.created_date = created_date;
	}
	@Override
	public String toString() {
		return "comments [id=" + id + ", hackerId=" + hackerId + ", customerId=" + customerId + ", messageFrom="
				+ messageFrom + ", comment=" + comment + ", created_date=" + created_date + "]";
	}
	
	
	
}
