package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.products;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/products")
public class productsController {
	@Autowired
	private CustomerService customerservice;
	
	@GetMapping("/custCountinProdct")
	public List countOfCustomersInProducts(@CookieValue(value = "PPtoken")String cookie) {
		return customerservice.countOfcustomerInPro(cookie);
	}
	
	@PostMapping("/newProduct")
	public products newProduct(@CookieValue(value = "PPtoken") String cookie,@RequestBody products theproduct) {
		return customerservice.newProduct(cookie, theproduct);
	}
	
	@GetMapping("/listfProducts")
	public List listofproducts(@CookieValue(value = "PPtoken") String cookie) {
		return customerservice.listOfProducts(cookie);
	}
}
