package com.luv2code.springdemo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.hacker;
@Repository
public class hackersDaoimp implements hackerdao{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<hacker> allHackers() {
		// TODO Auto-generated method stub
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
						
				// create a query  ... sort by last name
				Query<hacker> theQuery = currentSession.createQuery("from hacker",hacker.class);
				
				// execute query and get result list
				List<hacker> hackers = theQuery.getResultList();
						
				// return the results		
				return hackers;
		
	}
	@Override
	public hacker savehacker(hacker thehacker) {
		// get current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// save/upate the customer ... finally LOL
				currentSession.saveOrUpdate(thehacker);
				return thehacker;
	}
	@Override
	public hacker getahacker(int theId) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// now retrieve/read from database using the primary key
				hacker ahacker = currentSession.get(hacker.class, theId);
				
				return ahacker;
	}
	@Override
	public int deleteahacker(int theId) {
		// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// delete object with primary key
			Query theQuery = currentSession.createQuery("delete from hacker where id=:hackerId");
			theQuery.setParameter("hackerId", theId);
			
			return theQuery.executeUpdate();		
	}
	@Override
	public Map<String,String> hackerLoginCheck(String mobilenumber,String pwd) {
		        Map<String,String> mp = new HashMap<String,String>();
				Session currentSession = sessionFactory.getCurrentSession();
				System.out.println("in hacker method");
				Query theQuery = currentSession.createQuery("select count(id) from hacker where mobile_number=:uMNum and password=:uPwd");
				theQuery.setParameter("uMNum", mobilenumber);
				theQuery.setParameter("uPwd", pwd);
				int count = Integer.parseInt(theQuery.uniqueResult().toString());
				mp.put("count", theQuery.uniqueResult().toString());
				if(count>0) { 
				  System.out.println("in if "+theQuery.uniqueResult().toString());
				  Query theQuery1 = currentSession.createQuery("select id from hacker where mobile_number=:uMNum and password=:uPwd");
				  theQuery1.setParameter("uMNum", mobilenumber);
				  theQuery1.setParameter("uPwd", pwd);
				  mp.put("isValid","yes" );
				  mp.put("token", new token_creation_validation().creation(mobilenumber, Integer.parseInt(theQuery1.uniqueResult().toString())));	  
			      return mp;
				  } else { 
				   System.out.println("in else");
				  System.out.println(theQuery.uniqueResult());
				  mp.put("isValid","yes" );
				  return mp;
				  }
				
		//return null;
	}

}
