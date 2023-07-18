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
<div style="display: flex;">
	<img src="insigna.PNG" width="30" height="30">
 		<div style="margin-left: 0px;">
			<p><h1 style="font-size: 10px;">Bank of all possibilities</h1></p>
		</div>
		<div style="margin-left: 600px;">
			<p> <h1 style="text-align: center;font-size: 20px;">Formular pentru crearea unui imprumut</h1></p>
		</div>
</div>
<body>
<form action = "creditAccount" method = "post" style = "text-align: center;">
<div style="display: flex;">
		<p> <h1 style="text-align: center;font-size: 10px;">Subsemnatul/-a  :</h1></p>  
		<input type="text" name = "nume" style="border: 1px solid gray; width: 100px; height:10px;padding: 3px; padding-left: 100px;background-color: #E6E6FA; ">
  		<input type="text"  name = "prenume" style="border: 1px solid gray;width: 100px; height: 10px; padding: 3px; padding-left: 100px;background-color: #E6E6FA; ">
</div>

<div style="display: flex;">
		<p> <h1 style="text-align: center;font-size: 10px;">Rog sa constituiti un credit in valoare de</h1></p>
		<input type="text" name = "suma" style="border: 1px solid gray; width: 100px; height:10px;padding: 3px; padding-left: 100px;background-color: #E6E6FA; ">
		<span>
     		<select name="moneda" style ="font-size: 10px;background-color: #E6E6FA;">
        		<option value="lei">Lei</option>
        		<option value="euro">Euro</option>
        		<option value="USD">USD</option>
 			</select> <br><br>
 		</span>
</div>

<div style="display: flex;">
		<p> <h1 style="text-align: center;font-size: 10px;background-color: #E6E6FA;">Incepand cu data de</h1></p>
		
		<span>
     		<select name="luna" style ="font-size: 10px;background-color: #E6E6FA;">
        		<option value="1">Ianuarie</option>
        		<option value="2">Februarie</option>
        		<option value="3">Martie</option>
        		<option value="4">Aprilie</option>
        		<option value="5">Mai</option>
        		<option value="6">Iunie</option>
        		<option value="7">Iulie</option>
        		<option value="8">August</option>
        		<option value="9">Septembrie</option>
        		<option value="10">Octombrie</option>
        		<option value="11">Noiembrie</option>
        		<option value="12">Decembrie</option>
    		 </select> 
		</span>
		<span>
     		<select name="ziua" style ="font-size: 10px;background-color: #E6E6FA;">
          		<option value="1">1</option>
          		<option value="2">2</option>
          		<option value="3">3</option>
          		<option value="4">4</option>
          		<option value="5">5</option>
          		<option value="6">6</option>
          		<option value="7">7</option>
          		<option value="8">8</option>
          		<option value="9">9</option>
          		<option value="10">10</option>
          		<option value="11">11</option>
          		<option value="12">12</option>
          		<option value="13">13</option>
          		<option value="14">14</option>
          		<option value="15">15</option>
          		<option value="16">16</option>
          		<option value="17">17</option>
          		<option value="18">18</option>
          		<option value="19">19</option>
          		<option value="20">20</option>
          		<option value="21">21</option>
          		<option value="22">22</option>
          		<option value="23">23</option>
          		<option value="24">24</option>
          		<option value="25">25</option>
          		<option value="26">26</option>
          		<option value="27">27</option>
          		<option value="28">28</option>
          		<option value="29">29</option>
         		<option value="30">30</option>
         		<option value="31">31</option>
     		</select>
		</span>
		<span>
     		<select name="an" style ="font-size: 10px;background-color: #E6E6FA;">
     			<option value="2024">2030</option>
     			<option value="2024">2029</option>
     			<option value="2024">2028</option>
          		<option value="2024">2027</option>
          		<option value="2023">2026</option>
          		<option value="2022">2025</option>
          		<option value="2021">2024</option>
         	 	<option value="2020">2023</option>
			</select>
		</span>
</div>
<div style="display: flex;">
		<p><h1 style="text-align: center;font-size: 10px;">pe numele</h1></p>
		<input type="text" name = "numeTitular" style="border: 1px solid gray; width: 100px; height: 10px;padding: 3px; padding-left: 100px;background-color: #E6E6FA; ">
		<input type="text" name = "prenumeTitular" style="border: 1px solid gray; width: 100px; height: 10px;padding: 3px; padding-left: 100px;background-color: #E6E6FA; ">
</div>
<div style="display: flex;">
		<p><h1 style="text-align: center;font-size: 10px;">actul de identitate seria</h1></p>
		<input type="text" name = "seria" style="border: 1px solid gray; width: 100px; height: 10px;padding: 3px; padding-left: 100px;background-color: #E6E6FA; ">
		<input type="text" name = "numarul" style="border: 1px solid gray; width: 100px; height: 10px;padding: 3px; padding-left: 100px;background-color: #E6E6FA; ">
		<p><h1 style="text-align: center;font-size: 10px;">eliberat de of.</h1></p>
 		<input type="text" name = "eliberat" style="border: 1px solid gray; width: 100px; height: 10px;padding: 3px; padding-left: 100px;background-color: #E6E6FA; ">
