<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>FlightDelete</title>
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

        <div class="div3">
       
                <h1 id="h1">FLIGHT DELETE STATUS</h1>
                    <label class="label">FlightId</label><br>
                    <form action="admin_flightDelete">
                    <input class="input-box" type="number" name="flightId" placeholder="Enter Flight ID" required><br>
        			       <button class="button" type="submit" value="Submit">SUBMIT</button>
        			</form>
        </div>
      
</body>
</html>