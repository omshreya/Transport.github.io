package com.transfer.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Trip 
{
	private String pickup;
	private String drop;
	private String arrivalTime;
	private String departureTime;
	private static String transport;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date tripDate;
	
	public Trip(){}

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
	
	private static int[] seats = new int[12];
	public static int seatnumber=0;
	private static void bookSeat()
	{
		 for (int i = 0; i < 12; i++) 
	     {
	         seats[i] = 0;
	     }
		 
		 if(transport=="Bus")
		 {
			 seatnumber = bookWindow();
             // No window seats available, try booking an aisle seat for them instead.
             if (seatnumber == -1) 
             {
                 seatnumber = bookAisle();
                 if (seatnumber != -1) 
                 {
                     System.out.println("Sorry, we were not able to book a window seat. But do have an aisle seat.");
                     printBoardingPass(seatnumber);
                 }
             }
             else 
             {
                 // Booking a window seat was successful.
                 System.out.println("You are in luck, we have a window seat available!");
                 printBoardingPass(seatnumber);
             }
		 }
		 else if(transport.equals("Travel"))
		 {
			 // If they chose booking an isle, check to see if it is available.
             seatnumber = bookAisle();
             // If not available, see if we have window seats available.
             if (seatnumber == -1) 
             {
                 seatnumber = bookWindow();
                 if (seatnumber != -1) 
                 {
                     System.out.println("Sorry, we were not able to book an aisle seat. But do have a window seat.");
                     printBoardingPass(seatnumber);
                 }
             }
             else 
             {
                 // Booking an aisle seat was successful.
                 System.out.println("You are in luck, we have an aisle seat available!");
                 printBoardingPass(seatnumber);
             }
		 }
		 else
		 {
			 System.out.println("Invalid Choice");
		 }
		 if (seatnumber == -1) 
         {
             System.out.println("We are sorry, there are no window or aisle seats available.");
             System.out.println();
         }
		 
	}
	 
	 private static int bookWindow() 
		{
	        for (int i = 0; i < 6; i++) 
	        {
	            if (seats[i] == 0) 
	            {
	                seats[i] = 1;
	                return i + 1;
	            }
	        }
	        return -1;
	    }
	    private static int bookAisle() 
		{
	        for (int i = 6; i < 12; i++) 
	        {
	            if (seats[i] == 0) 
	            {
	                seats[i] = 1;
	                return i + 1;
	            }
	        }
	        return -1;

	    }
	    
	    private static void printBoardingPass(int seatnumber) 
		{
	        Date timenow = new Date();
	        System.out.println();
	        System.out.println("Date: " + timenow.toString());
	        System.out.println("Boarding pass for seat number: " + seatnumber);
	        System.out.println("This ticket is non-refundable and non-transferable.");
	        System.out.println("Please be curteous, do not smoke. Enjoy your trip.");
	        System.out.println();
	    }
	
	@Override
	public String toString() 
	{
		return "Trip [pickup=" + pickup + ", drop=" + drop + ", arrivalTime=" + arrivalTime + ", departureTime="
				+ departureTime + ", transport=" + transport + ", tripDate=" + tripDate + "]";
	}
	
}
