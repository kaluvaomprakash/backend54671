package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.comments;

public interface commentDAO {

	public comments newComment(String cookie,comments thecomment);
	public List<comments> listOfcommentsOfcustomer(String token,int custid);
}
