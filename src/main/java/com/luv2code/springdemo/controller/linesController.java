package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.lines;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/lines")
public class linesController {
	
	@Autowired
	private CustomerService customerservice;
	
	
	@GetMapping("/customerInLines")
	public List customersInLIne(@CookieValue(value = "PPtoken") String cookie) {
		return customerservice.customersInLines(cookie);
	}
	@GetMapping("/")
	public List<lines> listOfLInes(@CookieValue(value = "PPtoken") String cookie){
		return customerservice.listOfLines(cookie);
	}
	
	@PostMapping("/newLine")
	public lines newLine(@CookieValue(value = "PPtoken") String cookie,@RequestBody lines thelines) {
		return customerservice.newLine(thelines, cookie);	
	}
	@PutMapping("/updateLine")
	public lines updateLine(@CookieValue(value = "PPtoken") String cookie,@RequestBody lines thelines) {
		return customerservice.updateLine(thelines, cookie);	
	}
	
	@DeleteMapping("/removeline/{id}")
	public int removeLine(@CookieValue(value = "PPtoken") String cookie,@PathVariable int id) {
		return customerservice.removeLine(id, cookie);
	}
}
