package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.comments;

@Repository
public class commentDAOimp implements commentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override 
	public comments newComment(String token,comments thecomment) {
		Session currentSession = sessionFactory.getCurrentSession();
		int hackerId= new token_creation_validation().validate_token(token);
		thecomment.setId(0);
		thecomment.setHackerId(hackerId);
		currentSession.save(thecomment);
		return thecomment;
	}

	@Override
	public List<comments> listOfcommentsOfcustomer(String token, int custid) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query thequery = currentSession.createQuery("from comments where hackerId=:hid and customerId = :custid",comments.class);
		thequery.setParameter("hid", new token_creation_validation().validate_token(token));
		thequery.setParameter("custid", custid);
		List<comments> listofcomments = thequery.getResultList();
		return listofcomments;
	}
	

}
