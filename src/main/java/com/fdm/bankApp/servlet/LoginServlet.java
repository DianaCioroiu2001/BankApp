package com.fdm.bankApp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdm.bankApp.service.UserAccountService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		if(UserAccountService.getInstance().verifyCredentials(email, password)) {
			int id = UserAccountService.getInstance().getUserAccount(email).getId();
			System.out.println("AICI E ID " + id);
			request.setAttribute("id", id);
			RequestDispatcher rd = request.getRequestDispatcher("menuConectare.jsp");
			rd.forward(request, response);
		} else {
			
			RequestDispatcher rd = request.getRequestDispatcher("errorMessageLogIn.jsp");
			rd.forward(request, response);
		}
		 }
}
