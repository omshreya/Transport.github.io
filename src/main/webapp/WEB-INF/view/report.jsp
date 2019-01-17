<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	h1
	{
		text-align:center;
	}
	div 
	{
	  width: 500px;
	  padding: 10px;
	  border: 5px solid DarkSlateGray;
	  margin: 0;
	  align:center;
	}
	th
	{
		color:Blue;
	}
	td
	{
		color:Coral;
	}
.footer 
{
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: red;
   color: white;
   text-align:left;
   
}
.one
{
	text-align:right;
	float: right;
}
</style>
<title>Insert title here</title>
</head>
<body background="images/Wallpaper.jpg">
<h1>Report</h1>
	<h1 style="background-color:LightSeaGreen; color:MidnightBlue ;">Booking Details</h1>
<div>
	<table>
    <tbody>
    <tr>
		<th>Name</th>
		<td><%= session.getAttribute("fullname") %></td>
	</tr>
	<tr>
		<th>Pickup Location</th>
		<td><%= session.getAttribute("pickup") %></td>
	</tr>
	<tr>
		<th>Drop Location</th>
		<td><%= session.getAttribute("drop") %></td>
	</tr>
	<tr>
		<th>Arrival Time</th>
		<td><%= session.getAttribute("arrivalTime") %></td>
	</tr>
	<tr>
		<th>Departure Time</th>
		<td><%= session.getAttribute("departureTime") %></td>
	</tr>
	<tr>
		<th>Transport</th>
		<td><%= session.getAttribute("transport") %></td>
	</tr>
	<tr>
		<th>Trip Date</th>
		<td><%= session.getAttribute("tripDate") %></td>
	</tr>
	<tr>
		<th>Seat Number</th>
		<td>${seatnumber}</td>
	</tr>
	<tr>
		<th>Bill</th>
		<td>${bill}</td>
	</tr>
	</tbody>
</table>
</div>
<div class="footer">
  <a href="home">Back</a>
  <a class="one" href="logout">Log out</a>
</div>
</body>
</html>