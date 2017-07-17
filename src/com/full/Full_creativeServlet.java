package com.full;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Full_creativeServlet extends HttpServlet {
	String password;
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession();
		String user_name = req.getParameter("user_name");
		String user_pass = req.getParameter("user_pass");
		password=SignUp.password(user_name);
		if(password!="0")
		{
		if (user_name == "" && user_pass == "") {
			session.setAttribute("invalid_login", "empty fields are not allowed");
			req.getRequestDispatcher("/invalid_loginpage.jsp").include(req, resp);
		} else if (user_name.equals(user_name) && user_pass.equals(password)) {
			session.setAttribute("invalid_login", user_name);
			req.getRequestDispatcher("/welcome.jsp").include(req, resp);
		} else {
			session.setAttribute("invalid_login", "wrong details please check your details and try again..!");
			req.getRequestDispatcher("/invalid_loginpage.jsp").include(req, resp);
		}
		}
		else{
			session.setAttribute("invalid_login", "Sorry data base is empty please sigup firsst..!");
			req.getRequestDispatcher("/invalid_loginpage.jsp").include(req, resp);
		}
	}

	@SuppressWarnings("null")
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null || session.getAttribute("invalid_login") != null)
			req.getRequestDispatcher("/welcome.jsp").include(req, resp);
		else {
			req.getRequestDispatcher("/").include(req, resp);
		}
	}

}
