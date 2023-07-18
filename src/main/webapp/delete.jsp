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
   int id = (int) session.getAttribute("id");
session.setAttribute("id", id);
%>
<form action = "deleteAccountServlet"  method = "post" style = "text-align: center;">
  <h1 style="text-align: center;" style="font-size: 40px;">Doriti sa stergeti contul cu iban-ul</h1>
  <input type="text" name = "iban" style="border: 1px solid gray; text-align: center;width: 150px; height:25px;padding: 3px; padding-left: 100px;background-color: #E6E6FA; ">
 <img   src="https://previews.123rf.com/images/krisdog/krisdog2211/krisdog221100203/194661822-thumbs-up-emoji-emoticon-face-cartoon-icon.jpg"width="150" height="150" class = "center">
  
 <input type="submit" style="width: 350px; height: 75px;  background-color: #008080; color: #fff;" value="Delete">
  </form>
</body>
</html>