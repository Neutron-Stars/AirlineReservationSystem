<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>GoHigh | LOGIN</title>
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
        </header>

<h2>Please Fill this Ticket</h2>
<div>
		<label>FlightMaster ID <p> ${flight.flightId}</p></label>
		<label>Arrival Time <p> ${flight.arrivalTime}</p></label>
		<label>Source Location <p>${flight.locationMaster1.name}</p></label>
		<label>Destination Location <p> ${flight.locationMaster2.name}</p></label>
	</div>
	
	
<button onclick="add()" id="old_button1">Add</button> 
	<form action="bookTicket" method="post">
	
	<input type="number" id="seat" name="seat" value="1"><br>
	<input type="hidden" name="flightId" value="${flight.flightId }">
<!-- 	<input type="text" name="Status" placeholder="status"> -->
	<select name="classType">
		<option value="economy">Economy</option>
		<option value="premium">Premium</option>
		<option value="buisness">Buisness</option>
	</select>
	<input type="text" name="username0" placeholder="First Name">
	<input type="text" name="middlename0" placeholder="Middle Name">
	<input type="text" name="lastname0" placeholder="Last Name">
	<input type="number" name="age0" placeholder="Enter Age">
	<input type="text" name="passport0" placeholder="Enter passport">
	<select name="gender">
		<option value="M">Male</option>
		<option value="F">Female</option>
	</select>
<select name="passengerType0">
		<option value="adult">Adult</option>
		<option value="child">Child</option>
	</select>
<select name="meal0">
		<option value="veg">VEG</option>
		<option value="nvg">NON-VEG</option>
	</select>
	<div id="formMore">
		
	</div>
	<script type="text/javascript">
		function add()
			{
				var d=document.getElementById('seat').value;
				document.getElementById('seat').value=parseInt(d)+1;
				i=i+1;
				document.getElementById('formMore').style.visibility='visible';
				document.getElementById('formMore').innerHTML+='<br><select name="gender"><option value="economy">Economy</option><option value="premium">Premium</option><option value="buisness">Buisness</option></select><input type="text" name="username'+i+'" placeholder="First Name"><input type="text" name="middlename'+i+'" placeholder="Middle Name"><input type="text" name="Status'+i+'" placeholder="Status"><input type="text" name="lastname'+i+'" placeholder="Last Name"><input type="number" name="age'+i+'" placeholder="Enter Age"><input  type="text" name="passport'+i+'" placeholder="Enter passport"><select name="gender'+i+'"><option value="M">Male</option><option value="F">Female</option></select><select name="passengerType0"><option value="adult">Adult</option><option value="child">Child</option></select><select name="meal0"><option value="veg">VEG</option><option value="nvg">NON-VEG</option></select>';	}
	</script>
	<input type="submit" value="submit" name="submit"/>

	</form>

	


 <footer>
        <p>GoHigh Airline Services, Copyright &copy; 2019</p>
    </footer>



</body>
</html>