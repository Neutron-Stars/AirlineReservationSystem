<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding Flight</title>
</head>
<body>
<form action="admin_flightMaster">
flightArrivalTime:<input type="date" name="arrivalTime" placeholder="YYYY-MM-DD hh:mm:ss"/><br/><br/>
flightDepartureTime:<input type="date" name="departureTime" placeholder="YYYY-MM-DD hh:mm:ss"/><br/><br/>
flightTravelDate:<input type="date" name="flightTravelDate" placeholder="YYYY-MM-DD hh:mm:ss"/><br/><br/>
depLoc:<input type="number" name="locationMaster1.locationMasterId"><br/><br/>
arrLoc:<input type="number" name="locationMaster2.locationMasterId"><br/><br/>
Enter Fleet Id:<input type="number" name="fleetMaster.fleetMasterId"><br/><br/>
Enter Fare Id:<input type="number" name="fareMaster.fareMasterId"><br/><br/>
<input type="submit" value="Submit">
</form>

</body>
</html>