</div>
<div style="display: flex;">		
		<p><h1 style="text-align: center;font-size: 10px;">la data de</h1></p>
		<span>
     		<select name="start_luna" style ="font-size: 10px;background-color: #E6E6FA;">
        		<option value="1">Ianuarie</option>
        		<option value="2">Februarie</option>
        		<option value="3">Martie</option>
        		<option value="4">Aprilie</option>
        		<option value="5">Mai</option>
        		<option value="6">Iunie</option>
        		<option value="7">Iulie</option>
        		<option value="8">August</option>
        		<option value="9">Septembrie</option>
        		<option value="10">Octombrie</option>
        		<option value="11">Noiembrie</option>
        		<option value="12">Decembrie</option>
    		 </select> 
		</span>
		<span>
     		<select name="start_ziua" style ="font-size: 10px;background-color: #E6E6FA;">
          		<option value="1">1</option>
          		<option value="2">2</option>
          		<option value="3">3</option>
          		<option value="4">4</option>
          		<option value="5">5</option>
          		<option value="6">6</option>
          		<option value="7">7</option>
          		<option value="8">8</option>
          		<option value="9">9</option>
          		<option value="10">10</option>
          		<option value="11">11</option>
          		<option value="12">12</option>
          		<option value="13">13</option>
          		<option value="14">14</option>
          		<option value="15">15</option>
          		<option value="16">16</option>
          		<option value="17">17</option>
          		<option value="18">18</option>
          		<option value="19">19</option>
          		<option value="20">20</option>
          		<option value="21">21</option>
          		<option value="22">22</option>
          		<option value="23">23</option>
          		<option value="24">24</option>
          		<option value="25">25</option>
          		<option value="26">26</option>
          		<option value="27">27</option>
          		<option value="28">28</option>
          		<option value="29">29</option>
         		<option value="30">30</option>
         		<option value="31">31</option>
     		</select>
		</span>
		<span>
     		<select name="start_an" style ="font-size: 10px;background-color: #E6E6FA;">
     			<option value="2024">2030</option>
     			<option value="2024">2029</option>
     			<option value="2024">2028</option>
          		<option value="2024">2027</option>
          		<option value="2023">2026</option>
          		<option value="2022">2025</option>
          		<option value="2021">2024</option>
         	 	<option value="2020">2023</option>
         	 	<option value="2020">2022</option>
         	 	<option value="2020">2021</option>
         	 	<option value="2020">2020</option>
         	 	<option value="2020">2019</option>
         	 	<option value="2020">2018</option>
         	 	<option value="2020">2017</option>
         	 	<option value="2020">2016</option>
         	 	<option value="2020">2015</option>
         	 	<option value="2020">2014</option>
         	 	<option value="2020">2013</option>
         	 	<option value="2020">2012</option>
         	 	<option value="2020">2011</option>
         	 	<option value="2020">2010</option>
         	 	<option value="2020">2009</option>
         	 	<option value="2020">2008</option>
         	 	<option value="2020">2007</option>
         	 	<option value="2020">2006</option>
         	 	<option value="2020">2005</option>
         	 	<option value="2020">2004</option>
         	 	<option value="2020">2003</option>
         	 	<option value="2020">2002</option>
         	 	<option value="2020">2001</option>
         	 	<option value="2020">2000</option>
         	 </select>
		</span>
		<p><h1 style="text-align: center;font-size: 10px;">valabil pana la data de</h1></p>
		<span>
     		<select name="end_luna" style ="font-size: 10px;background-color: #E6E6FA;">
        		<option value="1">Ianuarie</option>
        		<option value="2">Februarie</option>
        		<option value="3">Martie</option>
        		<option value="4">Aprilie</option>
        		<option value="5">Mai</option>
        		<option value="6">Iunie</option>
        		<option value="7">Iulie</option>
        		<option value="8">August</option>
        		<option value="9">Septembrie</option>
        		<option value="10">Octombrie</option>
        		<option value="11">Noiembrie</option>
        		<option value="12">Decembrie</option>
    		 </select> 
		</span>
		<span>
     		<select name="end_ziua" style ="font-size: 10px;background-color: #E6E6FA;">
          		<option value="1">1</option>
          		<option value="2">2</option>
          		<option value="3">3</option>
          		<option value="4">4</option>
          		<option value="5">5</option>
          		<option value="6">6</option>
          		<option value="7">7</option>
          		<option value="8">8</option>
          		<option value="9">9</option>
          		<option value="10">10</option>
          		<option value="11">11</option>
          		<option value="12">12</option>
          		<option value="13">13</option>
          		<option value="14">14</option>
          		<option value="15">15</option>
          		<option value="16">16</option>
          		<option value="17">17</option>
          		<option value="18">18</option>
          		<option value="19">19</option>
          		<option value="20">20</option>
          		<option value="21">21</option>
          		<option value="22">22</option>
          		<option value="23">23</option>
          		<option value="24">24</option>
          		<option value="25">25</option>
          		<option value="26">26</option>
          		<option value="27">27</option>
          		<option value="28">28</option>
          		<option value="29">29</option>
         		<option value="30">30</option>
         		<option value="31">31</option>
     		</select>
		</span>
		<span>
     		<select name="end_an" style ="font-size: 10px;background-color: #E6E6FA;">
     			<option value="2024">2030</option>
     			<option value="2024">2029</option>
     			<option value="2024">2028</option>
          		<option value="2024">2027</option>
          		<option value="2023">2026</option>
          		<option value="2022">2025</option>
          		<option value="2021">2024</option>
         	 	<option value="2020">2023</option>
         	 	<option value="2020">2022</option>
         	 	<option value="2020">2021</option>
         	 	<option value="2020">2020</option>
         	 	<option value="2020">2019</option>
         	 	<option value="2020">2018</option>
         	 	<option value="2020">2017</option>
         	 	<option value="2020">2016</option>
         	 	<option value="2020">2015</option>
         	 	<option value="2020">2014</option>
         	 	<option value="2020">2013</option>
         	 	<option value="2020">2012</option>
         	 	<option value="2020">2011</option>
         	 	<option value="2020">2010</option>
         	 	<option value="2020">2009</option>
         	 	<option value="2020">2008</option>
         	 	<option value="2020">2007</option>
         	 	<option value="2020">2006</option>
         	 	<option value="2020">2005</option>
         	 	<option value="2020">2004</option>
         	 	<option value="2020">2003</option>
         	 	<option value="2020">2002</option>
         	 	<option value="2020">2001</option>
         	 	<option value="2020">2000</option>
			</select>
		</span>
