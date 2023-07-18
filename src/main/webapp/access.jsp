	1<!DOCTYPE html>
<html>
<head>
  <style>
    /* Stilurile pentru bara de meniuri */
    .menu-bar {
      background-color: #008080;
      color: #fff;
      padding: 10px;
      display: flex;
      justify-content: center;
      align-items: center;
    }
    
    .menu-bar button {
      background-color: #008080;
      color: #fff;
      border: none;
      cursor: pointer;
      padding: 10px 100px;
      font-size: 40px;
      margin-right: 10px;
    }
    
    /* Stilurile pentru butonul selectat */
    .menu-bar button.active {
      background-color: #fff;
      color: #333;
    }
    
    /* Stilurile pentru conținutul din partea de jos a paginii */
    .content {
      padding: 20px;
      display: block;
      justify-content: center;
      align-items: center;
      flex-direction: column;
    }
    
    .content-section {
      display: none;
    }
    
   .content-section.active {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }
  
    
    .button-container {
      margin-top: 20px;
    }
  </style>
  <script>
    // Funcția JavaScript pentru a schimba conținutul când se apasă pe un buton
    function changeContent(sectionId) {
      var sections = document.getElementsByClassName("content-section");
      for (var i = 0; i < sections.length; i++) {
        sections[i].classList.remove("active");
      }
      
      var selectedSection = document.getElementById(sectionId);
      selectedSection.classList.add("active");
      
      var buttons = document.getElementsByTagName("button");
      for (var i = 0; i < buttons.length; i++) {
        buttons[i].classList.remove("active");
      }
      
      var selectedButton = document.getElementById(sectionId + "-button");
      selectedButton.classList.add("active");
    }
  </script>
</head>
<%
   String iban = (String)session.getAttribute("iban");
session.setAttribute("iban", iban);
%>
<body>
  <div class="menu-bar">
    <button id="section1-button" onclick="changeContent('section1')">Cont</button>
    <button id="section2-button" onclick="changeContent('section2')">Transferuri</button>
    <button id="section3-button" onclick="changeContent('section3')">Tranzactii</button>
    <button id="section4-button" onclick="changeContent('section4')">Carduri</button>
    <button id="section5-button" onclick="changeContent('section5')">Credite</button>
  </div>
  

    <div id="section1" class="content-section active">
     <p><h1 style=" font-size: 70px;">Suma detinuta in cont este </h1></p>
      <p> <p class="text-large;"style="text-align: center; font-size: 70px;">${suma}</p></p>
      
      <p> <p class="text-large;"style="text-align: center; font-size: 70px;">${moneda}</p></p><br>
     </div>
      <div id="section2" class="content-section active">
    <form action="addMoney" method="post"style="text-align: center;">
        <input type="submit" style="width: 700px; height: 80px;display: block; background-color: #008080; color: #fff;" value="Adauga bani">
        </form> 
        <form action="transferMoney" method="post"style="text-align: center;">
         <input type="submit" style="width: 700px; height: 80px; background-color: #008080; color: #fff;" value="Transfera bani">
</form> 
     </div>
       <div id="section3" class="content-section active">
    <p><h1 style=" font-size: 70px;">Tranzactii:</h1></p>
 <%
    for (int i=0; i< (int) request.getAttribute("size"); i++) {
%>
    <div>
        <p>Ati primit suma: <%= request.getAttribute("suma"+i) %> in data de: <%= request.getAttribute("zi"+i) %> <%= request.getAttribute("luna"+i) %> <%= request.getAttribute("an"+i) %> de la <%= request.getAttribute("nume"+i) %> cu ibanul <%= request.getAttribute("iban"+i) %> stare <%= request.getAttribute("tip"+i) %> la ora <%= request.getAttribute("ora"+i) %> si <%= request.getAttribute("minutes"+i) %> minute.</p>
    </div>
<%
    }
%>
     </div>

      	
   
   
    <div id="section4" class="content-section">
    <img src="CARDboap.PNG" width="300" height="150"><br>
     <form action="createABankAccount" method="post"style="text-align: center;">
        <input type="submit" style="width: 700px; height: 80px;display: block; background-color: #008080; color: #fff;" value="Obtine un card nou">
        </form> 
      
    </div>
    
    <div id="section5" class="content-section">
    <img src="download.jpg" width="300" height="150"><br>
     <form action="formular" method="post"style="text-align: center;">
        <input type="submit" style="width: 700px; height: 80px;display: block; background-color: #008080; color: #fff;" value="Obtine un credit">
        </form> 
    </div>
    
    
  
</body>
</html>