package com.fdm.bankApp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdm.bankApp.dao.entities.BankAccountEntity;
import com.fdm.bankApp.dao.entities.TransactionsEntity;
import com.fdm.bankApp.dao.entities.UserAccountEntity;
import com.fdm.bankApp.service.BankAccountService;
import com.fdm.bankApp.service.TransactionsService;
import com.fdm.bankApp.service.UserAccountService;

/**
 * Servlet implementation class deleteAccountServlet
 */
@WebServlet("/deleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iban = request.getParameter("iban");
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		BankAccountEntity bankAccountEntity = BankAccountService.getInstance().getUserByIbanBank(iban);
		
		int idUser = bankAccountEntity.getUserAccountEntity().getId();
		System.out.println("id= " + id);
		System.out.println("idUser= " + idUser);
		if(id == idUser) {
	
		if(bankAccountEntity!=null) {
			TransactionsEntity transactions2 = null;
		TransactionsEntity transactions = TransactionsService.getInstance().getTransactionsById(idUser);
		if(transactions != transactions2) {
		TransactionsService.getInstance().delete(transactions);
		}
		BankAccountService.getInstance().delete(bankAccountEntity);
		RequestDispatcher rd = request.getRequestDispatcher("messageDelete.html");
		rd.forward(request, response);
		} else
		{
			String message  = "Contul cu ibanul introdus nu exista";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("messageDeleteError.jsp");
			rd.forward(request, response);
		}
		}
		else {
			String message  = "Contul cu ibanul introdus nu va apartine";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("messageDeleteError.jsp");
			rd.forward(request, response);
		}
	}

}

