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

import com.luv2code.springdemo.entity.lines;

@Repository
public class linesDAOimp implements linesDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public lines newLine(lines theline, String cookie) {
		theline.setId(0);
		theline.setHackerId(new token_creation_validation().validate_token(cookie));
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(theline);
		return theline;
	}

	@Override
	public List<lines> listLines(String cookie) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<lines> theQuery = currentSession.createQuery("from lines where hackerId =:hId order by  createdDate desc",
				lines.class);
		theQuery.setParameter("hId", new token_creation_validation().validate_token(cookie));
		List<lines> listLines = theQuery.getResultList();
		return listLines;
	}

	@Override
	public lines singleLine(int id, String cookie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int removeLine(int id, String cookie) {
		Session currentSession = sessionFactory.getCurrentSession();
		lines currntline= currentSession.load(lines.class, id);
		System.out.println("currntline "+currntline);
		currentSession.delete(currntline);
		return  1;
	}

	@Override
	public List customersInLines(String cookie) {
		List li = new ArrayList();
		Session currentSession = sessionFactory.getCurrentSession();
		Query<lines> theQuery = currentSession.createQuery("from lines where hackerId =:hId order by createdDate desc",
				lines.class);
		theQuery.setParameter("hId", new token_creation_validation().validate_token(cookie));
		List<lines> listLines = theQuery.getResultList();
		for (int i = 0; i < listLines.size(); i++) {
			Map<String, Object> insertingCustomers = new HashMap<String, Object>();
			insertingCustomers.put("line", listLines.get(i));
			Query hittingCustomersTble = currentSession.createQuery("select count(id) from Customer where lineId=:lineId and hackerId=:hId");
			hittingCustomersTble.setParameter("lineId", listLines.get(i).getId());
			hittingCustomersTble.setParameter("hId", new token_creation_validation().validate_token(cookie));
			System.out.println("count " + hittingCustomersTble.uniqueResult().toString());
			// int NoOfCustoms =Integer.parseInt( );
			insertingCustomers.put("count", hittingCustomersTble.uniqueResult().toString());
			li.add(insertingCustomers);
			insertingCustomers = null;
			hittingCustomersTble = null;
		}
		return li;
	}

	@Override
	public lines updateLine(lines theline, String cookie) {
		theline.setHackerId(new token_creation_validation().validate_token(cookie));
		Session currentSession = sessionFactory.getCurrentSession();
		//currentSession.saveOrUpdate(theline);
		currentSession.saveOrUpdate("name", theline);
		return theline;
	}

}
