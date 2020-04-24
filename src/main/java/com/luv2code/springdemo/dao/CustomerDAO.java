package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.hacker;

public interface CustomerDAO {

	public List<Customer> listCustomers(String cookie,int sLimit,int eLimit);

	public Customer saveCustomer(Customer theCustomer,String cookie);

	public Customer getCustomer(int theId);

	public int deleteCustomer(String cookie,int theId);
	
	public Object customerLoginCheck(String mobilenumber);

	
	
	
	
}
