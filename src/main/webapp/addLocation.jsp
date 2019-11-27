<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>GoHigh | AdminAddLoc</title>
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
<div class="div1">
       
        <h1 id="h1">AddLocation</h1>
<form action="admin_locationMaster">  
            <label class="label">CityName</label><br>
            <input class="input-box" type="text" name="cityName" placeholder="Enter City Name" required><br>

            <label class="label">CountryCode</label><br>
            <input class="input-box" type="text" name="code" placeholder="3 character code" required><br>
            
            <label class="label">Airport Name</label><br>
            <input class="input-box" type="text" name="airportName" placeholder="Enter Airport Name" required><br>
            
            <label class="label">Country Name</label><br>
            <input class="input-box" type="text" name="country" placeholder="Enter Country Name" required><br>
        <button class="button" type="submit" value="Submit">SUBMIT</button>
</form> 

 
    </div>


 <footer>
        <p>GoHigh Airline Services, Copyright &copy; 2019</p>
    </footer>



</body>
</html>