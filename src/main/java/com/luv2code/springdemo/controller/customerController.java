package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.dao.token_creation_validation;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/Customers")
public class customerController {
	
	@Autowired
	private CustomerService customerservice;

	
	@GetMapping("/clist/{slit}/{elit}")
	public List<Customer> getCustomers(@CookieValue(value = "PPtoken") String cookie,@PathVariable int slit,@PathVariable int elit){
	return customerservice.listCustomers(cookie,slit,elit);
	}
	

	
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable int id) {
		return customerservice.getCustomer(id);
	}
	@PostMapping("/newCustomer")
	public Customer addCustomer(@CookieValue(value = "PPtoken") String cookie,@RequestBody Customer theCustomer) {
		theCustomer.setHackerId(new token_creation_validation().validate_token(cookie));
		theCustomer.setId(0);
		return customerservice.saveCustomer(theCustomer,cookie);
	}
	@PutMapping("/updateCustomer")
	public Customer updateCustomer(@CookieValue(value = "PPtoken") String cookie,@RequestBody Customer theCustomer) {
		theCustomer.setHackerId(new token_creation_validation().validate_token(cookie));
		return customerservice.saveCustomer(theCustomer,cookie);
	}
	
	@PostMapping("/d/{theId}")
	public int deleteCustomer(@CookieValue(value = "PPtoken") String cookie,@PathVariable int theId) {
		return customerservice.deleteCustomer(cookie,theId);
		
	}
	
	@GetMapping("/check/{mNumber}")
	public Object customerCheck(@PathVariable String mNumber) {
		return customerservice.checkCustomerlogin(mNumber);
		
	}
	
	
}
