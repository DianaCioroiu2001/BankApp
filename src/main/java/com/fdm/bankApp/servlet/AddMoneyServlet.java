package com.fdm.bankApp.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
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
import com.fdm.bankApp.dao.entities.TransactionsEntity;
import com.fdm.bankApp.service.BankAccountService;
import com.fdm.bankApp.service.TransactionsService;
import com.fdm.bankApp.service.UserAccountService;

/**
 * Servlet implementation class addMoneyServlet
 */
@WebServlet("/addMoneyServlet")
public class AddMoneyServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		double suma = Double.parseDouble(request.getParameter("suma"));
		String moneda = (String) request.getParameter("moneda");
		String ibanContulMeu = (String) session.getAttribute("iban");
		BankAccountEntity baeMeu = BankAccountService.getInstance().getUserByIbanBank(ibanContulMeu);
		int idMeu=baeMeu.getUserAccountEntity().getId();
		String numeleMeu = UserAccountService.getInstance().getUserById(idMeu).getNume();
		String ibanTrimite = (String) request.getParameter("ibanTrimite");
		BankAccountEntity baeTrimite = null ;
		if(BankAccountService.getInstance().getUserByIbanBank(ibanTrimite) == baeTrimite) {
			String message = "Contul cu ibanul introdus nu exista";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("errorMessageAddMoney.jsp");
			rd.forward(request, response);
		} else
			 baeTrimite = BankAccountService.getInstance().getUserByIbanBank(ibanTrimite);
		int  idTrimite = baeTrimite.getUserAccountEntity().getId();
		String numeTrimite = UserAccountService.getInstance().getUserById(idTrimite).getNume();
		LocalDate data = LocalDate.now();
		LocalTime time = LocalTime.now();
		String tipTrimite = "Trimis";
		String tipEu = "Primit";
		int zi = data.getDayOfMonth();
		int luna = data.getMonthValue();
		int an = data.getYear();
		int ora = time.getHour();
		int minutes= time.getMinute();
		
		if(moneda.equals("euro"))
			suma = suma * 4.9;
		if(moneda.equals("USD"))
			suma = suma * 4.64;
		
		if(baeTrimite.getMoneda().equals("lei"))
		if(baeTrimite.getSuma() < suma) {
			String message = "Contul cu ibanul introdus nu are suficienti bani";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("errorMessageAddMoney.jsp");
			rd.forward(request, response);
		}
		if(baeTrimite.getMoneda().equals("euro"))
			if(baeTrimite.getSuma()*4.9 < suma) {
				String message = "Contul cu ibanul introdus nu are suficienti bani";
				request.setAttribute("message", message);
				RequestDispatcher rd = request.getRequestDispatcher("errorMessageAddMoney.jsp");
				rd.forward(request, response);
			}
		if(baeTrimite.getMoneda().equals("USD"))
			if(baeTrimite.getSuma()*4.64 < suma) {
				String message = "Contul cu ibanul introdus nu are suficienti bani";
				request.setAttribute("message", message);
				RequestDispatcher rd = request.getRequestDispatcher("errorMessageAddMoney.jsp");
				rd.forward(request, response);
			}
		if(baeTrimite.getId() == baeMeu.getId()) {
			String message = "Nu puteti adauga bani din acelasi cont";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("errorMessageAddMoney.jsp");
			rd.forward(request, response);
		}
		
	
		
		TransactionsEntity transactionsEntityTrimite = new TransactionsEntity(suma, zi, luna, an, numeleMeu, ibanContulMeu,tipTrimite, ora, minutes, baeTrimite);
		TransactionsEntity savedTransactionsEntity = TransactionsService.getInstance().save(transactionsEntityTrimite);
		List<TransactionsEntity> transactionsList = new ArrayList();
		transactionsList.add(savedTransactionsEntity);
		baeTrimite.setTransactionsEntity(transactionsList);
		if(baeTrimite.getMoneda().equals("lei")) {
		baeTrimite.setSuma(baeTrimite.getSuma()-suma);
		baeTrimite = BankAccountService.getInstance().update(baeTrimite);
		}
		if(baeTrimite.getMoneda().equals("euro")) {
			baeTrimite.setSuma(baeTrimite.getSuma()-(suma / 4.9));
			baeTrimite = BankAccountService.getInstance().update(baeTrimite);
		}
		if(baeTrimite.getMoneda().equals("USD")) {
			baeTrimite.setSuma(baeTrimite.getSuma()-(suma/4.64));
			baeTrimite = BankAccountService.getInstance().update(baeTrimite);
		}
		TransactionsEntity transactionsEntityPrimmit = new TransactionsEntity(suma, zi, luna, an, numeTrimite, ibanTrimite,tipEu, ora, minutes, baeMeu);
		TransactionsEntity savedTransactionsEntityPrimit = TransactionsService.getInstance().save(transactionsEntityPrimmit);
		List<TransactionsEntity> transactionsListPrimit = new ArrayList();
		transactionsListPrimit.add(savedTransactionsEntityPrimit);
		baeMeu.setTransactionsEntity(transactionsListPrimit);
		if(baeMeu.getMoneda().equals("lei")) {
			baeMeu.setSuma(baeMeu.getSuma()+suma);
			baeMeu = BankAccountService.getInstance().update(baeMeu);
		}
			if(baeMeu.getMoneda().equals("euro")) {
				baeMeu.setSuma(baeMeu.getSuma()+(suma/4.9));
				baeMeu = BankAccountService.getInstance().update(baeMeu);
			}
			if(baeMeu.getMoneda().equals("USD")) {
				baeMeu.setSuma(baeMeu.getSuma()+(suma/4.64));
				baeMeu = BankAccountService.getInstance().update(baeMeu);
			}
			RequestDispatcher rd = request.getRequestDispatcher("tranzactieAcceptata.jsp");
			rd.forward(request, response);
			System.out.println("sumaTrimite= " + baeTrimite.getSuma());
			System.out.println("sumaPrimeste= " + baeMeu.getSuma());
		
			
}
}
