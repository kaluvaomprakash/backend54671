package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.accounts;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/account")
public class accountscontroller {
	
	@Autowired
	private CustomerService customerservice;
	
	@PostMapping("/newaccount")
	public List<accounts> addCustomer(@CookieValue(value = "PPtoken") String cookie,@RequestBody List<accounts> theaccounts) {
		System.out.println("theaccount in controller"+theaccounts+" "+cookie);
		return customerservice.newAccount(cookie, theaccounts);
	}	
	
	@GetMapping("/statements/{custId}")
	public List<accounts> listofcustomerpaid(@CookieValue(value = "PPtoken") String cookie,@PathVariable int custId){
		return customerservice.listOfPaidcustomers(cookie, custId);
	}
	@GetMapping("/statment/{custId}/{year}/{month}")
	public accounts statemtnOfMonth (@PathVariable int custId,@PathVariable int year,@PathVariable String month) {
		return customerservice.statementOfmonth(custId, year, month);
	}
}
