package com.transfer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transfer.pojo.TripDetails;

@Repository
public interface TripRepo extends JpaRepository<TripDetails, Integer>
{

}
