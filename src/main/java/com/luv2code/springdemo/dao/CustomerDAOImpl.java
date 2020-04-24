package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.hacker;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Customer> listCustomers(String cookie,int slimit,int elimit) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = currentSession.createQuery("from Customer where hackerId = :hId order by created_date desc",Customer.class);
		theQuery.setParameter("hId", new token_creation_validation().validate_token(cookie));
		theQuery.setFirstResult(slimit);
		theQuery.setMaxResults(elimit);
		List<Customer> customers = theQuery.getResultList();
		return customers;
	}

	@Override
	public Customer saveCustomer(Customer theCustomer,String cookie) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);
		return theCustomer;
	}

	@Override
	public Customer getCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public int deleteCustomer(String cookie,int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId and hackerId = :hid");
		theQuery.setParameter("customerId", theId);
		theQuery.setParameter("hid", new token_creation_validation().validate_token(cookie));
		
		return theQuery.executeUpdate();		
	}
	
	@Override
	public Object customerLoginCheck(String mobilenumber) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// now retrieve/read from database using the primary key
		Query theQuery = currentSession.createQuery("select count(mobile_number) as mcount from Customer where mobile_number=:mNum");
		theQuery.setParameter("mNum", mobilenumber);
		return theQuery.uniqueResult();
	}
	
	

	

}











