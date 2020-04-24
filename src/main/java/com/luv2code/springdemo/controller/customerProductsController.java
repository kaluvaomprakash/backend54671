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

import com.luv2code.springdemo.entity.customerProducts;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/customerProducts")
public class customerProductsController {

	@Autowired
	private CustomerService customerservice;
	
	@PostMapping("/newcustomerProduct")
	public List<customerProducts> newcustomerProduct(@CookieValue(value = "PPtoken") String cookie,@RequestBody List<customerProducts> thecustomerProdcut){
		return customerservice.newcustomerProudct(cookie,thecustomerProdcut);
	}
	
	@GetMapping("/product/{custId}/{paidstatus}")
	public List<customerProducts> listofcustomersbycustomerId(@CookieValue(value="PPtoken") String cookie,@PathVariable int custId,@PathVariable int paidstatus){
		return customerservice.listCustomerProductsBycustomerId(cookie, custId,paidstatus);
		
	}
	
	@GetMapping("/{custId}/{month}/{year}")
	public List<customerProducts>  paidcustomerDetails (@PathVariable int custId,@PathVariable String month,@PathVariable int year) {
		return customerservice.paidProductDetails(custId, month, year);
	}
}
