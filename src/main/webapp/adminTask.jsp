<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Dashboard</title>
    
	
	<link rel="stylesheet" type="text/css" href="resources/css/dashboard.css">
	 <link rel="stylesheet" type="text/css" href="resources/css/homepage.css">
    <link href="https://fonts.googleapis.com/css?family=Flamenco&display=swap" rel="stylesheet">
	
	<link rel="stylesheet" href="resources/css/sidenav.css">

</head>
<body >
 <header>

                <div class="container">
                        <div id="branding">
                        
                            <h1><span class="highlight">GoHigh</span> Services</h1>
                </div>
            <nav>
                <div>
                    <ul>
                            <li class="current" ><a href="#">Home</a></li>                         
                            <li><a href="#">About</a></li>
                            <li><button class="btn-nav" style="font-size:30px;cursor:pointer; position:relative; left:20px;" onclick="openNav()">&#9776; </button></li>
                    </ul>
                </div>
            </nav>
         </header>
             <div id="mySidenav" class="sidenav">
        <!-- SIDENAV -->
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <ul class="list-side">
            <li><input class="search-box" type="text" placeholder="Search.."></li>
            <li><a href="addLocation.jsp">addLocationDetails</a></li>
            <li><a href="addFlight.jsp">addFlight</a></li>
            <li><a href="deleteFlight.jsp">deleteFlight</a></li>
          
        </ul>
           
        </div>
        <section id="showcase">
            <div class="main-content-header">
            <h3>Please Select Task<span id="bodytext-highlight"> ${sessionScope.admin.adminName }</span></h3><br/>
            	<form action="adminFlightView" >
        <input type="submit" value="View Flights"class="btn btn-full"><br>
	</form>
	 <form  action="logout1"><input type="submit" class="btn btn-full" value="logout"></form>
            </div> 
        </section>
            
            <footer>
            <p>GoHigh Airline Services, Copyright &copy; 2019</p>
        </footer>
</body>
<script src="resources/js/app.js"></script> 
      
 

</body>
</html>