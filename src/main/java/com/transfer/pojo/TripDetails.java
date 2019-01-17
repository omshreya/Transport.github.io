package com.transfer.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;

import com.transfer.model.Trip;

@Entity
@Table(name="trip")
public class TripDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="trip_id")
	private int tripId;
	@Column(name="pickup_location")
	private String pickup;
	@Column(name="drop_location")
	private String drop;
	@Column(name="arrival_time")
	private String arrivalTime;
	@Column(name="departure_time")
	private String departureTime;
	@Column(name="transport")
	private String transport;
	@Column(name="trip_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date tripDate;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Customer cust;
	
	public TripDetails() {};
	
	public TripDetails(String pickup,String drop, String arrivalTime, String departureTime, Date tripDate)
	{
		this.pickup = pickup;
		this.drop = drop;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.tripDate = tripDate;
	}
	
	public TripDetails(Trip trip)
	{
		
	}
	
	public TripDetails(int tripId, String pickup, String drop, String arrivalTime, String departureTime, Date tripDate,
			Customer cust)
	{
		this.tripId = tripId;
		this.pickup = pickup;
		this.drop = drop;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.tripDate = tripDate;
		this.cust = cust;
	}
	public int getTripId() 
	{
		return tripId;
	}
	public void setTripId(int tripId) 
	{
		this.tripId = tripId;
	}
	public String getArrivalTime() 
	{
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) 
	{
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() 
	{
		return departureTime;
	}
	public void setDepartureTime(String departureTime) 
	{
		this.departureTime = departureTime;
	}
	public String getPickup() 
	{
		return pickup;
	}
	public void setPickup(String pickup) 
	{
		this.pickup = pickup;
	}
	public String getDrop() 
	{
		return drop;
	}
	public void setDrop(String drop) 
	{
		this.drop = drop;
	}
	public String getTransport() 
	{
		return transport;
	}
	public void setTransport(String transport) 
	{
		this.transport = transport;
	}
	public Date getTripDate() 
	{
		return tripDate;
	}
	public void setTripDate(Date tripDate) 
	{
		this.tripDate = tripDate;
	}
	
	public Customer getCust() 
	{
		return cust;
	}
	public void setCust(Customer cust) 
	{
		this.cust = cust;
	}

	@Override
	public String toString() 
	{
		return "TripDetails [tripId=" + tripId + ", pickup=" + pickup + ", drop=" + drop + ", arrivalTime="
				+ arrivalTime + ", departureTime=" + departureTime + ", transport=" + transport + ", tripDate="
				+ tripDate + ", cust=" + cust + "]";
	}
	
	
}
