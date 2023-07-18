
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
		body {
			background-color: #E6E6FA;
		}
	</style>
<div style="display: flex;">
 <img src="insigna.PNG" width="150" height="150">
  <div style="margin-left: 700px;"> 
  <p>    
</p>
  </div>
</div>
<body> 
</head>
<body>
<%
   int id = (int) request.getAttribute("id");
session.setAttribute("id", id);
%>
<h1 style="text-align: center; color:#BC8F8F; font-size: 100px;">Menu</h1></p>
	<form action="validateOtp" method="post" style="text-align: center;">
	 <input type="submit" style="width: 350px; height: 75px;  background-color: #008080; color: #fff;" value="Create a bank account">
	</form>

 
  
<form action = "validateOtpCont" method = "post" style = "text-align: center;">


         <input type="submit" style="width: 350px; height: 75px;  background-color: #008080; color: #fff;" value="View already existing bank accounts">
</form>

</body>
</html>