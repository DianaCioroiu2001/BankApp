package com.fdm.bankApp.servlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fdm.bankApp.service.SessionUtils;
import com.fdm.bankApp.service.UserAccountService;
@WebServlet("/signUpOtpServlet")
public class SignUpOtpServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String otp = request.getParameter("otp");
		HttpSession session = request.getSession();
		int id = (int) session.getAttribute("id");
		session.setAttribute("id", id);
		if(UserAccountService.getInstance().verifyCredentialsId(otp, id)) {
			RequestDispatcher rd = request.getRequestDispatcher("createBankAccount.jsp");
			rd.forward(request, response);
		} else {
			String message  = "Datele nu sunt  corecte";
			request.setAttribute("message", message);
			RequestDispatcher rd = request.getRequestDispatcher("errorMessageSignUp.jsp");
			rd.forward(request, response);
		}
	}
}