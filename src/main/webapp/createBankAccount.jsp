<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<style>
		body {
			background-color: #E6E6FA;
		}
	</style>
	<div style="position: relative;">
  <img src="cover.PNG" >
  <div style="position: absolute; top: 50%; left: 70%; transform: translate(-50%, -50%);">
 <%

   int id = (int) session.getAttribute("id");
session.setAttribute("id", id);
out.println("id= " + id);
%>
    <p><form action = "bankAccountServletNew" method = "post" style = "text-align: center;">
   <p><h1 style="text-align: center;font-size: 50px;">Cont Bancar</h1></p>
  <p><h1 style="text-align: center;font-size: 20px;">Adresa de email:</h1></p>
  <input type = "text" name = "email" style ="font-size: 20px; "><br>
   <p><h1 style="text-align: center;font-size: 20px;">CNP:</h1></p>
  <input type = "text" name = "cnp" style ="font-size: 20px; "><br>
   <p><h1 style="text-align: center;font-size: 20px;">Adresa</h1></p>
    <p><h1 style="text-align: center;font-size: 20px;">Oras:</h1></p>
  <input type = "text" name = "oras" style ="font-size: 20px; "><br>
   <p><h1 style="text-align: center;font-size: 20px;">Strada:</h1></p>
     <input type = "text" name = "strada" style ="font-size: 20px; "><br>
   <p><h1 style="text-align: center;font-size: 20px;">In valoare de </h1></p>
    <input type = "text" name = "suma" style ="font-size: 20px; "><br>
<span>
     <select name="moneda" style ="font-size: 20px;">
        <option value="lei">Lei</option>
        <option value="euro">Euro</option>
        <option value="USD">USD</option>
     </select> <br><br>
</span>
         <input type="submit" style="width: 150px; height: 50px;  background-color: #008080; color: #fff;" value="Create Account">
</form></p>
  </div>
</div>
</body>
</html>