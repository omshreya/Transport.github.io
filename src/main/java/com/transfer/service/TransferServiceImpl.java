package com.transfer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transfer.model.Login;
import com.transfer.pojo.Customer;
import com.transfer.pojo.TripDetails;
import com.transfer.repo.CustRepo;
import com.transfer.repo.TripRepo;

@Service
public class TransferServiceImpl implements TransferService
{
	
	@Autowired
	private CustRepo repo;
	@Autowired
	private TripRepo repo1;
	
	@Transactional
	@Override
	public Customer Validate(Login cred) 
	{
		Customer c=repo.getCustomer(cred.getUsername());
    	System.out.println("In validation:"+c);
    	if(c!=null && c.getPassword().equals(cred.getPassword()))
    	{
    		return c;
    	}
    	else
    	{
    		return null;
    	}	
	}
	
	@Transactional
	@Override
	public List<Customer> getList() 
	{
		return repo.findAll();
	}
	
	@Transactional
	@Override
	public Customer getCust(Customer cust) 
	{
		return repo.save(cust);
	}
	
	@Transactional
	@Override
	public Customer getCustomer(String username) 
	{
		return repo.getCustomer(username);
	}
	
	@Transactional
	@Override
	public Customer getById(int id)
	{
		return repo.getOne(id);
	}
	
	@Transactional
	@Override
	public TripDetails getDetails(TripDetails t) 
	{
		return repo1.save(t);
	}
	
}
