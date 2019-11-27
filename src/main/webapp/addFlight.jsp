<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>GoHigh | AdminAddFlight</title>
    <link rel="icon" href="resources/css/style.css">
    <link rel="stylesheet" href="resources/css/style.css">
    <link href="https://fonts.googleapis.com/css?family=Flamenco&display=swap" rel="stylesheet">
</head>
<body>

 <header>
                <div class="container">
                        <div id="branding">
                            <h1><span class="highlight">GoHigh</span> Services</h1>
                </div>
            <nav>
      
            </nav>
        </header>
<div class="div4">
       
        <h1 id="h1">AddFlight</h1>
<form action="admin_flightMaster">  
            <label class="label">flightArrivalTime</label><br>
            <input class="input-box" type="time" step="2" name="arrivalTime" placeholder="hh:mm:ss"  required><br>

            <label class="label">flightDepartureTime</label><br>
            <input class="input-box" type="time"  step="2" name="departureTime" placeholder="hh:mm:ss" required><br>
            
            <label class="label">flightStartDate</label><br>
            <input class="input-box" type="date" name="flightTravelDate" placeholder="YYYY-MM-DD hh:mm:ss" required><br>
            
            <label class="label">flightEndDate</label><br>
            <input class="input-box" type="date" name="flightEndDate" placeholder="YYYY-MM-DD hh:mm:ss" required><br>
            
            <label class="label">depLoc</label><br>
            <input class="input-box"  type="number" name="locationMaster1" placeholder="Enter DepID" required><br>
            
            <label class="label">arrLoc</label><br>
            <input class="input-box" type="number" name="locationMaster2" placeholder="Enter ArrID" required><br>
            
            <label class="label">Enter Fleet Id</label><br>
            <input class="input-box" type="number" name="fleetMaster" placeholder="Enter FleetID"required><br>
            
            <label class="label">Enter Fare Id</label><br>
            <input class="input-box" type="number" name="fareMaster"  placeholder="Enter FareID"required><br>
        <button class="button" type="submit" value="Submit">SUBMIT</button>
</form> 

 
    </div>


 <footer>
        <p>GoHigh Airline Services, Copyright &copy; 2019</p>
    </footer>



</body>
</html>