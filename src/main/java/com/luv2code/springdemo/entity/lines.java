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
@Table(name = "paper_lines")
public class lines {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "line_id")
	private int id;
	@Column(name = "line_name")
	private String name;
	@Column(name = "hacker_id")
	private int hackerId;
	@CreationTimestamp
	@Column(name = "created_time",nullable = false, updatable = false)
	private LocalDate createdDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHackerId() {
		return hackerId;
	}
	public void setHackerId(int hackerId) {
		this.hackerId = hackerId;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "lines [id=" + id + ", name=" + name + ", hackerId=" + hackerId + ", createdDate=" + createdDate + "]";
	}
	
	
}
