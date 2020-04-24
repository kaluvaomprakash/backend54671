package com.luv2code.springdemo.dao;

import java.util.List;
import java.util.Map;

import com.luv2code.springdemo.entity.hacker;

public interface hackerdao {
	public List<hacker> allHackers();
	
	public hacker savehacker(hacker theCustomer);

	public hacker getahacker(int theId);

	public int deleteahacker(int theId);
	
	public Map<String,String> hackerLoginCheck(String mobilenumber,String pwd);
}
