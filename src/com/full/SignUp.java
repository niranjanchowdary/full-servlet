package com.full;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class SignUp extends HttpServlet {

static final HashMap<String, String> mapobj=new HashMap<>();
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession();
		String user_name = req.getParameter("user_name1");
		String user_pass = req.getParameter("user_pass1");
		String user_pass1 = req.getParameter("user_pass11");
		
		DatastoreService ds=DatastoreServiceFactory.getDatastoreService();
		Entity e= new Entity("Login_sigin_up",user_name);
		if(user_pass.equals(user_pass1) && (user_name!=null&&user_name!=""&&user_pass!=""&&user_pass1!="")){
		e.setProperty("user_name",user_name);
		e.setProperty("user_password", user_pass);
		ds.put(e);
		}
		System.out.println(e);
		if (user_name == "" || user_pass == "" || user_pass1 == "") {
			session.setAttribute("invalid_signup", "empty fields are not allowed");
			req.getRequestDispatcher("/invalid_signup_page.jsp").include(req, resp);
		}else if (user_name!="" && user_pass!=""&&user_pass1!=""&&!(user_pass.equals(user_pass1))) {
			session.setAttribute("invalid_signup", "please check your password it should match");
			req.getRequestDispatcher("/invalid_signup_page.jsp").include(req, resp);
		}
		else if (user_name!="" && user_pass!=""&&user_pass1!=""&&user_pass.equals(user_pass1)) {
			
			if(mapobj.containsKey(user_name)){
				session.setAttribute("invalid_signup", "user is already exist in this page");
				req.getRequestDispatcher("/invalid_signup_page.jsp").include(req, resp);	
			}
			else{
			mapobj.put(user_name, user_pass);
			session.setAttribute("invalid_login", user_name);
			req.getRequestDispatcher("/welcome.jsp").include(req, resp);
		}}



	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("invalid_sigup") != null)
			req.getRequestDispatcher("/welcome.jsp").include(req, resp);
		else {
			req.getRequestDispatcher("/").include(req, resp);
		}
}
	

	public static String password(String user_name) {
		// TODO Auto-generated method stub
		
		 String password;
			if(!mapobj.isEmpty()){
				if(mapobj.containsKey(user_name))
					password= mapobj.get(user_name);
				else
				password="-1";
				return password;
			}
			else
			return "0";

	}
	
}