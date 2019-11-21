<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="debitcredit.css"/>
    <script src="debitcredit.js"></script>
</head>
<body>
	  <div class="wrapper">
                <div class="container">
                  <div class="title">Debit/Credit Card Details</div>
                  
                  <div class="input-form">
                    <div class="section-1">
                      <div class="items">
                        <label class="label">Card Number</label>
                        <input type="text" class="input"  name="cardNo" required maxlength="16" data-mask="0000 0000 0000 0000"placeholder="1234 1234 1234 1234">
                      </div>
                    </div>
                    <div class="section-2">
                      <div class="items">
                        <label class="label">Name On The Card</label>
                        <input type="text" required class="input"  name="cardholdername" placeholder="Name On Card">
                      </div>
                    </div>
                    <div class="section-3">
                      <div class="items">
                        <label class="label">Expire date</label>
                        <input type="text" required class="input"  name="expDate" data-mask="00 / 00" placeholder="MM / YY">
                      </div>
                      <div class="items">
                        <div class="cvc">
                          <label class="label">cvc code</label>
                          <div class="tooltip">
                            <div class="cvc-img"><img src="https://i.imgur.com/r8oXtry.png" alt=""></div>
                          </div>
                        </div>
                        <input type="text" required class="input" data-mask="000" placeholder="000" maxlength="3">
                      </div>
                    </div>
                  </div>
                  <div>
                    <input type="submit" class="btn" value="Pay" name="Pay">
                  </div>
                  
                </div>
              </div>

</body>
</html>