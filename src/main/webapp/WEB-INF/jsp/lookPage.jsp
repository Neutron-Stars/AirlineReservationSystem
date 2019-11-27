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
			<th> Fare(Buis,Eco,Pre) </th>
			
			<c:forEach var="listValue" items="${getlist}">
			</tr>
			<tr>
			<td>${listValue.flightId}</td>
			<td>${listValue.arrivalTime}</td>
			<td>${listValue.departureTime}</td>
			<td>${listValue.flightTravelDate}</td>
			<td>${listValue.locationMaster1.name}</td>
			<td>${listValue.locationMaster2.name}</td>
			<td>${listValue.fleetMaster.model} ${listValue.fleetMaster.code}</td>
			<td>${listValue.fareMaster.businessClass} ${listValue.fareMaster.economyClass} ${listValue.fareMaster.premiumClass}</td>
			</tr>
				
				
			</c:forEach>
			</table>
		</ul>

	</c:if>
	</div>
    </section>
    <footer>
        <p>GoHigh Airline Services, Copyright &copy; 2019</p>
    </footer>
</body>
</html>