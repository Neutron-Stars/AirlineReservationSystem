<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
            <nav>
                <div>
                    <ul>
                            <li ><a href="frontPage.jsp">Home</a></li>
                            
                            <li><a href="registerPage.jsp">SignUp</a></li>
                            <li><a href="navigation.jsp">Search</a></li>
                            <li><a href="adminLogin.jsp">AdminLogin</a></li>
                    </ul>
                </div>
            </nav>
        </header>
<div class="div1">
       
        <h1 id="h1">Sign IN</h1>
<form action="checkLogin" method="post">  
            <label class="label">Usermail</label><br>
            <input class="input-box" type="text" name="email" placeholder="Enter Email" required><br>

            <label class="label">Password</label><br>
            <input class="input-box" type="password" name="password" placeholder="Enter Password" required><br>

        <button class="button" type="submit" value="Submit">SUBMIT</button>
</form> 

  <hr>
        <p class="or">OR</p>
        <p>Create Account<p>
            <button class="button" value="Register" onclick=location.href="registerPage.jsp">REGISTER</button>
    </div>


 <footer>
        <p>GoHigh Airline Services, Copyright &copy; 2019</p>
    </footer>



</body>
</html>