package com.luv2code.springdemo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.customerProducts;
import com.luv2code.springdemo.entity.hacker;

public class Recursive_statement_generators {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Map recursive_statment_generators(){
		Session currentSession = sessionFactory.getCurrentSession();
		Query<hacker> thequery = currentSession.createQuery("from hacker where isActive = '1' ",hacker.class);
		List<hacker> list_of_hackers = thequery.getResultList();	
		Map<String,List> newCustomer_map = new HashMap<String,List>();
		for(int i =0;i<list_of_hackers.size();i++) {
			List new_customer_bill = recursive_statment_generators_for_new_customer(list_of_hackers.get(i).getId());
			newCustomer_map.put("New_Customer", new_customer_bill);
			List existing_customer_bills = recursive_statment_generators_for_existing_Customer(list_of_hackers.get(i).getId());
			newCustomer_map.put("Existing_Customers", existing_customer_bills);
		}
		
		return null;
	}
	//
	public Map<String,Integer> daysinmonth() {
		LocalDate todayDate = LocalDate.now();		
		System.out.println("today "+todayDate);
		String todaydatesplit[]=todayDate.toString().split("-");
		LocalDate periousMonth = todayDate.minusMonths(1);
		System.out.println("Perious Month Date "+periousMonth);
		Integer mon=0,tue=0,wed=0,thur=0,fri=0,sat=0,sun=0;
		int numberOfDaysInMonth = periousMonth.getMonth().length(true);
	     for( int i=1;i <= numberOfDaysInMonth; i++ ) {
	    	    LocalDate date1 = LocalDate.of(periousMonth.getYear(),periousMonth.getMonth(), i);
	    	    if("MONDAY".equalsIgnoreCase((date1.getDayOfWeek().toString())))   mon++;
	    	    if("TUESDAY".equalsIgnoreCase(date1.getDayOfWeek().toString()))    tue++;
	    	    if("WEDNESDAY".equalsIgnoreCase(date1.getDayOfWeek().toString()))  wed++;
	    	    if("THURSDAY".equalsIgnoreCase(date1.getDayOfWeek().toString()))   thur++;
	    	    if("FRIDAY".equalsIgnoreCase(date1.getDayOfWeek().toString()))	   fri++;
	    	    if("SATURDAY".equalsIgnoreCase(date1.getDayOfWeek().toString()))   sat++;
	    	    if("SUNDAY".equalsIgnoreCase(date1.getDayOfWeek().toString()))     sun++;
	    	    
           }
	     Map<String,Integer> occurenceOfdaysInMonth = new LinkedHashMap<String,Integer>();
	     occurenceOfdaysInMonth.put("mon", mon);
	     occurenceOfdaysInMonth.put("tue", tue);
	     occurenceOfdaysInMonth.put("wednes", wed);
	     occurenceOfdaysInMonth.put("thur", thur);
	     occurenceOfdaysInMonth.put("fri", fri);
	     occurenceOfdaysInMonth.put("sat", sat);
	     occurenceOfdaysInMonth.put("sun", sun);
	     System.out.println("occurenceOfdaysInMonth "+occurenceOfdaysInMonth);
		return occurenceOfdaysInMonth;
	}
	private List recursive_statment_generators_for_existing_Customer(Integer id) {
		return null;
	}

	private List recursive_statment_generators_for_new_customer(Integer h_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query cus =  currentSession.createQuery("from Customer where hackerId = :hId and YEAR(createdDate) = YEAR(CURRENT_DATE - INTERVAL 1 MONTH) "
				+ "AND MONTH(createdDate) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH)",Customer.class);
		cus.setParameter("hId", h_id);
		List li = new ArrayList();
		List<Customer> listofcustomer = cus.getResultList();
		Map<String,String> newCustomer_map = new HashMap<String,String>();
		for(int i=0;i<listofcustomer.size();i++) {
		Query thecust_prodct = currentSession.createQuery("from customerProducts where customerId =:custId",customerProducts.class);
		thecust_prodct.setParameter("custId", listofcustomer.get(i).getId());
		List<customerProducts> customer_prodcut = thecust_prodct.getResultList();
		newCustomer_map.put("id", String.valueOf((listofcustomer.get(i).getId())));
		newCustomer_map.put("name", listofcustomer.get(i).getName());	
		for(int j=0;j<customer_prodcut.size();j++) {
			Query updatetotalAmunt = currentSession.createQuery("update Customer set totalAmount=:finalAmout where id = :custId");
		      updatetotalAmunt.setParameter("finalAmout", Math.ceil(customer_prodcut.get(j).getProductMonthlyPrice()));
		      updatetotalAmunt.setParameter("custId", listofcustomer.get(i).getId());
		      updatetotalAmunt.executeUpdate();
		      newCustomer_map.put("amount", String.valueOf(customer_prodcut.get(j).getProductMonthlyPrice()));
		      System.out.println("updatetotalAmunt "+updatetotalAmunt);
		      li.add(newCustomer_map);
		      newCustomer_map= null;
		      
		}
		}
		
		return li;
	}

}
