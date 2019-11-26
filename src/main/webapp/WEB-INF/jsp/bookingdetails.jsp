<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking details</title>
</head>
<body>
<c:if test="${not empty Bookings}">

		<ul>
		<table>
			<tr>
			<th> bookingId </th>
			<th> bookingDate </th>
			<th> bookingNumber </th>
			<th> seatClass </th>
			<th> seatsBooked </th>
			<th> totalCost </th>
			<th> travelDate </th>
			
			
			<c:forEach var="listValue" items="${Bookings}">
			</tr>
			<tr>
			<td>${listValue.bookingId}</td>
			<td>${listValue.bookingDate}</td>
			<td>${listValue.bookingNumber}</td>
			<td>${listValue.seatClass}</td>
			<td>${listValue.seatsBooked}</td>
			<td>${listValue.totalCost}</td>
	
		
			</tr>
				
				
			</c:forEach>
			</table>
		</ul>

	</c:if>
</table>
</body>
</html>