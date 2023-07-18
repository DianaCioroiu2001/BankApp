package com.fdm.bankApp.servlet;

import java.io.IOException;
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

/**
 * Servlet implementation class SignuUpServlet
 */
@WebServlet(urlPatterns = { "/signUpServlet" })
public class SignUpServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String numeTitular = request.getParameter("numeTitular");
		 	String moneda = request.getParameter("moneda");
		 	String cnp = request.getParameter("cnp");
	        Random random = new Random();
	        String cifre = "0123456789";
		    String randomNumber = "";
	        for (int i = 0; i < 5; i++) {
                int index = random.nextInt(cifre.length());
                char randomChar = cifre.charAt(index);
                randomNumber += randomChar;
            }
	        String email = numeTitular + randomNumber;
	        String alfabet = "abcdefghijklmnopqrstuvwxyz";
	        String randomString = "";
	        for (int i = 0; i < 10; i++) {
	                int index = random.nextInt(alfabet.length());
	                char randomChar = alfabet.charAt(index);
	                randomString += randomChar;
	            }
	        String parola = randomString;
			UserAccountEntity userAccountEntity = new UserAccountEntity(email, parola, cnp, numeTitular);	
			UserAccountEntity savedUserAccountEntity = UserAccountService.getInstance().save(userAccountEntity);
			UserAccountService.getInstance().generateOTP(email);
			RequestDispatcher rd = request.getRequestDispatcher("accountCreatedLogin.html");
			rd.forward(request, response);
	}

}
