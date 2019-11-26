<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HomePage</title>
</head>
<body>
Welcome back ${ sessionScope.person.fName }
<h1>${message}</h1>

<form action="navigation" method="get">
<input type="submit" value="Search for Flights"/>
</form>


<div align="right">
For logging out Click here
<form  action="logout"><input type="submit" value="logout"></form>
</div>

<div align="center">
For Viewing Bookings Click here
<form action="viewbooking">
Enter Booking Id:<input type="number"  name="bookingId" />
<input type="submit" value="click">
</form>
</div>

<div align="center">
For Deleting Bookings Click here
<form action="deleteBooking">
Enter Booking Id:<input type="number"  name="bookingId" />
<input type="submit" value="click">
</form>
</div>

</body>
</html>