package com.fdm.bankApp.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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


/**
 * Servlet implementation class GetList
 */
@WebServlet("/getList")
public class GetList extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String otp = request.getParameter("otp");
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		session.setAttribute("id", id);
		UserAccountEntity userAccountEntity = UserAccountService.getInstance().getUser(otp);
		String message = "Aveti " + userAccountEntity.getBankAccount().size() + " conturi bancare";
		request.setAttribute("message", message);
		List<String> messageList = new ArrayList();
		List<BankAccountEntity> list = userAccountEntity.getBankAccount();
	
		int size = list.size();
		int nrCrt = 1;
		 response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    out.println("<html>");
		    out.println("<head>");
		    out.println("<title>Titlu colorat</title>");
		    out.println("<style>");
		    out.println("body {");
		    out.println("background-color: #E6E6FA;");
		    out.println("}");
		    out.println("</style>");
		    out.println("<div style=\"display: flex;\">");
		    out.println(" <img src=\"insigna.PNG\" width=\"100\" height=\"100\">");
		    out.println("<div style=\"margin-left: 400px;\">");
		    out.println("<style>");
		    out.println("h1 { color: red; text-align: center; font-size: 50px; }");
		    out.println("</style>");
		    out.println("<style>");
		    out.println("table td { text-align: center; }");
		    out.println("</style>");
		    out.println("<div style=\"position: relative;\">");
		    out.println(" <img src=\"bankAccount.jpg\" >");
		    out.println(" <div style=\"position: absolute; top: 50%; left: 70%; transform: translate(-50%, -50%);\">");
		    out.println("</form></p>");
		    out.println(" </div>");
		    out.println("</head>");
		    out.println("<body>");
		    out.println("<table>");
		    out.println("<h1>Aveti " + size + " conturi bancare");
		    for (BankAccountEntity s : list) {
		    	 out.println("<tr><td><font size='10'>"+ nrCrt + ".  Contul cu ibanul  " +s.getIban() + " in valoare de  " + s.getSuma() + "</font></td></tr><br>");
		    
		    nrCrt++;}
		    out.println("</table>");
		    out.println("  <p><form action = \"menu\" method = \"post\" style = \"text-align: center;\">");
		    out.println("  <input type=\"submit\" style=\"width: 150px; height: 50px;  background-color: #008080; color: #fff;\" value=\"Back to menu\">");
		    out.println("</form></p>");
		    out.println("  <p><form action = \"delete\" method = \"post\" style = \"text-align: center;\">");
		    out.println("  <input type=\"submit\" style=\"width: 150px; height: 50px;  background-color: #008080; color: #fff;\" value=\"Delete an account\">");
		    out.println("</form></p>");
		    out.println("  <p><form action = \"accessAccount\" method = \"post\" style = \"text-align: center;\">");
		    out.println("  <input type=\"submit\" style=\"width: 150px; height: 50px;  background-color: #008080; color: #fff;\" value=\"Access an account\">");
		    out.println("</form></p>");
		    out.println("</body>");
		    out.println("</html>");
		
		  
	   }
	}

