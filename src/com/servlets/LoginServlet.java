package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {


	public boolean authenticate(String id, String password)
	{
		// Authenticate the User using the passed arguments
		return true;
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		if(authenticate((String)request.getParameter("id") , (String)request.getParameter("pwd")))
		{
			HttpSession session = request.getSession();
			session.setAttribute("loggedIn", true);
			System.out.println("User Authenticated");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage.html");
			dispatcher.forward(request,response);
		}
	}
}
