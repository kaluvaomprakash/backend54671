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

import com.luv2code.springdemo.entity.comments;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/comments")
public class commentsController {
	
	@Autowired
	private CustomerService customerservice;
	
	@PostMapping("/newComment")
	public comments newcomments(@CookieValue(value = "PPtoken") String token,@RequestBody comments thecomments) {
		return customerservice.newCommet(token, thecomments);
	}
	
	@GetMapping("/commentList/{custId}")
	public List<comments> listofcomments(@CookieValue(value = "PPtoken") String token,@PathVariable int custId){
		System.out.println(custId);
		return customerservice.listOfComments(token, custId);
	}
}