</div>
</div>
<div style="display: flex;">		
		<p><h1 style="text-align: center;font-size: 10px;">cod numeric personal</h1></p>
		<input type="text" name = "cnp" style="border: 1px solid gray; width: 100px; height: 10px;padding: 3px; padding-left: 100px;background-color: #E6E6FA; ">
</div>
<div style="display: flex;">		
		<p><h1 style="text-align: center;font-size: 10px;">domiciliat in</h1></p>
		<input type="text" name = "oras" style="border: 1px solid gray; width: 100px; height: 10px;padding: 3px; padding-left: 100px;background-color: #E6E6FA; ">
		<p><h1 style="text-align: center;font-size: 10px;">str.</h1></p>	
		<input type="text" name = "strada" style="border: 1px solid gray; width: 100px; height: 10px;padding: 3px; padding-left: 100px;background-color: #E6E6FA; ">
		<p><h1 style="text-align: center;font-size: 10px;">telefon</h1></p>
		<input type="text" name = "telefon" style="border: 1px solid gray; width: 100px; height: 10px;padding: 3px; padding-left: 100px;background-color: #E6E6FA; ">
		<p><h1 style="text-align: center;font-size: 10px;">email</h1></p>
		<input type="text" name = "email" style="border: 1px solid gray; width: 100px; height: 10px;padding: 3px; padding-left: 100px;background-color: #E6E6FA; ">	
</div>
<div style="display: flex;">		
		<p><h1 style="text-align: center;font-size: 10px;">pe durata a</h1></p>
		<input type="text" name = "ani" style="border: 1px solid gray; width: 100px; height: 10px;padding: 3px; padding-left: 100px;background-color: #E6E6FA; ">
	<span>
     		<select name="start_luna" style ="font-size: 10px;background-color: #E6E6FA;">
        		<option value="1">ani</option>
        		<option value="2">luni</option>
        		<option value="3">zile</option>
    		 </select> 
		</span>
</div>
<div style="display: flex;">		 
		<p><h1 style="text-align: center;font-size: 10px;">"Imi exprim consimtamantul expres si neconditionat la prelucrarea de catre BC "BOAP" S.A. a datelor mele cu caracter personal.Am fost informat, ca datele cu caracter personal vor fi prelucrate in scopuri legale de deservirea calitativa aferenta serviciilor bancare prestate de BC "BOAP" S.A.Declar ca am fost informat despre existenta urmatoarelor drepturi:dreptul de acces la datele cu caracter personal, dreptul de interventie asupra datelor cu caracter personal, dreptul de opozitie la prelucrarea datelor cucaracter personal, dreptul de a nu fi supus unei decizii individuale, accesul la justitie s.a. "</h1></p>
</div>
<input type="submit" style="width: 100px; height: 20px;  background-color: #008080; color: #fff;" value="Creeaza">
</form>
</body>
</html>