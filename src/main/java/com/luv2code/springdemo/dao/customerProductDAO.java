package com.luv2code.springdemo.dao;

import java.util.List;
import java.util.Map;

import com.luv2code.springdemo.entity.customerProducts;

public interface customerProductDAO {

	public List<customerProducts> listCustomerProductsBycustomerId(String token,int custid,int paidstatus);
	public List<customerProducts> newcustomerProudct(String token,List<customerProducts> thecustomerProdcut);
	public List<customerProducts> paidProductDetails(int custId,String month,int year);
}
