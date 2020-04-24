package com.luv2code.springdemo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.hacker;
import com.luv2code.springdemo.entity.lines;
import com.luv2code.springdemo.entity.products;

@Repository
public class productsDAOimps implements productsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List countOfcustomerInPro(String cookie) {
		List li = new ArrayList();
		Session currentSession = sessionFactory.getCurrentSession();
		Query<products> theQuery = currentSession.createQuery("from products where hackerId =:hId order by createdDate desc",products.class);
		theQuery.setParameter("hId", new token_creation_validation().validate_token(cookie));
		List<products> listProducts = theQuery.getResultList();
		for (int i = 0; i < listProducts.size(); i++) {
			Map<String, Object> insertingCustomers = new HashMap<String, Object>();
			insertingCustomers.put("product", listProducts.get(i));
			Query hittingCustomerproTble = currentSession.createQuery("select count(id) from customerProducts where productId=:proId and hackerId=:hId");
			hittingCustomerproTble.setParameter("proId", listProducts.get(i).getId());
			hittingCustomerproTble.setParameter("hId", new token_creation_validation().validate_token(cookie));
			System.out.println("count " + hittingCustomerproTble.uniqueResult().toString());
			insertingCustomers.put("count", hittingCustomerproTble.uniqueResult().toString());
			li.add(insertingCustomers);
			insertingCustomers = null;
			hittingCustomerproTble = null;
		}
		return li;
	}

	@Override
	public List<products> listOfProducts(String cookie) {
		Session currentsession = sessionFactory.getCurrentSession();
		Query<products> thequery = currentsession.createQuery("from products where hackerId = :hId order by  createdDate desc",products.class);
		thequery.setParameter("hId",new token_creation_validation().validate_token(cookie));
		List<products> listofProducts = thequery.getResultList();
		return listofProducts;
	}

	@Override
	public products singleProduct(int id, String cookie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeProduct(int id, String cookie) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public products newProduct(String cookie,products theproduct) {
		Session currentsession = sessionFactory.getCurrentSession();
		theproduct.setId(0);
		theproduct.setHackerId(new token_creation_validation().validate_token(cookie));
		currentsession.save(theproduct);
		return theproduct;
	}

}
