package com.fdm.bankApp.servlet;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fdm.bankApp.dao.entities.UserAccountEntity;
import com.fdm.bankApp.service.UserAccountService;
@WebServlet(urlPatterns = { "/userAccountServlet" })
public class UserAccountServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String nume = request.getParameter("nume");
		 	String prenume = request.getParameter("prenume");
		 	int luna = Integer.parseInt(request.getParameter("luna"));
		 	int ziua = Integer.parseInt(request.getParameter("ziua"));
		 	int an = Integer.parseInt(request.getParameter("an"));
			String numeTitular = request.getParameter("numeTitular");
			String prenumeTitular = request.getParameter("prenumeTitular");
		 	String moneda = request.getParameter("moneda");
		 	String cnp = request.getParameter("cnp");
		 	String seria = request.getParameter("seria");
		 	String number = request.getParameter("numarul");
		 	String eliberat = request.getParameter("eliberat");
		 	int start_luna = Integer.parseInt(request.getParameter("start_luna"));
		 	int start_ziua = Integer.parseInt(request.getParameter("start_ziua"));
		 	int start_an = Integer.parseInt(request.getParameter("start_an"));
		 	int end_luna = Integer.parseInt(request.getParameter("end_luna"));
		 	int end_ziua = Integer.parseInt(request.getParameter("end_ziua"));
		 	int end_an = Integer.parseInt(request.getParameter("end_an"));
		 	String oras = request.getParameter("oras");
		 	String strada  =request.getParameter("strada");
		 	String telefon = request.getParameter("telefon");
		 	String email = request.getParameter("email");
		 	LocalDate startData = LocalDate.of(start_an, start_luna, start_ziua);
		 	LocalDate endData = LocalDate.of(end_an, end_luna, end_ziua);
	        Random random = new Random();
	        String cifre = "0123456789";
		    String randomNumber = "";
		    String message = "";
		   String suma =(String)request.getParameter("suma");
		    int error = 0;
	        for (int i = 0; i < 5; i++) {
                int index = random.nextInt(cifre.length());
                char randomChar = cifre.charAt(index);
                randomNumber += randomChar;
            }
	        String username = numeTitular + randomNumber;
	        String alfabet = "abcdefghijklmnopqrstuvwxyz";
	        String randomString = "";
	        for (int i = 0; i < 10; i++) {
	                int index = random.nextInt(alfabet.length());
	                char randomChar = alfabet.charAt(index);
	                randomString += randomChar;
	            }
	        String parola = randomString;
	        if(!UserAccountService.getInstance().verifyNume(nume)) {
	        	message = "Numele este invalid!Acesta trebuie sa contina doar litere!";
	        	request.setAttribute("message", message);
	        	error++;
				RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
				rd.forward(request, response);
	        } 
	        if(!UserAccountService.getInstance().verifyNume(prenume)) {
	        	message = "Prenumele este invalid!Acesta trebuie sa contina doar litere!";
	        	request.setAttribute("message", message);
	        	error++;
				RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
				rd.forward(request, response);
	        } 
	        if(!UserAccountService.getInstance().verifyDataCreareCont(an, luna, ziua)) {
	        	LocalDate dataCreareCont = LocalDate.now();
	        	System.out.println("data acum este = " + dataCreareCont);
	        	message = "Data creare cont este invalida.Aceasta trebuie sa fie mai tarziu de ";
	        	request.setAttribute("dataCreareCont", dataCreareCont);
	        	request.setAttribute("message", message);
	        	error++;
				RequestDispatcher rd = request.getRequestDispatcher("errorMessageWithData.jsp");
				rd.forward(request, response);
	        }
	        if(!UserAccountService.getInstance().verifyNume(numeTitular)) {
	        	message = "Numele Titularului este invalid!Acesta trebuie sa contina doar litere!";
	        	request.setAttribute("message", message);
	        	error++;
				RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
				rd.forward(request, response);
	        } 
	        if(!UserAccountService.getInstance().verifyNumeTitular(numeTitular)) {
	        	message = "Deja exista un cont cu acest nume al titularului";
	        	request.setAttribute("message", message);
	        	error++;
				RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
				rd.forward(request, response);
	        } 
	        if(!UserAccountService.getInstance().verifyNume(prenumeTitular)) {
	        	message = "Prenumele Titularului este invalid!Acesta trebuie sa contina doar litere!";
	        	request.setAttribute("message", message);
	        	error++;
				RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
				rd.forward(request, response);
	        } 
	        if(!UserAccountService.getInstance().verifySeries(seria)) {
	        	message = "Seria este invalida!";
	        	request.setAttribute("message", message);
	        	error++;
				RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
				rd.forward(request, response);
	        } 
	        if(!UserAccountService.getInstance().verifyNumberSeries(number)) {
	        	message = "Numarul seriei este invalid!";
	        	request.setAttribute("message", message);
	        	error++;
				RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
				rd.forward(request, response);
	        }
	        if(!UserAccountService.getInstance().verifyNume(eliberat)) {
	        	message = "Numele institutiei care a eliberat buletinul este invalid!Acesta trebuie sa contina doar litere!";
	        	request.setAttribute("message", message);
	        	error++;
				RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
				rd.forward(request, response);
	        }
	        if(!UserAccountService.getInstance().verifyStartData(startData)) {
	        	message = "Data valabilitatii buletinului este invalida!";
	        	request.setAttribute("message", message);
	        	error++;
				RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
				rd.forward(request, response);
	        }
	        if(!UserAccountService.getInstance().verifyEndData(endData)) {
	        	message = "Data valabilitatii buletinului este invalida!";
	        	request.setAttribute("message", message);
	        	error++;
				RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
				rd.forward(request, response);
	        }if(!UserAccountService.getInstance().verifyNumeTitular(numeTitular)) {
	        	message = "Deja exista un cont cu acest nume al titularului";
	        	request.setAttribute("message", message);
	        	error++;
				RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
				rd.forward(request, response);
	        } 
	        if(!UserAccountService.getInstance().verifyExistCnp(cnp)) {
	        	message = "Deja exista un cont cu acest cnp!";
	        	request.setAttribute("message", message);
	        	error++;
				RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
				rd.forward(request, response);
	        }
	        if(!UserAccountService.getInstance().verifyNume(oras)) {
	        	message = "Numele orasului este invalid!";
	        	request.setAttribute("message", message);
	        	error++;
				RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
				rd.forward(request, response);
	        }
	        if(!UserAccountService.getInstance().verifyNume(strada)) {
	        	message = "Numele strazii este invalid!";
	        	request.setAttribute("message", message);
	        	error++;
				RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
				rd.forward(request, response);
	        }
	        if(!UserAccountService.getInstance().verifyPhoneNumber(telefon)) {
	        	message = "Numarul de telefon este incorect!";
	        	request.setAttribute("message", message);
	        	error++;
				RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
				rd.forward(request, response);
	        }
	        if(!UserAccountService.getInstance().verifySuma(suma)) {
	        	message = "Suma introdusa este incorecta!";
	        	request.setAttribute("message", message);
	        	error++;
				RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
				rd.forward(request, response);
	        }
	        if(!UserAccountService.getInstance().verifyEmail(email)) {
	        	message = "Adresa de email este incorecta!";
	        	request.setAttribute("message", message);
	        	error++;
				RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
				rd.forward(request, response);
	        }
	        if(error == 0) {
			UserAccountEntity userAccountEntity = new UserAccountEntity(username, parola, cnp, numeTitular);	
			UserAccountEntity savedUserAccountEntity = UserAccountService.getInstance().save(userAccountEntity);
			int id = userAccountEntity.getId();
			String otp = UserAccountService.getInstance().generateOTP(username);
			request.setAttribute("username", username);
			request.setAttribute("cnp", cnp);
			request.setAttribute("moneda", moneda);
			request.setAttribute("id", id);
			request.setAttribute("suma", suma);
			RequestDispatcher rd = request.getRequestDispatcher("bankAccountServlet");
			rd.forward(request, response);
	        }
	}
}