package com.transfer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.transfer.pojo.Customer;

@Repository
public interface CustRepo extends JpaRepository<Customer, Integer>
{
	@Query("from Customer u where u.username=:username")
	public Customer getCustomer(@Param("username") String username);
}
