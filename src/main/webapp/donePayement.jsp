<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>done page</title>
</head>
<body>
<h1>Payement done</h1>
<!-- <script type="text/javascript">
function validate() {
	if(${session.Scope}==false)
		{
		prompt("login");
		return false;
		}
	else
		return true;
}
</script> -->

<% 
if(session.getAttribute("person1")==null)
{
	response.sendRedirect("login.jsp");
}
%>
<form action="paymentPass">
<input type="submit" value="submit" />  
</form>
</body>
</html>