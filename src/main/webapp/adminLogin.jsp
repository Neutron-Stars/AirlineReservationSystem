<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>adminLoginPage</title>
</head>
<body>
<form method="post" action="checkAdmin">
username:<input type="text" name="adminName"/>
password:<input type="password" name="adminPassword" required/>
<input type="submit" value="login"/>
</form>
</body>
</html>