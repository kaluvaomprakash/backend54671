package com.luv2code.springdemo.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.dao.accountDAOimps;
import com.luv2code.springdemo.dao.commentDAOimp;
import com.luv2code.springdemo.dao.customerProductDAOimp;
import com.luv2code.springdemo.dao.hackersDaoimp;
import com.luv2code.springdemo.dao.linesDAOimp;
import com.luv2code.springdemo.dao.productsDAOimps;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.accounts;
import com.luv2code.springdemo.entity.comments;
import com.luv2code.springdemo.entity.customerProducts;
import com.luv2code.springdemo.entity.hacker;
import com.luv2code.springdemo.entity.lines;
import com.luv2code.springdemo.entity.products;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private hackersDaoimp hakcerdao;
	
	@Autowired
	private linesDAOimp linesdaoimp;
	
	@Autowired 
	private productsDAOimps productsdaoimps;
	
	@Autowired 
	private customerProductDAOimp custProductImp;
	
	@Autowired 
	private accountDAOimps accountsdaoImps;
	
	@Autowired
	private commentDAOimp commentsdaoimps;
	
	@Override
	@Transactional
	public List<Customer> listCustomers(String cookie,int sLimit,int eLimit) {
		return customerDAO.listCustomers(cookie,sLimit,eLimit);
	}

	@Override
	@Transactional
	public Customer saveCustomer(Customer theCustomer,String cookie,String imagurl) throws IOException {
		return customerDAO.saveCustomer(theCustomer,cookie,imagurl);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public int deleteCustomer(String cookie,int theId) {
		
		return customerDAO.deleteCustomer(cookie,theId);
	}

	@Override
	@Transactional
	public Object checkCustomerlogin(String mobilenumber) {
		return customerDAO.customerLoginCheck(mobilenumber);
	}

	
	// **** All hacker things start from here
	
	@Override
	@Transactional
	public List<hacker> getHackers() {
		return hakcerdao.allHackers();
	}

	@Override
	@Transactional
	public hacker savehacker(hacker thehacker) {
		return hakcerdao.savehacker(thehacker);
	}

	@Override
	@Transactional
	public hacker getaHacker(int theId) {
		return hakcerdao.getahacker(theId);
	}

	@Override
	@Transactional
	public int deletehacker(int theId) {
		return hakcerdao.deleteahacker(theId);
	}

	@Override
	@Transactional
	public Map<String,String> checkHackerlogin(String mobilenumber,String pwd) {
		System.out.println(mobilenumber+" "+pwd);
		return hakcerdao.hackerLoginCheck(mobilenumber,pwd);
	}

	@Override
	@Transactional
	public List customersInLines(String cookie) {
		return linesdaoimp.customersInLines(cookie);
	}

	@Override
	@Transactional
	public List<lines> listOfLines(String cookie) {
		return linesdaoimp.listLines(cookie);
	}

	@Override
	@Transactional
	public lines newLine(lines thelines, String cookie) {
		return linesdaoimp.newLine(thelines, cookie);
	}

	@Override
	@Transactional
	public lines updateLine(lines thelines, String cookie) {
		return linesdaoimp.updateLine(thelines, cookie);
	}

	@Override
	public int removeLine(int id, String cookie) {
		// TODO Auto-generated method stub
		return linesdaoimp.removeLine(id, cookie);
	}
//proudcts things
	@Override
	@Transactional
	public List countOfcustomerInPro(String cookie) {
		// TODO Auto-generated method stub
		return productsdaoimps.countOfcustomerInPro(cookie);
	}

	@Override
	@Transactional
	public products newProduct(String cookie, products theproduct) {
		// TODO Auto-generated method stub
		return productsdaoimps.newProduct(cookie, theproduct);
	}

	@Override
	@Transactional
	public List<products> listOfProducts(String cookie) {
		return productsdaoimps.listOfProducts(cookie);
	}

	@Override
	@Transactional
	public List<customerProducts> newcustomerProudct(String cookie,List<customerProducts> thecustomerProdcut) {
		// TODO Auto-generated method stub
		return custProductImp.newcustomerProudct(cookie,thecustomerProdcut);
	}
	
	@Override
	@Transactional
	public List<customerProducts> listCustomerProductsBycustomerId(String token,int custid,int paidstatus){
		return custProductImp.listCustomerProductsBycustomerId(token, custid,paidstatus);
		
	}

	@Override
	@Transactional
	public List<accounts> newAccount(String token, List<accounts> theaccount) {
		//System.out.println("theaccount in service imp"+theaccount+" "+token);
		// TODO Auto-generated method stub
		return accountsdaoImps.newAccount(token, theaccount);
	}

	@Override
	@Transactional
	public List<accounts> listOfPaidcustomers(String token, int customerId) {
		// TODO Auto-generated method stub
		return accountsdaoImps.listOfPaidcustomers(token, customerId);
	}

	@Override
	@Transactional
	public comments newCommet(String token, comments thecomments) {
		return commentsdaoimps.newComment(token, thecomments);
	}

	@Override
	@Transactional
	public List<comments> listOfComments(String token, int custId) {
		return commentsdaoimps.listOfcommentsOfcustomer(token, custId);
	}

	@Override
	@Transactional
	public List<customerProducts>  paidProductDetails(int custId, String month, int year) {
		return custProductImp.paidProductDetails(custId, month, year);
	}

	@Override
	@Transactional
	public accounts statementOfmonth(int custId, int year, String month) {
		// TODO Auto-generated method stub
		return accountsdaoImps.statementOfmonth(custId, year, month);
	}

	@Override
	@Transactional
	public void get_image(String imageurl) throws IOException {
		  customerDAO.image_upload(imageurl);
		
	}

	
}





