<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>GoHigh | Welcome</title>
    <link rel="icon" type="image/jpg" href="resources/images/Icon.jpg">
    <link rel="stylesheet" type="text/css" href="resources/css/homepage.css">
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
                        <li class="current" ><a href="#">Home</a></li>
       
                        <li><a href="registerPage.jsp">SignUp</a></li>
                        <li><a href="#">Search</a></li>
                        <li><a href="#">About</a></li>
                </ul>
            </div>
        </nav>
    </header>
    <section id="showcase">
        <div class="main-content-header">
        <h3>Welcome To <span id="bodytext-highlight">GoHigh</span> Flight Services</h3>
	<form action="navigation" method="get">
        <input type="submit" value="Search for Flights"class="btn btn-full"><br>
	</form>
        <a href="login.jsp" class="btn btn-nav">SignIn</a>
        </div> 
    </section>
    <footer>
        <p>GoHigh Airline Services, Copyright &copy; 2019</p>
    </footer>
</body>
</html>