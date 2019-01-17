package com.transfer.service;

import java.util.List;

import com.transfer.model.Login;
import com.transfer.pojo.Customer;
import com.transfer.pojo.TripDetails;

public interface TransferService 
{
	public Customer Validate(Login cred);
	public List<Customer> getList();
	public Customer getCust(Customer cust);
	public Customer getCustomer(String username);
	public Customer getById(int id);
	public TripDetails getDetails(TripDetails t);
}
