package com.luv2code.springdemo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.hacker;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/hacker")
public class hackerController {
	@Autowired
	private CustomerService customerservice;
	
	@GetMapping("/")
	public List<hacker> getHackers(){
	return customerservice.getHackers();
	}
	
	@GetMapping("/{id}")
	public hacker getaHacker(@PathVariable int id) {
		return customerservice.getaHacker(id);
	}
	
	@PostMapping("/save")
	public hacker addHacker(@RequestBody hacker theHacker) {
		theHacker.setId(0);
		return customerservice.savehacker(theHacker);
		
	}
	@PutMapping("/update")
	public hacker updateHacker(@RequestBody hacker theHacker) {
		return customerservice.savehacker(theHacker);
	}
	
	@PostMapping("/d/{theId}")
	public int deleteHacker(@PathVariable int theId) {
		return customerservice.deletehacker(theId);
	}
	@GetMapping("/check/{mNumber}/{pwd}")
	public Map<String,String> hackerCheck(@PathVariable String mNumber,@PathVariable String pwd) {
		return customerservice.checkHackerlogin(mNumber,pwd);
		
	}
	
	
}
