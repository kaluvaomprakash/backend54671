package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.products;

public interface productsDAO {

	
	public List countOfcustomerInPro(String cookie);
	public List<products> listOfProducts(String cookie);
	public products singleProduct(int id,String cookie);
	public int removeProduct(int id,String cookie);
	public products newProduct(String cookie,products theproduct);
	
}
