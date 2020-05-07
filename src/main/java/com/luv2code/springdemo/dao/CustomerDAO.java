package com.luv2code.springdemo.dao;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> listCustomers(String cookie,int sLimit,int eLimit);

	public Customer saveCustomer(Customer theCustomer,String cookie,String imagurl) throws IOException;

	public Customer getCustomer(int theId);

	public int deleteCustomer(String cookie,int theId);
	
	public Object customerLoginCheck(String mobilenumber);
	
	
	public void image_upload(String theimage) throws IOException;

	
	
	
	
}
