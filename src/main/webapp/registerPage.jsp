<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <script type="javascript">
        function fun(){
            document.getElementById("hid").value=document.getElementById("gender").value;
        }
    </script>
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
                    <li ><a href="homepage.html">Home</a></li>
                    <li><a href="#">Status</a></li>
                    <li class="current"><a href="register.html">SignUp</a></li>
                    <li><a href="#">Search</a></li>
                    <li><a href="#">About</a></li>
            </ul>
        </div>
    </nav>
</header>


<div class="div2">
       
    <h1 id="h1">REGISTER</h1>
    <form action="register" method="post">
    
     <label class="label">PERSON ID</label><br>
        <input class="input-box" type="number" name="personId" placeholder="Enter Your Fav Id" required><br>
    
    	 <label class="label">Title</label><br>
        <input class="input-box" type="text" name="title" placeholder="Enter Mr/Ms/Mrs" required><br>
        
        <label class="label">FIRST NAME</label><br>
        <input class="input-box" type="text" name="fName" placeholder="Enter First Name" required><br>

        <label class="label">LAST NAME</label><br>
        <input class="input-box" type="text" name="lName" placeholder="Enter Last Name" required><br>
        
        <label class="label">MIDDLE NAME</label><br>
        <input class="input-box" type="text" name="mName" placeholder="Enter Middle Name" ><br>

        <label class="label">Date of Birth</label><br>
        <input class="input-box" type="date" name="DOB" placeholder="Enter DOB" required><br>

        <label class="label">Mobile</label><br>
        <input class="input-box" type="number" name="mobileNumber" placeholder="Enter MobileNo." required><br>

        <label class="label">Gender</label><br>
        <input class="radio" type="radio" name="gender" value="male"> Male
        <input class="radio" type="radio" name="gender" value="female"> Female<br>
        <input type="hidden" id="hid" name="isgender">

        <label class="label">EMAIL</label><br>
        <input class="input-box" type="email" name="email" placeholder="Enter Email" required><br>

        <label class="label">Password</label><br>
        <input class="input-box" type="password" name="password" placeholder="Enter Password" required><br>
        
         <label class="label">Passport NO</label><br>
        <input class="input-box" type="text" name="passportNumber" placeholder="Enter Passport No" ><br>
		
		
       

    <button class="button"  type="submit"  value="Submit">SUBMIT</button>
</form>

</div>
    <footer>
        <p>GoHigh Airline Services, Copyright &copy; 2019</p>
    </footer>

</body>
</html>