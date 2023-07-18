<!DOCTYPE html>
<%@ page session="true" %>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
	body {
		background-color: #E6E6FA;
	}
</style>
<div style="text-align: center;">
	<img src="Capture.PNG" width=200" height="200">
</div>
</head>
<body>
<%

   int id = (int) session.getAttribute("id");
session.setAttribute("id", id);
%>
	<form action="signUpOtpServlet" method="post" style="text-align: center;">
 		<p><h1 style="text-align: center;font-size: 20px;">Enter Authentication Code</h1></p>
 		<input type="text" name="otp" style ="font-size: 20px; "><br><br>
  		<input type="submit" style="width: 150px; height: 50px;  background-color: #008080; color: #fff;" value="Go">
</form>
</body>
</html>