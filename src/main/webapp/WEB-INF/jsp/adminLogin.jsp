<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width">
        <meta name="description" content=" GoHigh Airline Services">
        <meta name="author" content="Gourav Mazumdar">
    <title>GoHigh | ADMIN LOGIN</title>
    <link rel="icon" href="resources/images/signup.png">
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
                            <li><a href="#">About</a></li>
                    </ul>
                </div>
            </nav>
        </header>
    <div class="div1">
       
        <h1 id="h1">Admin Sign IN</h1>
<form action="checkAdmin" method="post">  
            <label class="label">AdminName</label><br>
            <input class="input-box" type="text" name="adminName" placeholder="Enter Name" required><br>

            <label class="label">AdminPassword</label><br>
            <input class="input-box" type="password" name="adminPassword" placeholder="Enter Password" required><br>

        <button class="button" type="submit" value="Submit">SUBMIT</button>
</form> 
    </div>
    <footer>
            <p>GoHigh Airline Services, Copyright &copy; 2019</p>
    </footer>
</body>
</html>