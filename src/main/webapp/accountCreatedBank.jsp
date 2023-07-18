<!DOCTYPE html>
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
  <div style="margin-left: 400px;">
  
  </div>
</div>
<body> 
 <style>
      .center {
        display: block;
        margin-left: auto;
        margin-right: auto;
      }
    </style>
</head>
<body>

<%
	int id = (int)request.getAttribute("id");
session.setAttribute("id", id);
   
   
%>


  <h1 style="text-align: center;" style="font-size: 40px;">Your account has been successfully created</h1>
 <img   src="https://previews.123rf.com/images/krisdog/krisdog2211/krisdog221100203/194661822-thumbs-up-emoji-emoticon-face-cartoon-icon.jpg"width="150" height="150" class = "center">
  <form action = "menu"  method = "post" style = "text-align: center;">
  <h1 style="text-align: center;" style="font-size: 20px;"> Now you can return to the menu page</h1>
 <input type="submit" style="width: 350px; height: 75px;  background-color: #008080; color: #fff;" value="Menu">
  </form>
</body>
</html>