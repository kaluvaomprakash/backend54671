package com.luv2code.springdemo.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.accounts;
import com.luv2code.springdemo.entity.comments;
import com.luv2code.springdemo.entity.customerProducts;
import com.luv2code.springdemo.entity.hacker;
import com.luv2code.springdemo.entity.lines;
import com.luv2code.springdemo.entity.products;

public interface CustomerService {

	public List<Customer> listCustomers(String cookie,int sLimit,int eLimit);

	public Customer saveCustomer(Customer theCustomer,String cookie,String imagurl) throws IOException;

	public Customer getCustomer(int theId);

	public int deleteCustomer(String cookie,int theId);
	
	public Object checkCustomerlogin(String mobilenumber);
	
	public void get_image(String imageurl) throws IOException;
	
	
	
//*****hackers things
	
	public List<hacker> getHackers();
	
	public hacker savehacker(hacker thehacker);

	public hacker getaHacker(int theId);

	public int deletehacker(int theId);
	
	public Map<String,String> checkHackerlogin(String mobilenumber,String pwd);
	
	
	//line things
	
	public List customersInLines(String cookie);
	
	public List<lines> listOfLines(String cookie);
	
	public lines newLine(lines thelines,String cookie);
	
	public lines updateLine(lines thelines,String cookie);
 
	public int removeLine(int id,String cookie);
	
	
	//proudcts related things
	
	public List countOfcustomerInPro(String cookie);
	
	public products newProduct(String cookie,products theproduct);
	
	public List<products> listOfProducts(String cookie);
	
	//customer products
	
	public List<customerProducts> newcustomerProudct(String cookie,List<customerProducts> thecustomerProdcut);
	public List<customerProducts> listCustomerProductsBycustomerId(String token,int custid,int paidstatus);
	public List<customerProducts>  paidProductDetails(int custId,String month,int year);
	
	//accounts related things
	
	public List<accounts> newAccount(String token,List<accounts> theaccount);
	public List<accounts> listOfPaidcustomers(String token,int customerId);
	public accounts statementOfmonth(int custId,int year,String month);
	
	//comments related thins
	
	public comments newCommet(String token,comments thecomments);
	public List<comments> listOfComments(String token,int custId);
}
