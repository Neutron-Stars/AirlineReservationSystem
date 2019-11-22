<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of available Flights</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
</head>
<body>
<h1>${message }</h1>
<c:if test="${not empty getlist}">

		<ul>
		<table>
			<tr>
			<th> FlightId </th>
			<th> ArrivalTime </th>
			<th> DepartureTime </th>
			<th> FlightTravelDate </th>
			<th> DepartureLoc </th>
			<th> ArrivalLoc </th>
			<th> FleetId </th>
			<th> FareId </th>
			
			<c:forEach var="listValue" items="${getlist}">
			</tr>
			<tr>
			<td>${listValue.flightId}</td>
			<td>${listValue.arrivalTime}</td>
			<td>${listValue.departureTime}</td>
			<td>${listValue.flightTravelDate}</td>
			<td>${listValue.locationMaster1.name}</td>
			<td>${listValue.locationMaster2.name}</td>
			<td>${listValue.fleetMaster.fleetMasterId}</td>
			<td>${listValue.fareMaster.fareMasterId}</td>
			</tr>
				
				
			</c:forEach>
			</table>
		</ul>

	</c:if>
</body>
</html>