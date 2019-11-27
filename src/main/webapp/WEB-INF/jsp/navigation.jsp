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
            <nav>
                <div>
                    <ul>
                            <li ><a href="frontPage.jsp">Home</a></li>
                           <li><a href="adminLogin.jsp">AdminLogin</a></li>
                    </ul>
                </div>
            </nav>
        </header>

       
       <section id="showcase">
       <div class="div1">
        <h1 id="h1">Search Flight</h1>
<form method="get" action="flightList">
            <label class="label">Source:</label><br>
            <select  class="input-box" name="source">
             <c:forEach var="line" items="${total}">
        <option value="${line.locationMasterId}"><c:out value="${line.name}"/>( ${line.code} )</option>
    </c:forEach>
            </select><br>

<label class="label">Destination:</label><br>
           <select class="input-box" name="destination">
              <c:forEach var="line" items="${total}">
        <option value="${line.locationMasterId}"><c:out value="${line.name}"/>( ${line.code} )</option>
    </c:forEach>
            </select><br>
            
          <label class="label">Date</label><br>
 <input class="input-box" type="date" name="dateOfJourney" /> 

        <button class="button" type="submit" value="Submit">SUBMIT</button>
</form> 
  </div>
</section>


 <footer>
        <p>GoHigh Airline Services, Copyright &copy; 2019</p>
    </footer>



</body>
</html>