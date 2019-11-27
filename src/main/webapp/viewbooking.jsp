<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Booking</title>
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
                <div>
                    <ul>
                            <li ><a href="frontPage.jsp">Home</a></li>
                            <li class="current"><a href="#">Status</a></li>
                         <li><a href="#">About</a></li>
                    </ul>
                </div>
            </nav>
        </header>

        <div class="div3">
       
                <h1 id="h1">BOOKING STATUS</h1>
                    <label class="label">BookingID</label><br>
                    <form action="viewbooking">
                    <input class="input-box" type="number" name="bookingId" placeholder="Enter Booking ID" required><br>
        			       <button class="button" type="submit" value="Submit">SUBMIT</button>
        			</form>
        </div>
      
</body>
</html>