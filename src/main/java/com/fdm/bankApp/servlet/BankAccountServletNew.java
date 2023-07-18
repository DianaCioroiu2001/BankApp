package com.fdm.bankApp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdm.bankApp.dao.entities.BankAccountEntity;
import com.fdm.bankApp.dao.entities.UserAccountEntity;
import com.fdm.bankApp.service.BankAccountService;
import com.fdm.bankApp.service.UserAccountService;


@WebServlet("/bankAccountServletNew")
public class BankAccountServletNew extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String cnp = request.getParameter("cnp");
		String oras = request.getParameter("oras");
		String strada = request.getParameter("strada");
		String moneda = request.getParameter("moneda");
		String suma = (String) request.getParameter("suma");
		String message = "";
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		session.setAttribute("id", id);
		String cnpUser = UserAccountService.getInstance().getUserById(id).getCnp();
		System.out.println("cnp = " + cnp);
		System.out.println("cnpUser = " + cnpUser);
		if(!UserAccountService.getInstance().verifyEmail(email)) {
			message = "Adresa de email este invalida!";
        	request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
			rd.forward(request, response);
		}
		 if(!UserAccountService.getInstance().verifySuma(suma)) {
	        	message = "Suma introdusa este incorecta!";
	        	request.setAttribute("message", message);
				RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
				rd.forward(request, response);
	        }
		if(!UserAccountService.getInstance().verifyCnp(cnp)) {
			message = "Cnp-ul este invalid!";
        	request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
			rd.forward(request, response);
		}
		if(!UserAccountService.getInstance().verifyNume(oras)) {
			message = "Numele orasului este invali";
        	request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
			rd.forward(request, response);
		}
		if(!UserAccountService.getInstance().verifyNume(strada)) {
			message = "Numele strazii este invalid";
        	request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("errorMessage.jsp");
			rd.forward(request, response);
		}
		Double s = Double.parseDouble(suma);
			if(UserAccountService.getInstance().getUserByCnp(cnp)!=null && cnpUser.equals(cnp)) {
			String iban = BankAccountService.getInstance().getIban();
			UserAccountEntity userAccountEntity = UserAccountService.getInstance().getUserByCnp(cnp);
			BankAccountEntity bankAccountEntity = new BankAccountEntity(iban, moneda, s, userAccountEntity );
			BankAccountEntity savedBankAccountEntity = BankAccountService.getInstance().save(bankAccountEntity);
			List<BankAccountEntity> bankList = new ArrayList();
			bankList.add(savedBankAccountEntity);
			userAccountEntity.setBankAccount(bankList);
			request.setAttribute("id", id);
			RequestDispatcher rd = request.getRequestDispatcher("accountCreatedBank.jsp");
			rd.forward(request, response);
		}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("accountCreatedBankError.html");
				rd.forward(request, response);
				
			}
	}
	}


