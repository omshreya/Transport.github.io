package com.transfer.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.transfer.model.Extra;
import com.transfer.model.Login;
import com.transfer.model.Trip;
import com.transfer.pojo.Customer;
import com.transfer.pojo.TripDetails;
import com.transfer.service.TransferService;

@Controller
public class TransportController 
{
	@Autowired
	private TransferService service;
	
	private int count=12,seatnumber=0;
	
	@RequestMapping("/login")
	public String doLogin()
	{
		return "index";
	}
	
	@RequestMapping("/doVal")
	public String checkPersonInfo(@ModelAttribute("cred") Login cred,Model model,HttpSession session) 
	{
		System.out.println("Hii");
		System.out.println(cred.toString());
		Customer c=service.Validate(cred);
		Customer c1=service.getCustomer(cred.getUsername());
		int id=c1.getId();
		if(c!=null)
		{
			session.setAttribute("id", id);
			System.out.println("id="+id);
			model.addAttribute("Username", c.getUsername());
			return "home";
		}
		else
		{
			return "index";
		}
    } 
	
	@RequestMapping("home")
	public String goHome()
	{
		return "home";
	}
	
	@RequestMapping("route")
	public String goRoute()
	{
		return "route";
	}
	
	@RequestMapping("facility")
	public String goFacility()
	{
		return "facility";
	}
	
	@RequestMapping("checkDetails")
	public String checkDetails()
	{
		return "report";
	}
	
	@RequestMapping("logout")
	public String doLogout(HttpSession session)
	{
		session.invalidate();
		return "index";
	}
	
	@GetMapping("/doRegister")
	public ModelAndView showInsert()
	{
		System.out.println("in insert");
		return new ModelAndView("register", "cust", new Customer());
	}
	
	@PostMapping("/doRegister")
	public ModelAndView addCust(@ModelAttribute("cust") Customer cust)
	{
		
			try
			{
				if(cust.getPassword().equals(cust.getConfirmpassword()))
				{
					service.getCust(cust);
					return new ModelAndView("home","cust",cust);
				}
				else
				{
					return new ModelAndView("register","cust",new Customer());
				}
			}
			catch(Exception e)
			{
				return new ModelAndView("register","cust",new Customer());
			}
	}
		
	
	
	@RequestMapping("/fixRoute")
	public String check(Trip trip,HttpSession session,Model model)
	{
		Date str=trip.getTripDate();
		System.out.println("Trip date:"+str);
		int id=(int) session.getAttribute("id");
		Customer cust=service.getById(id);
		System.out.println("Session Object="+cust.toString());
		session.setAttribute("fullname", cust.getFullname());
		session.setAttribute("pickup", trip.getPickup());
		session.setAttribute("drop", trip.getDrop());
		session.setAttribute("arrivalTime", trip.getArrivalTime());
		session.setAttribute("departureTime", trip.getDepartureTime());
		session.setAttribute("transport", trip.getTransport());
		session.setAttribute("tripDate", trip.getTripDate());
		System.out.println("Trip details :"+trip.toString());
		
		TripDetails t=new TripDetails();
		//t.setTripId(tripId);
		t.setPickup(trip.getPickup());
		t.setDrop(trip.getDrop());
		t.setArrivalTime(trip.getArrivalTime());
		t.setDepartureTime(trip.getArrivalTime());
		t.setTransport(trip.getTransport());
		t.setTripDate(trip.getTripDate());
		t.setCust(cust);
		service.getDetails(t);
		System.out.println(t.toString());
		
		for(int i=1;i<=count;i++)
		{
			seatnumber=i;
			model.addAttribute("seatnumber", seatnumber);
		}
		return "report";
	}
	
	@RequestMapping("/addFacility")
	public String addFacility(Extra extra,Model model)
	{
		int bill=extra.getFood()+extra.getStay();
		model.addAttribute("bill", bill);
		return "report";
	}
}
