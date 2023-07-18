package com.fdm.bankApp.servlet;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdm.bankApp.dao.entities.BankAccountEntity;
import com.fdm.bankApp.dao.entities.TransactionsEntity;
import com.fdm.bankApp.service.BankAccountService;

import java.util.List;

/**
 * Servlet implementation class AccessAccountServlet
 */
@WebServlet("/accessAccountServlet")
public class AccessAccountServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String iban = request.getParameter("iban");
	HttpSession session = request.getSession();
	int id = (int) session.getAttribute("id");
	session.setAttribute("iban", iban);
	BankAccountEntity bae = null;
	if(BankAccountService.getInstance().getUserByIbanBank(iban) == bae) {
		String message  = "Contul cu ibanul introdus nu exista";
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("messageDeleteError.jsp");
		rd.forward(request, response);
	}
	BankAccountEntity bankAccountEntity = BankAccountService.getInstance().getUserByIbanBank(iban);
	List<TransactionsEntity> listTransactions = bankAccountEntity.getTransactionsEntity();
	int size = listTransactions.size();
	int idUser = bankAccountEntity.getUserAccountEntity().getId();
	double suma = bankAccountEntity.getSuma();
	String moneda = bankAccountEntity.getMoneda();
	for(int i=0; i<size; i++) {
		request.setAttribute("suma"+i , listTransactions.get(i).getSuma());
		request.setAttribute("zi"+i , listTransactions.get(i).getZi());
		request.setAttribute("luna"+i , listTransactions.get(i).getLuna());
		request.setAttribute("an"+i , listTransactions.get(i).getAn());
		request.setAttribute("nume"+i , listTransactions.get(i).getNume());
		request.setAttribute("iban"+i , listTransactions.get(i).getIban());
		request.setAttribute("tip"+i , listTransactions.get(i).getTip());
		request.setAttribute("ora"+i , listTransactions.get(i).getOra());
		request.setAttribute("minutes"+i , listTransactions.get(i).getMinutes());
	}
	
	request.setAttribute("suma", suma);
	request.setAttribute("moneda", moneda);
	request.setAttribute("listTransactions", listTransactions);
	request.setAttribute("size", size);
	if(id == idUser) {
	RequestDispatcher rd = request.getRequestDispatcher("access.jsp");
	rd.forward(request, response);
	}else {
		String message  = "Contul cu ibanul introdus nu va apartine";
		request.setAttribute("message", message);
		RequestDispatcher rd = request.getRequestDispatcher("messageDeleteError.jsp");
		rd.forward(request, response);
	}

}
}
