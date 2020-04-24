package com.luv2code.springdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.accounts;

@Repository
public class accountDAOimps implements accountDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<accounts> newAccount(String token, List<accounts> theaccount) {
		Session currentSession = sessionFactory.getCurrentSession();
		int hackerId= new token_creation_validation().validate_token(token);
		List<accounts> newaccountslist = new ArrayList<accounts>();
		for(int i=0;i<theaccount.size();i++) {
			
			accounts theaccountsingleObj = theaccount.get(i);
			theaccountsingleObj.setHackerId(hackerId);
		    currentSession.save(theaccountsingleObj);   
		    //UPDATE `paperpay`.`customer_products` SET `paid` = '1' WHERE (`id` = '123');
		    Query thequery = currentSession.createQuery("update customerProducts set paid = '1' where id =:custprudctid");
		    thequery.setParameter("custprudctid", theaccountsingleObj.getCustomerProductId());
		    int updateid = thequery.executeUpdate();
		    System.out.println("upding "+updateid);
		    newaccountslist.add(theaccountsingleObj);
		  }
		
		Query thequery1 = currentSession.createQuery("update Customer set customerPaid = '1' where id =:customerId");
		thequery1.setParameter("customerId", theaccount.get(0).getCustomerId());
		int custoidout = thequery1.executeUpdate();
		System.out.println("custoidout "+custoidout);
		return newaccountslist;
	}

	@Override
	public List<accounts> listOfPaidcustomers(String token, int customerId) {
		Session currentSession = sessionFactory.getCurrentSession();
		int hackerId= new token_creation_validation().validate_token(token);
		Query thequery = currentSession.createQuery("from accounts where hackerId =:hid and customerId =:custId");
		thequery.setParameter("hid", hackerId);
		thequery.setParameter("custId", customerId);
		List<accounts> listofaccounts = thequery.getResultList();
		return listofaccounts;
	}

	@Override
	public accounts statementOfmonth(int custId, int year, String month) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query thequery = currentSession.createQuery("from accounts where customerId = :cusId and month = :month and year = :year",accounts.class);
		thequery.setParameter("cusId", custId);
		thequery.setParameter("month", month);
		thequery.setParameter("year", year);
		accounts theaccounts = (accounts) thequery.getSingleResult();
		return theaccounts;
	}

}
