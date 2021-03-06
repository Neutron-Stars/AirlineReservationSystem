<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>GoHigh | Welcome</title>
    <link rel="icon" type="image/jpg" href="resources/images/Icon.jpg">
    <link rel="stylesheet" type="text/css" href="resources/css/homepage.css">
    <link rel="stylesheet" type="text/css" href="resources/css/style2.css">
    <link href="https://fonts.googleapis.com/css?family=Flamenco&display=swap" rel="stylesheet">
    
</head>
<body>
    <header>
            <div class="container">
                    <div id="branding">
                        <h1><span class="highlight">GoHigh</span> Services</h1>
            </div>
        
    </header>
    <section id="showcase">
    <div class="div4">
      	<table>
	<tr>
		<td>Source</td>
		<td>Destination</td>
		<td>Departure</td>
		<td>Arrival</td>
		<td>Cost</td>
		<td></td>
	</tr>
	 <c:forEach var="flight" items="${lists}">
		<tr>
		<td>${flight.locationMaster1.name }</td>
        <td>${flight.locationMaster2.name }</td>
        <td>${flight.departureTime }</td>
        <td>${flight.arrivalTime }</td>
        <td>${flight.fareMaster.economyClass }</td>
        <td><a class="btn btn-nav" href="bookflight?flightId=${flight.flightId }">Book Now</a></td>
        </tr>
    </c:forEach>
</table>
	</div>
    </section>
    <footer>
        <p>GoHigh Airline Services, Copyright &copy; 2019</p>
    </footer>
</body>
</html>