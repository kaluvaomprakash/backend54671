package com.luv2code.springdemo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.customerProducts;
import com.luv2code.springdemo.entity.products;

@Repository
public class customerProductDAOimp implements customerProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<customerProducts> listCustomerProductsBycustomerId(String token,int custId,int paidstatus) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query thequery = currentSession.createQuery("from customerProducts where customerId = :custId and hackerId = :hId and paid=:paidstas",customerProducts.class);
		thequery.setParameter("custId", custId);
		thequery.setParameter("hId", new token_creation_validation().validate_token(token));
		thequery.setParameter("paidstas", paidstatus);
		List<customerProducts> listOfp=thequery.getResultList();
		return listOfp;
	}
	
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
	    	    if("MONDAY".equalsIgnoreCase((date1.getDayOfWeek().toString())))mon++;
	    	    if("TUESDAY".equalsIgnoreCase(date1.getDayOfWeek().toString())) tue++;
	    	    if("WEDNESDAY".equalsIgnoreCase(date1.getDayOfWeek().toString()))wed++;
	    	    if("THURSDAY".equalsIgnoreCase(date1.getDayOfWeek().toString()))  thur++;
	    	    if("FRIDAY".equalsIgnoreCase(date1.getDayOfWeek().toString()))	 fri++;
	    	    if("SATURDAY".equalsIgnoreCase(date1.getDayOfWeek().toString())) sat++;
	    	    if("SUNDAY".equalsIgnoreCase(date1.getDayOfWeek().toString()))   sun++;
	    	    
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

	@Override
	public List<customerProducts> newcustomerProudct(String token,List<customerProducts> thecustomerProdcut) {
		int hackerid= new token_creation_validation().validate_token(token);
		double finalProductprice = 0.0;
		LocalDate todayDate = LocalDate.now();
		List al = new ArrayList<customerProducts>();
		Session currentsesstion = sessionFactory.getCurrentSession();
		Map<String,Integer> occurenceOfdaysInMonth = new customerProductDAOimp().daysinmonth();
				for (int i = 0; i < thecustomerProdcut.size(); i++) {
			customerProducts onecustProduct = thecustomerProdcut.get(i);
			products theProduct = currentsesstion.get(products.class, onecustProduct.getProductId());
			String pp = theProduct.getProductPrice();
			pp = pp.substring(1, pp.length() - 1);
			System.out.println("pp after split " + pp);
			String ppsplit[] = pp.split(",");
			System.out.println(ppsplit[0]);
			Map<String, Double> prices = new LinkedHashMap<String, Double>();
			for (int j = 0; j < ppsplit.length; j++) {
				
				String[] day1 = ppsplit[j].split(":");
				//System.out.println(day1[0]);
			prices.put(day1[0].substring(1, day1[0].length() - 1),Double.parseDouble(day1[1]));
			}
			System.out.println("prices " + prices);
			Double ProductMonthlyPrice = 0.0;
			for (Map.Entry<String, Double> priceOfNwsPaperforaDay : prices.entrySet()) {
		    	  String productDay = priceOfNwsPaperforaDay.getKey();
		    	  Double ProductPrice = priceOfNwsPaperforaDay.getValue();
		    	  Integer  daysInWeek = (Integer) occurenceOfdaysInMonth.get(productDay); 
		    	  try {
		    	  ProductMonthlyPrice+=ProductPrice*daysInWeek;
		    	  System.out.println("ProductMonthlyPrice "+ProductMonthlyPrice);
		    	  }
		    	  catch (NullPointerException n) {
		    		  System.out.println(n);
		    	  }
		    	}
		     System.out.println("ProductMonthlyPrice Final"+ProductMonthlyPrice);
		     
		     customerProducts custprodctItem = new customerProducts();
		     System.out.println(occurenceOfdaysInMonth);
		     Integer workingDays = occurenceOfdaysInMonth.get("mon")+ occurenceOfdaysInMonth.get("tue")+ occurenceOfdaysInMonth.get("wednes")
		     +occurenceOfdaysInMonth.get("thur")+ occurenceOfdaysInMonth.get("fri")+ occurenceOfdaysInMonth.get("sat");
		     custprodctItem.setId(0);
		     //custprodctItem.setHackerId(1);//hacker ID
		     custprodctItem.setCustomerId(onecustProduct.getCustomerId());//
		     custprodctItem.setProductId(onecustProduct.getProductId());
		     custprodctItem.setpMonth(todayDate.getMonth().toString());
		     custprodctItem.setYear(todayDate.getYear());
		     custprodctItem.setMonthDays(workingDays);
		     custprodctItem.setMonthWeekDate(occurenceOfdaysInMonth.get("sun"));
		     custprodctItem.setProductName(theProduct.getProductName());
		     custprodctItem.setProductMonthlyPrice(Math.ceil(ProductMonthlyPrice));
		     custprodctItem.setProductStartDate((onecustProduct.getProductStartDate()));
		     custprodctItem.setProductEndDate(onecustProduct.getProductEndDate());
		     custprodctItem.setIsRecursive(onecustProduct.getIsRecursive());
		     custprodctItem.setProductAddationalCharges(onecustProduct.getProductAddationalCharges());
		     custprodctItem.setProductType(theProduct.getProductType());
		     custprodctItem.setPaid(0);
		     custprodctItem.setHoldIsActive(0);
		     custprodctItem.setIsActive(1);
		     
		     finalProductprice+=Math.ceil(ProductMonthlyPrice)+onecustProduct.getProductAddationalCharges();
		     
		     currentsesstion.save(custprodctItem);
		     
		     al.add(custprodctItem);
		}
				 Query updatetotalAmunt = currentsesstion.createQuery("update Customer set totalAmount=:finalAmout where id = :custId");
			      updatetotalAmunt.setParameter("finalAmout", Math.ceil(finalProductprice));
			      updatetotalAmunt.setParameter("custId", thecustomerProdcut.get(0).getCustomerId());
			      updatetotalAmunt.executeUpdate();
			      System.out.println("updatetotalAmunt "+updatetotalAmunt);
		return al;
	}

	@Override
	public List<customerProducts>  paidProductDetails(int custId, String month, int year) {
		Session currentsesstion = sessionFactory.getCurrentSession();
		Query thequery =currentsesstion.createQuery("from customerProducts where pMonth = :month and year = :year and customerId=:cid ",customerProducts.class);
		thequery.setParameter("month", month);
		thequery.setParameter("year", year);
		thequery.setParameter("cid", custId);
		List<customerProducts>  theprodu =  thequery.getResultList();
		return theprodu;
	}

}
