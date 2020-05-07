package com.luv2code.springdemo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

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
	public Customer saveCustomer(Customer theCustomer,String cookie,String imagurl) throws IOException {
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("imageurl"+imagurl);
		if(imagurl.equals("noimage")) {
			System.out.println("in if");
			theCustomer.setImage(null);
		}
		else {
			theCustomer.setImage(new CustomerDAOImpl().convert_img_byte(imagurl));
			
		}
		currentSession.saveOrUpdate(theCustomer);
		return (Customer) theCustomer;
	}

	@Override
	public Customer getCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
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

	@Override
	public void image_upload(String theimage) throws IOException  {
		Session currentSession = sessionFactory.getCurrentSession();
		File file = new File(theimage);
		System.out.println("file "+file);
		byte[] bFile = new byte[(int) file.length()];
		System.out.println("bFile " +bFile);
		FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(bFile);
        fileInputStream.close();
        
        Customer cust = new Customer();
        cust.setHackerId(0);
        cust.setLineId(0);
        cust.setMobileNumber("9848966970");
        cust.setPassword("54671");
        cust.setName("image test");
        cust.setImage(bFile);
        cust.setDetails("new detasil");
        cust.setAddationalCharges(0);
        cust.setTotalAmount(0);
        cust.setCustomerPaid(0);
        cust.setIsActive(0);
        currentSession.save(cust);
	}
	
	public byte [] convert_img_byte(String theimage) throws IOException {
		File file = new File(theimage);
		System.out.println("file "+file);
		byte[] bFile = new byte[(int) file.length()];
		System.out.println("bFile " +bFile);
		FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(bFile);
        fileInputStream.close();
		return bFile;
	}
	
	

	

}











