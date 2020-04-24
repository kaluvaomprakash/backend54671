package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.accounts;

public interface accountDAO {

	public List<accounts> newAccount(String token,List<accounts> theaccount);
	public List<accounts> listOfPaidcustomers(String token,int customerId);
	public accounts statementOfmonth(int custId,int year,String month);
}
