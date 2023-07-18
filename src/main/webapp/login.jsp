<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
	body {
		background-color: #E6E6FA;
	}
</style>
<div style="display: flex;">
	<img src="insigna.PNG" width="100" height="100">
		<div style="margin-left: 700px;">
			<p><h1 style="text-align: center;font-size: 20px;">Log In</h1></p>
			<p><h1 style="text-align: center;font-size: 20px;">Enter email address:</h1></p>
		</div>
</div>
</head>
<body>
	<form action="login" method="post" style="text-align: center;">
	<input type = "text" name = "email" style ="font-size: 20px; "><br>
		<h1 style="text-align: center;font-size: 20px;">Enter password:</h1>
	<input type = "password" name = "password" style ="font-size: 20px; "><br>
    <input type="submit" style="width: 150px; height: 50px;  background-color: #008080; color: #fff;" value="Sign Up">
</form>
</body>
</html>